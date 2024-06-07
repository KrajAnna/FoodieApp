package com.example.foodieapp.services;

import com.example.foodieapp.entity.User;
import com.example.foodieapp.repository.UserRepository;
import com.example.foodieapp.security.Role;
import com.example.foodieapp.security.RoleEntity;
import com.example.foodieapp.security.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

}
