package com.example.foodieapp.controller;

import com.example.foodieapp.entity.Restaurant;
import com.example.foodieapp.entity.User;
import com.example.foodieapp.repository.RestaurantRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

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
        return "dashboard/place-added";
    }


}
