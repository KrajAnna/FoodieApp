package com.example.foodieapp.services;

import com.example.foodieapp.entity.Review;
import com.example.foodieapp.entity.User;
import com.example.foodieapp.repository.RestaurantRepository;
import com.example.foodieapp.repository.ReviewRepository;
import com.example.foodieapp.repository.UserRepository;
import com.example.foodieapp.utils.CurrentUserProvider;
import com.example.foodieapp.utils.ReviewRate;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;
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
    private final CurrentUserProvider currentUserProvider;


    public void addReview(Review review) {
        User user = currentUserProvider.getCurrentUser();
        review.setUser(user);
        reviewRepository.save(review);
    }

    public void addReviewToRestaurant(Review review, Long restaurantId, UserDetails userDetails) {
        User user = currentUserProvider.getCurrentUser();
        review.setRestaurant(restaurantRepository.getReferenceById(restaurantId));
        review.setUser(user);
        reviewRepository.save(review);
    }

    public List<ReviewRate> findAllReviews() {
        return reviewRepository.findAllByReview().stream()
                .map(this::addRatingToReview)
                .toList();
    }

    public List<ReviewRate> findAllReviewsOfUser() {
        return reviewRepository.findAllByReview().stream()
                .filter(review -> review.getUser().equals(currentUserProvider.getCurrentUser()))
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
        return new ReviewRate(review, ratingAvg(review), true);
    }


    public ReviewRate findReview(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Entity Not Found"));
        boolean isEditable = review.getUser().equals(currentUserProvider.getCurrentUser());
        return new ReviewRate(review,ratingAvg(review),isEditable);
    }

    public Review findReviewRaw(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Entity Not Found"));
        if (!review.getUser().equals(currentUserProvider.getCurrentUser())){
            throw new  AccessDeniedException("You do not have permission to view this content");
        }
        return review;
    }

    public ReviewRate findReviewToEdit(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Entity Not Found"));
        if (!review.getUser().equals(currentUserProvider.getCurrentUser())){
            throw new  AccessDeniedException("You do not have permission to view this content");
        }
        return new ReviewRate(review,ratingAvg(review),true);

    }




}
