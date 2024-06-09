package com.example.foodieapp.services;

import com.example.foodieapp.entity.Restaurant;
import com.example.foodieapp.entity.Review;
import com.example.foodieapp.repository.RestaurantRepository;
import com.example.foodieapp.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public Map<Map<Review, Double>, Restaurant> findAllReviews() {
        return reviewRepository.findAllByReview().stream()
                .collect(Collectors.toMap(this::addRatingToReview, Review::getRestaurant));
    }

    public Map<Map<Review, Double>, Restaurant> findAllReviewsOfUser() {
        List<Review> reviews = reviewRepository.findAllByReview().stream()
                .filter(e -> e.getUser().equals(userService.loggedUser())).toList();
        return reviews.stream()
                .collect(Collectors.toMap(this::addRatingToReview, Review::getRestaurant));
    }


    public double ratingAvg(Review review) {
        double sum = getAllRatings(review).stream().mapToInt(Integer::intValue).sum();
        return sum / getAllRatings(review).size();
    }

    public Set<Integer> getAllRatings(Review review) {
        Set<Integer> set = new HashSet<>();
        set.add(review.getRatingService());
        set.add(review.getRatingVibe());
        set.add(review.getRatingFood());
        set.add(review.getRatingGenExperience());
        return set;
    }

    public Map<Review, Double> addRatingToReview(Review review) {
        return Map.of(review, ratingAvg(review));
    }

    public Map<Map<Review, Double>, Restaurant> findReviewCombo(Long id) {
        Map<Map<Review, Double>, Restaurant> map = findAllReviews();
        return map.entrySet().stream().filter(reviewRating -> reviewRating.getKey().keySet().stream()
                        .anyMatch(review -> review.getId().equals(reviewRepository.getById(id))))
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
    }

    public Map<Review,Double> findReview(Long id){
        Review review = reviewRepository.getById(id);;
        return Map.of(review, ratingAvg(review));
    }




}
