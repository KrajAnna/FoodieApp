package com.example.foodieapp.controller;

import com.example.foodieapp.entity.*;
import com.example.foodieapp.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/app")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/signup")
    public String loginForm(@Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "home/signup-form";
        } else {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashedPassword);
            userRepository.save(user); //w jakim miejscu sprawdzic, czy mail nie jest zajety?
            return "redirect:/home"; // TBD - przekierowanie do głownego widoku apki po zalogowaniu
        }
    }




}
