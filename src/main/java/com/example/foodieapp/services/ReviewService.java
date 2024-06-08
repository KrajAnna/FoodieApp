package com.example.foodieapp.services;

import com.example.foodieapp.entity.Restaurant;
import com.example.foodieapp.entity.Review;
import com.example.foodieapp.repository.RestaurantRepository;
import com.example.foodieapp.repository.ReviewRepository;
import com.example.foodieapp.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
//@Transactional
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final UserService userService;

    public double ratingAvg() {
        return 0;
    }

    public void addReview(Review review) {
        review.setUser(userService.loggedUser());
        reviewRepository.save(review);
    }

    public List<Review> findAllReview() {
        return reviewRepository.findAll();
    }

    public void addReviewToRestaurant(Review review, Long restaurantId) {
        review.setRestaurant(restaurantRepository.getById(restaurantId));
        review.setUser(userService.loggedUser());
        reviewRepository.save(review);
    }

    public Map<Review,Restaurant> findAllReviewUser(){
        List<Review> reviews = reviewRepository.findAllByUser(userService.loggedUser());
        return reviews.stream().collect(Collectors.toMap(review -> review, Review::getRestaurant));
    }

    public Map<Review,Restaurant> findAllReviewRestaurant(){
        List<Review> reviews = reviewRepository.findAllByReview();
        return reviews.stream().collect(Collectors.toMap(review -> review, Review::getRestaurant));
    }


}
