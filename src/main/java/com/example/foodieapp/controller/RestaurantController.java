package com.example.foodieapp.controller;

import com.example.foodieapp.entity.Restaurant;
import com.example.foodieapp.entity.Review;
import com.example.foodieapp.entity.User;
import com.example.foodieapp.repository.RestaurantRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/places")
@Controller
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }
    @ModelAttribute("restaurants")
    public List<Restaurant> restaurants() {
        return restaurantRepository.findAll();
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
        restaurantRepository.save(restaurant);
        return "dashboard/place-welcome";
    }

    @GetMapping("/review/{restaurantId}")
    public String displayAddReviewForm(@PathVariable Long restaurantId, Model model) {
        model.addAttribute("restaurantId", restaurantId);
        model.addAttribute("currentDate", LocalDate.now());
        model.addAttribute("restaurantName", restaurantRepository.findFirstById(restaurantId).getName());
        model.addAttribute("review", new Review());
        return "dashboard/place-add-review-form";
    }


}
