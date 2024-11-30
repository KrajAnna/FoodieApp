package com.example.foodieapp.repository;

import com.example.foodieapp.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstById(Long id);

    User findUserByEmail(String email);


    Optional<User> findByEmail(String email);
    User getByEmail (String email);

}
