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
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class StatisticService {
    private final ReviewService reviewService;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;



    public int sumAllReviewsByUserId(UserDetails userDetails) {
        User user = userRepository.getByEmail(userDetails.getUsername());
        return reviewRepository.countReviewsByUserId(user.getId());
    }

    public Map<YearMonth, Long> sumAllReviewsOfUserLastMonth(UserDetails userDetails) {
        return reviewService.findAllReviewsOfUser(userDetails).stream()
                .filter(r-> r.getReview().getDate() != null)
                .collect(Collectors.groupingBy(r -> YearMonth.from(r.getReview().getDate()), Collectors.counting()));
    }


    public Map<Year, Long> sumAllReviewsOfUserLastYear(UserDetails userDetails) {
        return reviewService.findAllReviewsOfUser(userDetails).stream()
                .filter(rr-> rr.getReview().getDate() != null)
                .collect(Collectors.groupingBy(r -> Year.from(r.getReview().getDate()), Collectors.counting()));
    }

    public BigDecimal sumAllRatesOfUser(UserDetails userDetails) {
        BigDecimal totalRating = reviewService.findAllReviewsOfUser(userDetails).stream()
                .map(r -> reviewService.ratingAvgForStats(r.getReview()))
                .flatMap(r-> r.isPresent() ? Stream.of(r.get()) : Stream.empty() )
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return sumAvgRatesOfUser(totalRating, sumAllReviewsByUserId(userDetails));

    }

    public BigDecimal sumAvgRatesOfUser (BigDecimal bd, int sum){
        if (bd.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        } else {
            return bd.divide(BigDecimal.valueOf(sum),2,BigDecimal.ROUND_HALF_UP);
        }
    }


}
