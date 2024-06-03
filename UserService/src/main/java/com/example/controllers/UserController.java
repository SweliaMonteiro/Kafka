package com.example.controllers;

import com.example.exceptions.UserNotFoundException;
import com.example.models.User;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    // This is a sample method which is used to get the user details by id, if user is not found then it returns null
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") long id) {
        try {
            System.out.println(new Date());  // To test if API Gateway is distributing load to different instances of UserService
            return userService.getUserById(id);
        }
        catch (UserNotFoundException e) {
            return null;
        }
    }
}
