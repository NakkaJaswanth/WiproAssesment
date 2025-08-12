package com.example.uber.controller;

import com.example.uber.model.RideRequest;
import com.example.uber.service.RideKafkaProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rides")
public class RideController {

    @Autowired
    private RideKafkaProducer producer;

    @PostMapping
    public ResponseEntity<String> createRide(@RequestBody RideRequest request) throws JsonProcessingException {
        request.setOperation("CREATE");
        producer.sendRideEvent(request);
        return ResponseEntity.ok("Create ride event sent to Kafka");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRide(@PathVariable Long id, @RequestBody RideRequest request) throws JsonProcessingException {
        request.setOperation("UPDATE");
        request.setId(id);
        producer.sendRideEvent(request);
        return ResponseEntity.ok("Update ride event sent to Kafka");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRide(@PathVariable Long id) throws JsonProcessingException {
        RideRequest request = new RideRequest();
        request.setOperation("DELETE");
        request.setId(id);
        producer.sendRideEvent(request);
        return ResponseEntity.ok("Delete ride event sent to Kafka");
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<String> getRide(@PathVariable Long id) {
        return ResponseEntity.ok("Mocked response: ride id " + id);
    }
}
