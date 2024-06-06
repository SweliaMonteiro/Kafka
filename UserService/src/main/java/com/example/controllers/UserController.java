package com.example.controllers;

import com.example.dtos.LogInRequestDto;
import com.example.dtos.UserDto;
import com.example.models.User;
import com.example.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // This Key-value KafkaTemplate is used to send messages to the Kafka where key is the topic to which other services are subscribed and
    // value is the message that needs to be sent and will be used by other services
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    // This ObjectMapper is used to convert the UserDto object to a JSON string as Kafka only accepts strings as messages and not objects
    @Autowired
    private ObjectMapper objectMapper;


    // This is a sample method used to log in a user
    @PostMapping("/login")
    public String logIn(@RequestBody LogInRequestDto logInRequestDto) throws JsonProcessingException {
        User user = userService.logIn(logInRequestDto.getUsername(), logInRequestDto.getEmail(), logInRequestDto.getPassword());
        UserDto userDto = UserDto.from(user);
        // Send the userDto object as a JSON string to the Kafka topic "NotifyUser"
        kafkaTemplate.send("NotifyUser", objectMapper.writeValueAsString(userDto));
        // Return a success message
        return "Successfully logged in user with email: " + user.getEmail();
    }
}
