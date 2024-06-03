package com.example.foodieapp.services;

import org.springframework.stereotype.Service;

@Service
public class DummyUserService implements UserService {

    @Override
    public Long findId() {
        return 5L;
    }
}
