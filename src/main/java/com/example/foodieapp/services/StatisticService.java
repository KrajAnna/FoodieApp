package com.example.foodieapp.services;

import com.example.foodieapp.entity.User;
import com.example.foodieapp.repository.ReviewRepository;
import com.example.foodieapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Year;
import java.time.YearMonth;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatisticService {
    private final ReviewService reviewService;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    public int sumAllReviewsOfUser(UserDetails userDetails) {
        return reviewService.findAllReviewsOfUser(userDetails).size();
    }
    public int sumAllReviewsByUserId(UserDetails userDetails) {
        User user = userRepository.getByEmail(userDetails.getUsername());
        return reviewRepository.countReviewsByUserId(user.getId());
      
    }

    public Map<YearMonth, Long> sumAllReviewsOfUserLastMonth(UserDetails userDetails) {
        return reviewService.findAllReviewsOfUser(userDetails).stream()
                .filter(rr-> rr.getReview().getDate() != null)
                .collect(Collectors.groupingBy(r -> YearMonth.from(r.getReview().getDate()), Collectors.counting()));
    }


    public Map<Year, Long> sumAllReviewsOfUserLastYear(UserDetails userDetails) {
        return reviewService.findAllReviewsOfUser(userDetails).stream()
                .filter(rr-> rr.getReview().getDate() != null)
                .collect(Collectors.groupingBy(r -> Year.from(r.getReview().getDate()), Collectors.counting()));
    }

    public BigDecimal sumAllRatesOfUser(UserDetails userDetails) {
        return reviewService.findAllReviewsOfUser(userDetails).stream()
                .map(r -> reviewService.ratingAvg(r.getReview()))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(sumAllReviewsOfUser(userDetails)), 2, BigDecimal.ROUND_HALF_UP); //średnia średniej :(
    }
}
