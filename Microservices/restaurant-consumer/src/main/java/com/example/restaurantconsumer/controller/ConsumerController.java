package com.example.restaurantconsumer.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.restaurantconsumer.client.RestaurantClient;
import com.example.restaurantproducer.model.Restaurant;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestaurantClient restaurantClient;

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants() {
        return restaurantClient.getRestaurants();
    }
}
