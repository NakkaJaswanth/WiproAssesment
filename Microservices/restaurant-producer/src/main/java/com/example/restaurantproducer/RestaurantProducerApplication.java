package com.example.restaurantproducer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@SpringBootApplication
@EnableDiscoveryClient
public class RestaurantProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestaurantProducerApplication.class, args);
    }
}
