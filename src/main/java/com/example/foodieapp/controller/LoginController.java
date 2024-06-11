package com.example.foodieapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "home/login-form";
    }

    @GetMapping("/login/fail")
    public String loginFailedPage() {
        return "home/login-failed";
    }



}
