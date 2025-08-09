package com.example.orderservice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class OrderController {

    private final RestTemplate restTemplate;

    // Constructor injection recommended
    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/order")
    public String placeOrder() {
        String response = restTemplate.getForObject("http://localhost:8082/payment", String.class);
        return "Order placed. Payment status: " + response;
    }
}
