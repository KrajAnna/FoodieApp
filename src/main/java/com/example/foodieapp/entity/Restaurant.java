package com.example.foodieapp.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Data
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    @OneToMany
    private List<Review> reviews;
}
