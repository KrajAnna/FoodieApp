package com.example.foodieapp.controller;

import com.example.foodieapp.entity.Restaurant;
import com.example.foodieapp.entity.Review;
import com.example.foodieapp.services.RestaurantService;
import com.example.foodieapp.services.ReviewRate;
import com.example.foodieapp.services.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
        return restaurantService.sortRestaurants();
    }

    @GetMapping("")
    public String yourReviewView(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        model.addAttribute("reviewRates", reviewService.findAllReviewsOfUser(userDetails));
        return "dashboard/review-user";
    }

    @GetMapping("/all")
    public String allReviewView(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        model.addAttribute("reviewRates", reviewService.findAllReviews());
        return "dashboard/review-all";
    }

    @GetMapping("/add")
    public String displayAddReviewForm(Model model) {
        model.addAttribute("review", new Review());
        return "dashboard/review-add-form";
    }

    @PostMapping("/add")
    public String addNewReview(@Valid Review review, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
        if (bindingResult.hasErrors()) {
            return "dashboard/review-add-form"; //
        }
        reviewService.addReview(review, userDetails);
        return "dashboard/review-welcome";
    }

    @GetMapping("/{reviewId}")
    public String checkReview(@PathVariable Long reviewId, Model model, @AuthenticationPrincipal UserDetails userDetails ) {
        ReviewRate reviewRate = reviewService.findReview(reviewId,  userDetails);
        if (reviewRate != null){
            model.addAttribute("reviewRate", reviewRate);
            return "dashboard/review-details";
        }
        return "dashboard/forbidden";


    }


}
