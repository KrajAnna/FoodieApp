package com.example.foodieapp.services;

import com.example.foodieapp.entity.Review;
import com.example.foodieapp.repository.RestaurantRepository;
import com.example.foodieapp.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

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

    public void addReviewToRestaurant(Review review, Long restaurantId) {
        review.setRestaurant(restaurantRepository.getById(restaurantId));
        review.setUser(userService.loggedUser());
        reviewRepository.save(review);
    }

    public List<ReviewRate> findAllReviews() {
        return reviewRepository.findAllByReview().stream()
                .map(this::addRatingToReview)
                .toList();
    }

    public List<ReviewRate> findAllReviewsOfUser(){
        return reviewRepository.findAllByReview().stream()
                .filter(review -> review.getUser().equals(userService.loggedUser()))
                .map(this::addRatingToReview)
                .toList();
    }

    public BigDecimal ratingAvg(Review review) {
        int sum = getAllRatings(review).stream().mapToInt(Integer::intValue).sum();
        double avg = (double) sum / getAllRatings(review).size();
        BigDecimal bd = BigDecimal.valueOf(avg);
        return bd.setScale(2, RoundingMode.HALF_UP);
    }

    public List<Integer> getAllRatings(Review review) {
        return List.of(review.getRatingService(),
                review.getRatingVibe(),
                review.getRatingFood(),
                review.getRatingGenExperience());
    }

    public ReviewRate addRatingToReview(Review review) {
        return new ReviewRate(review, ratingAvg(review));
    }


    public ReviewRate findReview(Long id){
        return new ReviewRate(reviewRepository.getById(id), ratingAvg(reviewRepository.getById(id)));
    }





}
