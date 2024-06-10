package com.example.foodieapp.services;

import com.example.foodieapp.entity.Restaurant;
import com.example.foodieapp.entity.Review;
import com.example.foodieapp.entity.ReviewRate;
import com.example.foodieapp.repository.RestaurantRepository;
import com.example.foodieapp.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
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

    public Map<Map<Review, BigDecimal>, Restaurant> findAllReviews() {
        return reviewRepository.findAllByReview().stream()
                .collect(Collectors.toMap(this::addRatingToReview, Review::getRestaurant));
    }

    public Map<Map<Review, BigDecimal>, Restaurant> findAllReviewsOfUser() {
        List<Review> reviews = reviewRepository.findAllByReview().stream()
                .filter(e -> e.getUser().equals(userService.loggedUser())).toList();
        return reviews.stream()
                .collect(Collectors.toMap(this::addRatingToReview, Review::getRestaurant));
    }


    public BigDecimal ratingAvg(Review review) {
        int sum = getAllRatings(review).stream().mapToInt(Integer::intValue).sum();
        double avg = (double) sum / getAllRatings(review).size();
        BigDecimal bd = BigDecimal.valueOf(avg);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd;
    }

    public List<Integer> getAllRatings(Review review) {
        return List.of(review.getRatingService(),
                review.getRatingVibe(),
                review.getRatingFood(),
                review.getRatingGenExperience());
    }

    public Map<Review, BigDecimal> addRatingToReview(Review review) {
        return Map.of(review, ratingAvg(review));
    }

//    public Map<Map<Review, Double>, Restaurant> findReviewCombo(Long id) {
//        Map<Map<Review, BigDecimal>, Restaurant> map = findAllReviews();
//        return map.entrySet().stream().filter(reviewRating -> reviewRating.getKey().keySet().stream()
//                        .anyMatch(review -> review.getId().equals(reviewRepository.getById(id))))
//                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
//    }

    public Map<Review,BigDecimal> findReviewMap(Long id){
        Review review = reviewRepository.getById(id);;
        return Map.of(review, ratingAvg(review));
    }


    public ReviewRate findReview(Long id){
        return new ReviewRate(reviewRepository.getById(id), ratingAvg(reviewRepository.getById(id)));
    }





}
