package com.example.foodieapp.services;

import com.example.foodieapp.entity.Restaurant;
import com.example.foodieapp.entity.Review;
import com.example.foodieapp.repository.RestaurantRepository;
import com.example.foodieapp.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    public ReviewService(ReviewRepository reviewRepository, RestaurantRepository restaurantRepository) {
        this.reviewRepository = reviewRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public double ratingAvg( ){
        return 0;
    }

    public void addReview(Review review){
        reviewRepository.save(review);
    }

    public List<Review> findAllReview(){
        return reviewRepository.findAll();
    }

    public void addReviewToRestaurant(Review review, Long restaurantId){
        review.setRestaurant(restaurantRepository.getById(restaurantId));
        reviewRepository.save(review);
    }
}
