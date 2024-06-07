package com.example.foodieapp.security;

import com.example.foodieapp.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class UserForAccess implements UserDetails {
    private final String password;
    private final String username;
    private final Set<GrantedAuthority> authorities;

    private final static String AUTHORITY_PREFIX = "ROLE_";

    static UserForAccess fromEntity(User user) {
        var authorities = user.getRoles().stream()
                .map(RoleEntity::getName)
                .map(UserForAccess::getAuthority)
                .collect(Collectors.toSet());

        return new UserForAccess(user.getPassword(), user.getEmail(), authorities);
    }

    public static GrantedAuthority getAuthority(Role role) {
        return new SimpleGrantedAuthority(AUTHORITY_PREFIX + role.name());
    }


}
