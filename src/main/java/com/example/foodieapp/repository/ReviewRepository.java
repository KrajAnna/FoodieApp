package com.example.foodieapp.repository;

import com.example.foodieapp.entity.Review;
import com.example.foodieapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List <Review> findAllByUser(User user);


}
