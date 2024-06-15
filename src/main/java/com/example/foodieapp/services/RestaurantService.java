package com.example.foodieapp.services;

import com.example.foodieapp.entity.Restaurant;
import com.example.foodieapp.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final ReviewService reviewService;

    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    public List<Restaurant> findAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant findRestaurantById(Long id) {
        return restaurantRepository.getById(id);
    }

    public BigDecimal calculateRestaurantRate(Restaurant restaurant){
        return findAllReviewsOfRestaurant(restaurant).stream()
                .map(ReviewRate::getRating)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<ReviewRate> findAllReviewsOfRestaurant(Restaurant restaurant){
        return reviewService.findAllReviews().stream()
                .filter(review -> review.getReview().getRestaurant().equals(restaurant))
                .toList();
    }

    public List<ReviewRate> findAllReviewsByRestaurantId(Long restaurantId){
        return reviewService.findAllReviews().stream()
                .filter(review -> review.getReview().getRestaurant().getId().equals(restaurantId))
                .toList();
    }

    public Map<Restaurant,BigDecimal> restaurantRateMap(){
        return findAllRestaurants().stream()
                .collect(Collectors.toMap(r->r, this::calculateRestaurantRate));
    }



}
