package com.example.foodieapp.entity;

import com.example.foodieapp.security.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;
import java.util.Set;

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
    @Size(min = 5)
    private String password;
    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @OneToMany (mappedBy = "user")
    private List<Review> reviews;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles;


}
