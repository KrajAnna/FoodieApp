package com.example.foodieapp.services;

import com.example.foodieapp.entity.User;
import com.example.foodieapp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class DummyUserService   {

    private final UserRepository userRepository;

    public DummyUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Long findId() {
        return 5L;
    }

    public User dummyUser(){
        return userRepository.findFirstById(findId());
    }



}
