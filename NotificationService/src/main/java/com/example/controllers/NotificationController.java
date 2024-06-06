package com.example.controllers;

import com.example.dtos.UserDto;
import com.example.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class NotificationController {

    @Autowired
    private NotificationService notificationService;


    // This method sends an email notification to the user
    public void sendEmailNotification(UserDto userDto) {
        notificationService.sendEmailNotification(userDto.getEmail(), userDto.getUsername());
    }
}
