package com.example.services;

import com.example.exceptions.ProductNotFoundException;
import com.example.exceptions.UserNotFoundException;
import com.example.models.Product;
import com.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ProductService {

    @Autowired
    private RestTemplate restTemplate;


    public String validateUserByIdAndGetProductById(long productId, long userId) throws ProductNotFoundException, UserNotFoundException {
        // Check if the user with the given id is present in User Service, if present then return the user else return null
        // Provide server name as "UserService" to call the UserService and to distribute the load evenly to all the instances of UserService
        User user = restTemplate.getForObject("http://UserService/users/"+userId, User.class);
        // If user is not found then throw UserNotFoundException
        if(user == null) {
            throw new UserNotFoundException("User with id " + userId + " not found");
        }

        // If productId is less than 0 or greater than 10 then throw ProductNotFoundException
        if(productId < 0 || productId > 10) {
            throw new ProductNotFoundException("Product with id " + productId + " not found");
        }
        // Else return a sample product object
        Product product = new Product();
        product.setId(productId);
        product.setTitle("Product" + productId);
        product.setDescription("Product" + productId + " Description");
        product.setPrice(1000.00);
        return convertProductToSting(product);
    }

    // To convert the product object to string
    public String convertProductToSting(Product product) {
        return "{ <br> &emsp; Product Id: " + product.getId() +
                ", <br> &emsp; Title: " + product.getTitle() +
                ", <br> &emsp; Description: " + product.getDescription() +
                ", <br> &emsp; Price: " + product.getPrice() + "<br> }";
    }
}
