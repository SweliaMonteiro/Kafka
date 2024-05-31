package com.example.services;

import com.example.exceptions.UserNotFoundException;
import com.example.models.User;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    // This is a sample method which is used to get the user details by id
    public User getUserById(long id) throws UserNotFoundException {
        // If id is less than 0 or greater than 10 then throw UserNotFoundException
        if(id < 0 || id > 10) {
            throw new UserNotFoundException("User with id " + id + " not found");
        }
        // Else return a sample user object
        User user = new User();
        user.setId(id);
        user.setName("User" + id);
        user.setEmail("user" + id + "@example.com");
        user.setPassword("##########");
        return user;
    }
}
