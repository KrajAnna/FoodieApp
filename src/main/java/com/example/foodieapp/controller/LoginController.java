package com.example.foodieapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @GetMapping(value = {"/login"})
    public String displayLoginForm() {
        return "home/login-form";
    }

//    @PostMapping("/login")
//    public String
}
