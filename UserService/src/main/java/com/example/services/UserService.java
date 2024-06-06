package com.example.services;

import com.example.models.User;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    // This is a sample method used to log in a user
    public User logIn(String name, String email, String password) {
        // Create a new user object and return it
        User user = new User();
        user.setId(1);
        user.setUsername(name);
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }
}
