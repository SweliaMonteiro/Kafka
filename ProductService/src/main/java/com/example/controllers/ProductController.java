package com.example.controllers;

import com.example.exceptions.ProductNotFoundException;
import com.example.exceptions.UserNotFoundException;
import com.example.models.Product;
import com.example.services.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    // URL - http://localhost:8181/products?productId=1&userId=1
    // This is a sample method which is used to validate the user by id and get the product details by id, if product is not found then it returns null
    @GetMapping("")
    public String validateUserByIdAndGetProductById(@PathParam("productId") long productId, @PathParam("userId") long userId) {
        try {
            return productService.validateUserByIdAndGetProductById(productId, userId);
        }
        catch (ProductNotFoundException | UserNotFoundException e) {
            return e.getMessage();
        }
    }
}
