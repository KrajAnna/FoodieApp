package com.example.foodieapp.controller;

import com.example.foodieapp.entity.Restaurant;
import com.example.foodieapp.entity.Review;
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


    @ModelAttribute("restaurants")
    public List<Restaurant> restaurants() {
        return restaurantService.findAllRestaurants();
    }

    @GetMapping("")
    public String yourReviewView(Model model) {
        model.addAttribute("userReviews", reviewService.findAllReviewsOfUser());
        return "dashboard/review-user";
    }

    @GetMapping("/all")
    public String allReviewView(Model model) {
        model.addAttribute("reviewsRat", reviewService.findAllReviews());
        return "dashboard/review-all";
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

    @GetMapping("/{reviewId}")
    public String checkReview(@PathVariable Long reviewId, Model model) {
        model.addAttribute("reviewRate", reviewService.findReview(reviewId));
        return "dashboard/review-details";

    }


}
