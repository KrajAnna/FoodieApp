package com.example.foodieapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/response")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @GetMapping("/widok")
    public String helloWidok(){
        return "home";
    }

}
