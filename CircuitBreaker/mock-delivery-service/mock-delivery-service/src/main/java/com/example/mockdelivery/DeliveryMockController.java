package com.example.mockdelivery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery")
public class DeliveryMockController {

    @GetMapping("/status")
    public String getStatus() {
        return " Delivery is on the way!";
    }
}
