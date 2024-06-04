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
    private int rating; // miedzy 1-10
    private String description;
    @ManyToMany(mappedBy = "reviews")
    private List<User> users;

    @ManyToOne
    private Restaurant restaurant;

}
