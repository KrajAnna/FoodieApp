package com.example.foodieapp.controller;

import com.example.foodieapp.repository.UserRepository;

public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
