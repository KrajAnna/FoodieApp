package com.example.foodieapp.repository;

import com.example.foodieapp.entity.Restaurant;
import com.example.foodieapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Restaurant findFirstById(Long id);
}
