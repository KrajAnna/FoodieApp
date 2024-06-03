package com.example.foodieapp.repository;

import com.example.foodieapp.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail (String email);

}
