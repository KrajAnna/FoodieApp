package com.example.foodieapp.services;

import lombok.RequiredArgsConstructor;
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

//    public int sumAllReviewsOfUser() {
//        return reviewService.findAllReviewsOfUser().size();
//    }

//    public Map<YearMonth, Long> sumAllReviewsOfUserLastMonth() {
//        return reviewService.findAllReviewsOfUser().stream()
//                .collect(Collectors.groupingBy(r -> YearMonth.from(r.getReview().getDate()), Collectors.counting()));
//    }


//    public Map<Year, Long> sumAllReviewsOfUserLastYear() {
//        return reviewService.findAllReviewsOfUser().stream()
//                .collect(Collectors.groupingBy(r -> Year.from(r.getReview().getDate()), Collectors.counting()));
//    }

//    public BigDecimal sumAllRatesOfUser() {
//        return reviewService.findAllReviewsOfUser().stream()
//                .map(r -> reviewService.ratingAvg(r.getReview()))
//                .reduce(BigDecimal.ZERO, BigDecimal::add)
//                .divide(BigDecimal.valueOf(sumAllReviewsOfUser()), 2, BigDecimal.ROUND_HALF_UP); //średnia średniej :(
//    }
}
