package com.example.foodieapp.utils;

import com.example.foodieapp.entity.User;
import com.example.foodieapp.repository.UserRepository;
import lombok.Data;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Data
@Component
public class CurrentUserProvider {

    private final UserRepository userRepository;


    private UserDetails getUserDetails() {
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public User getCurrentUser() {
        String email = getCurrentUserEmail();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public String getCurrentUserEmail() {
        return Optional.ofNullable(getUserDetails())
                .map(UserDetails::getUsername)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }


    public Long getCurrentUserId() {
        String email = getCurrentUserEmail();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"))
                .getId();
    }


    public User getCurrentLoggedUser() {
        String email = getCurrentUserEmail();
        return userRepository.getByEmail(email);
    }




}
