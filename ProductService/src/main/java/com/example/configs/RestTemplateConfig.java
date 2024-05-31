package com.example.configs;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RestTemplateConfig {

    // To enable client side load balancing in RestTemplate so that ProductService can call UserService and load will be distributed evenly to all the instances of UserService
    // Here ProductService is the client and UserService is the server
    @LoadBalanced
    @Bean  // To create object bean of RestTemplate and store in Spring container and use the bean when required
    public RestTemplate getRestTemplate() {
        return new RestTemplateBuilder().build();
    }
}
