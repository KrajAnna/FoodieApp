package com.example.foodieapp.controller;

import org.springframework.stereotype.Controller;
import com.example.foodieapp.entity.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("")
    public String helloApp(){
        return "home/home-page";
    }

    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("user", new User());
        return "home/signup-form";
    }




}
