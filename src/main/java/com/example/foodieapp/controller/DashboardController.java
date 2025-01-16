package com.example.foodieapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class DashboardController {

    @GetMapping("")
    public String welcomeApp() {
        return "home/home-page";
    }

    @GetMapping("/about")
    public String aboutApp() {
        return "dashboard/about-page";
    }


}
