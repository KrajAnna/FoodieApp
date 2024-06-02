package com.example.foodieapp.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
//    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    private List<Review> reviews;

}
