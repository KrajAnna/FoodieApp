package com.example.foodieapp.controller;

import com.example.foodieapp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("")
    public String helloUser(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        model.addAttribute("user", userService.loggedUser(userDetails));
        return "dashboard/user-details";
    }
}
