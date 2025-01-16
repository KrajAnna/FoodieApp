package com.example.foodieapp.controller;

import com.example.foodieapp.entity.Restaurant;
import com.example.foodieapp.entity.Review;
import com.example.foodieapp.services.RestaurantService;
import com.example.foodieapp.utils.ReviewRate;
import com.example.foodieapp.services.ReviewService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
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
    public String yourReviewView(Model model) {
        model.addAttribute("reviewRates", reviewService.findAllReviewsOfUser());
        return "dashboard/review-user";
    }

    @GetMapping("/all")
    public String allReviewView(Model model) {
        model.addAttribute("reviewRates", reviewService.findAllReviews());
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
            return "dashboard/review-add-form"; //
        }
        reviewService.addReview(review);
        return "dashboard/review-welcome";
    }

    @GetMapping("/{reviewId}")
    public String checkReview(@PathVariable Long reviewId, Model model) {
        try {
            ReviewRate reviewRate = reviewService.findReview(reviewId);
            model.addAttribute("reviewRate", reviewRate);
            return "dashboard/review-details";
        } catch (EntityNotFoundException e){
            return "dashboard/forbidden";
        }
    }

    @GetMapping("/{reviewId}/edit")
    public String editReviewForm(@PathVariable Long reviewId, Model model) {
        try {
            Review review = reviewService.findReviewRaw(reviewId);
            model.addAttribute("review", review);
            return "dashboard/review-edit-form";
        } catch (EntityNotFoundException e) {
            return "dashboard/forbidden";
        } catch (AccessDeniedException e){
            return "dashboard/forbidden";
        }
    }
    @PostMapping("/{reviewId}/edit")
    public String editReview(@PathVariable Long reviewId, @Valid Review review, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            review = reviewService.findReviewRaw(reviewId);
            model.addAttribute("review", review);
            return "dashboard/review-edit-form"; //
        }
        reviewService.addReview(review);
        return "dashboard/review-edit-welcome";
    }
}
