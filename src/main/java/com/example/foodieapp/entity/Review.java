package com.example.foodieapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "reviews")
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date; //automatycznie dodana podczas zapisu
    private int ratingFood; // miedzy 1-10
    private int ratingService; // miedzy 1-10
    private int ratingRestaurant; // miedzy 1-10
    private int ratingGenExperience; // miedzy 1-10
    private double ratingAvg;
    private String description;
    @ManyToMany(mappedBy = "reviews")
    private List<User> users;

    @ManyToOne
    private Restaurant restaurant;
    @PrePersist
    @PreUpdate
    public void calculateAvgRating() {
        double sum = ratingFood + ratingService + ratingRestaurant + ratingGenExperience;
        ratingAvg = sum / 4.0;
    }

}
