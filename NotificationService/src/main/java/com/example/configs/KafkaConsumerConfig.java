package com.example.configs;

import com.example.controllers.NotificationController;
import com.example.dtos.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;


@Configuration
public class KafkaConsumerConfig {

    // This ObjectMapper is used to convert the JSON string received from Kafka to a UserDto object
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private NotificationController notificationController;


    // This method listens to the Kafka topic "NotifyUser" and consumes the messages sent to it
    // groupId is used to identify the consumer group to which this consumer belongs. If there are multiple servers for the same consumer group, only one server will receive the message.
    @KafkaListener(topics = "NotifyUser", groupId = "NotificationGroup")
    public void consume(String message) throws Exception {
        // The messages are converted to a UserDto object and sent to the sendEmailNotification method in the NotificationController
        UserDto userDto = objectMapper.readValue(message, UserDto.class);
        notificationController.sendEmailNotification(userDto);
    }
}
