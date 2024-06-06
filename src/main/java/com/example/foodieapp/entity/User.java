package com.example.foodieapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 2)
    private String firstName;
    //walidajca nullable =false, min liczba znaków
    @NotNull
    @Size(min = 2)
    private String lastName;
    //walidacja hasla?
    @NotBlank
    private String password;
    @Email
    @NotBlank
    private String email;

    @ManyToMany
    private List<Review> reviews;

    @OneToMany
    private List<User> followingList;

}
