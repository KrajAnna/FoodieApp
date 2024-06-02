package com.example.foodieapp.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    //walidajca nullable =false, min liczba znaków
    private String lastName;
    //walidacja hasla?
    private String password;
    @Email
    private String email;
//    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    private List<Review> reviews;

}
