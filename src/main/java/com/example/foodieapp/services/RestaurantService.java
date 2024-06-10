package com.example.foodieapp.services;

import com.example.foodieapp.entity.Restaurant;
import com.example.foodieapp.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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
    public Pair<Restaurant,BigDecimal> pairRestaurantRate(Restaurant restaurant){
        return Pair.of(restaurant, calculateRestaurantRate(restaurant));
    }
    public List<Pair<Restaurant,BigDecimal>> findAllRestaurantWithRating(){
        return findAllRestaurants().stream()
                .map(this::pairRestaurantRate)
                .toList();
    }

    public List<ReviewRate> findAllReviewsOfRestaurant(Restaurant restaurant){
        return reviewService.findAllReviews().stream()
                .filter(review -> review.getReview().getRestaurant().equals(restaurant))
                .toList();
    }


}
