package com.example.foodieapp.controller;

import com.example.foodieapp.entity.Restaurant;
import com.example.foodieapp.services.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.time.Year;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;

@RequestMapping("/summary")
@Controller
@RequiredArgsConstructor
public class StatisticController {
    private final StatisticService statisticService;

    @ModelAttribute("reviewsTotal")
    protected int reviewsTotal( @AuthenticationPrincipal UserDetails userDetails) {
        return statisticService.sumAllReviewsByUserId(userDetails);
    }

    @ModelAttribute("reviewsMonths")
    protected Map<YearMonth, Long> reviewsMonths( @AuthenticationPrincipal UserDetails userDetails) {
        return statisticService.sumAllReviewsOfUserLastMonth(userDetails);
    }

    @ModelAttribute("reviewsYears")
    protected Map<Year, Long> reviewsYear( @AuthenticationPrincipal UserDetails userDetails) {
        return statisticService.sumAllReviewsOfUserLastYear(userDetails);
    }
    @ModelAttribute("avgRate")
    protected BigDecimal reviewsAvg( @AuthenticationPrincipal UserDetails userDetails) {
        return statisticService.sumAllRatesOfUser(userDetails);
    }

    @GetMapping
    public String showSummary(Model model){
        return "dashboard/summary-details";
    }


}
