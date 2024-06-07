package com.example.foodieapp.controller;

import com.example.foodieapp.entity.Restaurant;
import com.example.foodieapp.entity.Review;
import com.example.foodieapp.repository.RestaurantRepository;
import com.example.foodieapp.services.RestaurantService;
import com.example.foodieapp.services.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/places")
@Controller
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final ReviewService reviewService;

    @ModelAttribute("restaurants")
    public List<Restaurant> restaurants() {
        return restaurantService.findAllRestaurants();
    }

    @GetMapping("")
    public String mainPlacesView() {
        return "dashboard/place-main";
    }

    @GetMapping("/add")
    public String displayAddForm(Model model) {
        model.addAttribute("restaurant", new Restaurant());
        return "dashboard/place-add-form";
    }

    @PostMapping("/add")
    public String addNewPlace(@Valid Restaurant restaurant, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "dashboard/place-add-form"; // TBD - unikalne nazwy w bazie danych
        }
        restaurantService.addRestaurant(restaurant);
        return "dashboard/place-welcome";
    }

    @GetMapping("/review/{restaurantId}")
    public String displayAddReviewForm(@PathVariable Long restaurantId, Model model) {
        model.addAttribute("restaurant", restaurantService.findRestaurantById(restaurantId));
        model.addAttribute("review", new Review());
        return "dashboard/place-add-review-form";
    }

    @PostMapping("/review/{restaurantId}")
    public String addReviewToRestaurant(@PathVariable Long restaurantId, @Valid Review review, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "dashboard/place-add-review-form";
        }
        reviewService.addReviewToRestaurant(review, restaurantId);//
        return "dashboard/review-welcome";
    }

}
