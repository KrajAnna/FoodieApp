package com.example.foodieapp.services;

import com.example.foodieapp.entity.Restaurant;
import com.example.foodieapp.exception.RestaurantAlreadyExistsException;
import com.example.foodieapp.repository.RestaurantRepository;
import com.example.foodieapp.utils.ReviewRate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final ReviewService reviewService;

    public void addRestaurant(Restaurant restaurant) {
        if (!checkIfRestaurantAlreadyAdded(restaurant)) {
            restaurantRepository.save(restaurant);
        } else {
            throw new RestaurantAlreadyExistsException(
                    "Restaurant " + restaurant.getName() + " already exists.");
        }
    }

    public boolean checkIfRestaurantAlreadyAdded (Restaurant restaurant){
        Optional<Restaurant> addedRestaurant = restaurantRepository.findByName(restaurant.getName());
        return addedRestaurant.isPresent();
    }

    public List<Restaurant> findAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public List<Restaurant> sortRestaurants(){
        return findAllRestaurants().stream()
                .sorted(Comparator.comparing(Restaurant::getName))
                .toList();
    }

    public Restaurant findRestaurantById(Long id) {
        return restaurantRepository.getReferenceById(id);
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

