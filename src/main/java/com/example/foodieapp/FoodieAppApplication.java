package com.example.foodieapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FoodieAppApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FoodieAppApplication.class, args);
    }

}
