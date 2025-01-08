package com.example.foodieapp.controller;

import com.example.foodieapp.exception.UserAlreadyExistsException;
import com.example.foodieapp.repository.UserRepository;
import com.example.foodieapp.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import com.example.foodieapp.entity.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/signup")
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;

    @GetMapping("")
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "home/signup-form";
    }

    @PostMapping("")
    public String loginForm(@Valid User user, BindingResult bindingResult, Model model) {
        try{
            if (bindingResult.hasErrors()) {
                return "home/signup-form";
            }
            userService.saveUser(user);
            model.addAttribute("user", user);
            return "home/signup-welcome";
        } catch (UserAlreadyExistsException e){
            model.addAttribute("massage", e.getMessage());
            return "home/user-add-error";
        }
    }
}
