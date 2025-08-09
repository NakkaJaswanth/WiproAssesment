package com.example.mainapp.controller;

import com.example.mainapp.service.DeliveryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("/delivery/status")
    public String getStatus() {
        return deliveryService.getDeliveryStatus();
    }
}
