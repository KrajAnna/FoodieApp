package com.example.foodieapp.controller;

import com.example.foodieapp.entity.Restaurant;
import com.example.foodieapp.services.StatisticService;
import lombok.RequiredArgsConstructor;
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

//    @ModelAttribute("reviewsTotal")
//    public int reviewsTotal() {
//        return statisticService.sumAllReviewsOfUser();
//    }

//    @ModelAttribute("reviewsMonths")
//    public Map<YearMonth, Long> reviewsMonths() {
//        return statisticService.sumAllReviewsOfUserLastMonth();
//    }
//
//    @ModelAttribute("reviewsYears")
//    public Map<Year, Long> reviewsYear() {
//        return statisticService.sumAllReviewsOfUserLastYear();
//    }
//    @ModelAttribute("avgRate")
//    public BigDecimal reviewsAvg() {
//        return statisticService.sumAllRatesOfUser();
//    }


    @GetMapping
    public String showSummary(Model model){
        return "dashboard/summary-details";
    }
}
