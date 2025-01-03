package com.example.foodieapp.services;

import com.example.foodieapp.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ReviewRate {
    private Review review;
    private BigDecimal rating;
    private boolean editable;

}
