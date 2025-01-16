package com.example.foodieapp.controller;

import com.example.foodieapp.entity.Restaurant;
import com.example.foodieapp.entity.Review;
import com.example.foodieapp.exception.RestaurantAlreadyExistsException;
import com.example.foodieapp.services.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@RequestMapping("/places")
@Controller
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final ReviewService reviewService;
    private final UserService userService;

    @ModelAttribute("restaurants")
    public List<Restaurant> restaurants() {
        return restaurantService.findAllRestaurants();
    }

    @GetMapping
    public String mainPlacesView(Model model) {

        return "dashboard/place-main";
    }

    @GetMapping("/add")
    public String displayAddForm(Model model) {
        model.addAttribute("restaurant", new Restaurant());
        return "dashboard/place-add-form";
    }

    @PostMapping("/add")
    public String addNewPlace(@Valid Restaurant restaurant, BindingResult bindingResult, Model model) {
        try {
            if (bindingResult.hasErrors()) {
                return "dashboard/place-add-form";
            }
            restaurantService.addRestaurant(restaurant);
            return "dashboard/place-welcome";
        } catch (RestaurantAlreadyExistsException e) {
            model.addAttribute("massage", e.getMessage());
            return "dashboard/place-add-error";
        }

    }

    @GetMapping("/{restaurantId}")
    public String displayRestaurantDetails(@PathVariable Long restaurantId, Model model) {
        model.addAttribute("reviewRates", restaurantService.findAllReviewsByRestaurantId(restaurantId));
        model.addAttribute("restaurant", restaurantService.findRestaurantById(restaurantId));
        return "dashboard/place-details";
    }

    @GetMapping("/review/{restaurantId}")
    public String displayAddReviewForm(@PathVariable Long restaurantId, Model model) {
        model.addAttribute("restaurant", restaurantService.findRestaurantById(restaurantId));
        model.addAttribute(new Review());
        return "dashboard/place-add-review-form";
    }

    @PostMapping("/review/{restaurantId}")
    public String addReviewToRestaurant(@PathVariable Long restaurantId, @Valid Review review, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
        if (bindingResult.hasErrors()) {
            return "dashboard/place-add-review-form";
        }
        reviewService.addReviewToRestaurant(review, restaurantId, userDetails);//
        return "dashboard/review-welcome";
    }

}
