package com.example.foodieapp.controller;

import com.example.foodieapp.entity.Restaurant;
import com.example.foodieapp.entity.Review;
import com.example.foodieapp.security.SpringUserDetailsService;
import com.example.foodieapp.services.RestaurantService;
import com.example.foodieapp.services.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/reviews")
@Controller
@RequiredArgsConstructor
public class ReviewController {
    private final RestaurantService restaurantService;
    private final ReviewService reviewService;
    private final SpringUserDetailsService springUserDetailsService;


    @ModelAttribute("restaurants")
    public List<Restaurant> restaurants() {
        return restaurantService.findAllRestaurants();
    }

    @GetMapping("")
    public String mainReviewView(Model model) {
        model.addAttribute("reviews", reviewService.findAllReview());
        return "dashboard/review-main";
    }

    @GetMapping("/add")
    public String displayAddReviewForm(Model model) {
        model.addAttribute("review", new Review());
        return "dashboard/review-add-form";
    }

    @PostMapping("/add")
    public String addNewReview(@Valid Review review, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "dashboard/review-add-form"; // TBD - unikalne nazwy w bazie danych
        }
        reviewService.addReview(review);
        return "dashboard/review-welcome";
    }


}
