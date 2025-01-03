package com.example.foodieapp.services;

import com.example.foodieapp.entity.Restaurant;
import com.example.foodieapp.entity.User;
import com.example.foodieapp.repository.UserRepository;
import com.example.foodieapp.security.Role;
import com.example.foodieapp.security.RoleEntity;
import com.example.foodieapp.security.RoleRepository;

import com.example.foodieapp.security.UserForAccess;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        RoleEntity userRole = roleRepository.findByName(Role.USER);
        user.setRoles(Set.of(userRole));
        userRepository.save(user);
    }

    public void editUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public String getCurrentUserEmail(UserDetails userDetails) {
        if (userDetails != null) {
            return userDetails.getUsername();
        }
        return null;
    }

    public Long getCurrentUserId(UserDetails userDetails) {
        String email = Optional.ofNullable(userDetails)
                .map(UserDetails::getUsername)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return userRepository.findByEmail(email).get().getId();
    }


}
