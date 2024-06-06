package com.example.foodieapp.controller;

import com.example.foodieapp.entity.Restaurant;
import com.example.foodieapp.entity.Review;
import com.example.foodieapp.entity.User;
import com.example.foodieapp.repository.RestaurantRepository;
import com.example.foodieapp.repository.ReviewRepository;
import com.example.foodieapp.services.DummyUserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/reviews")
@Controller
public class ReviewController {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final DummyUserService userService;

    public ReviewController(ReviewRepository reviewRepository, RestaurantRepository restaurantRepository, DummyUserService userService) {
        this.reviewRepository = reviewRepository;
        this.restaurantRepository = restaurantRepository;
        this.userService = userService;
    }
    @ModelAttribute("userId")
    public Long userId() {
        return userService.findId();
    }

    @ModelAttribute("restaurants")
    public List<Restaurant> restaurants() {
        return restaurantRepository.findAll();
    }
    @ModelAttribute("user")
    public User user() {
        return userService.dummyUser();
    }

    @GetMapping("")
    public String mainReviewView(Model model) {
        model.addAttribute("reviews", reviewRepository.findAll());
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
        reviewRepository.save(review);
        return "dashboard/review-main";
    }


}
