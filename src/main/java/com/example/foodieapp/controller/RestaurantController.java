package com.example.foodieapp.controller;

import com.example.foodieapp.entity.Restaurant;
import com.example.foodieapp.entity.Review;
import com.example.foodieapp.entity.User;
import com.example.foodieapp.repository.RestaurantRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.time.LocalDate;

@RequestMapping("/places")
@Controller
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("")
    public String mainPlacesView(Model model) {
        model.addAttribute("places", restaurantRepository.findAll());
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
