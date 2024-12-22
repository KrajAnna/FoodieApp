package com.example.foodieapp.services;

import com.example.foodieapp.entity.Review;
import com.example.foodieapp.entity.User;
import com.example.foodieapp.repository.RestaurantRepository;
import com.example.foodieapp.repository.ReviewRepository;
import com.example.foodieapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;
    private final UserService userService;


    public void addReview(Review review, UserDetails userDetails) {
        User user = userRepository.getByEmail(userDetails.getUsername());
        review.setUser(user);
        reviewRepository.save(review);
    }

    public void addReviewToRestaurant(Review review, Long restaurantId, UserDetails userDetails) {
        User user = userRepository.getByEmail(userDetails.getUsername());
        review.setRestaurant(restaurantRepository.getReferenceById(restaurantId));
        review.setUser(user);
        reviewRepository.save(review);
    }

    public List<ReviewRate> findAllReviews() {
        return reviewRepository.findAllByReview().stream()
                .map(this::addRatingToReview)
                .toList();
    }

    public List<ReviewRate> findAllReviewsOfUser(UserDetails userDetails) {
        return reviewRepository.findAllByReview().stream()
                .filter(review -> review.getUser().equals(userRepository.getByEmail(userDetails.getUsername())))
                .map(this::addRatingToReview)
                .toList();
    }


    public BigDecimal ratingAvg(Review review) {
        int sum = getAllRatings(review).stream().mapToInt(Integer::intValue).sum();
        double avg = (double) sum / getAllRatings(review).size();
        BigDecimal bd = BigDecimal.valueOf(avg);
        return bd.setScale(2, RoundingMode.HALF_UP);
    }

    public Optional <BigDecimal> ratingAvgForStats(Review review) {
        List<Integer> ratings = getAllRatings(review);
        if (ratings.isEmpty()) {
            return Optional.empty();
        }
        int sum = getAllRatings(review).stream().mapToInt(Integer::intValue).sum();
        double avg = (double) sum / getAllRatings(review).size();
        BigDecimal bd = BigDecimal.valueOf(avg);
        return Optional.of(bd.setScale(2, RoundingMode.HALF_UP));
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


    public ReviewRate findReview(Long id, UserDetails userDetails) {
        Review review = reviewRepository.getReferenceById(id);
        if(review.getUser().getEmail().equals(userDetails.getUsername())){
            return new ReviewRate(review, ratingAvg(review));
        }
        return null;
    }



}
