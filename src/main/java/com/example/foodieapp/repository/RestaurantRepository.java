package com.example.foodieapp.repository;

import com.example.foodieapp.entity.Restaurant;
import com.example.foodieapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Restaurant findFirstById(Long id);
//    Optional<Restaurant> findById(Long id);
//    Restaurant getById(Long id);

}
