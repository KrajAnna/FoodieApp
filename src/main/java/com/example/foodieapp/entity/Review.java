package com.example.foodieapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Table(name = "reviews")
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private LocalDate date; //automatycznie dodana podczas zapisu
    private int ratingFood; // miedzy 1-10
    private int ratingService; // miedzy 1-10
    private int ratingVibe; // miedzy 1-10
    private int ratingGenExperience; // miedzy 1-10
    private String description;

    @ManyToOne
    private User user;

    @ManyToOne
    private Restaurant restaurant;


}
