package com.example.foodieapp.controller;

import com.example.foodieapp.entity.User;
import com.example.foodieapp.utils.CurrentUserProvider;
import com.example.foodieapp.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final CurrentUserProvider currentUserProvider;

    @ModelAttribute("user")
    protected User getModelUser( @AuthenticationPrincipal UserDetails userDetails){
        return currentUserProvider.getCurrentLoggedUser();
    }

    @GetMapping("")
    public String helloUser(Model model) {
        return "dashboard/user-details";
    }

    @GetMapping("/edit")
    public String editUser(Model model) {
        return "dashboard/user-edit-form";
    }

    @PostMapping("/edit")
    public String editUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "dashboard/user-edit-form";
        }
        userService.editUser(user);
        return "dashboard/user-details";
    }
}
