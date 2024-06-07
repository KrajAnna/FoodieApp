package com.example.foodieapp.repository;

import com.example.foodieapp.entity.Restaurant;
import com.example.foodieapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Restaurant findFirstById(Long id);
//    Optional<Restaurant> findById(Long id);
//    Restaurant getById(Long id);

}
