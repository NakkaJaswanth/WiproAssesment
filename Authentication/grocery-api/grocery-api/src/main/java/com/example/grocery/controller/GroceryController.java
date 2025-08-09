package com.example.grocery.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grocery")
public class GroceryController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Welcome to the Grocery Store!";
    }

    @GetMapping("/items")
    public List<String> getItems() {
        return List.of("Apples", "Bananas", "Carrots");
    }

    @GetMapping("/orders")
    public List<String> getOrders() {
        return List.of("Order #123", "Order #456");
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminOnly() {
        return "Admin dashboard data.";
    }
}
