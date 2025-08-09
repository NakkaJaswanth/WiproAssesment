package com.example.restaurantconsumer.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.restaurantproducer.model.Restaurant;

import java.util.List;
@FeignClient(name = "restaurant-producer", url = "http://localhost:8081")
public interface RestaurantClient {

    @GetMapping("/restaurants")
    List<Restaurant> getRestaurants();
}
