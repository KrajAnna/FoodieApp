package com.example.foodieapp.repository;

import com.example.foodieapp.entity.Restaurant;
import com.example.foodieapp.entity.Review;
import com.example.foodieapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT r FROM Review r JOIN FETCH r.restaurant WHERE r.user = :user")
    List <Review> findAllByUser(@Param("user") User user);
    @Query("SELECT r FROM Review r JOIN FETCH r.restaurant")
    List<Review> findAllByReview();

}
