package com.example.uber.service;

import com.example.uber.entity.Ride;
import com.example.uber.model.RideRequest;
import com.example.uber.repository.RideRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RideKafkaConsumer {

    @Autowired
    private RideRepository rideRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "uber-ride-topic", groupId = "uber_ride_group")
    public void consume(String message) throws JsonProcessingException {
        RideRequest rideRequest = objectMapper.readValue(message, RideRequest.class);

        String operation = rideRequest.getOperation();

        switch (operation) {
            case "CREATE":
                Ride newRide = new Ride();
                BeanUtils.copyProperties(rideRequest, newRide);
                rideRepository.save(newRide);
                System.out.println("Ride created with ID: " + newRide.getId());
                break;

            case "UPDATE":
                Optional<Ride> existingRideOpt = rideRepository.findById(rideRequest.getId());
                if (existingRideOpt.isPresent()) {
                    Ride existingRide = existingRideOpt.get();
                    BeanUtils.copyProperties(rideRequest, existingRide);
                    rideRepository.save(existingRide);
                    System.out.println("Ride updated with ID: " + existingRide.getId());
                } else {
                    System.out.println("Ride with ID " + rideRequest.getId() + " not found for update.");
                }
                break;

            case "DELETE":
                rideRepository.deleteById(rideRequest.getId());
                System.out.println("Ride deleted with ID: " + rideRequest.getId());
                break;

            default:
                System.out.println("Unknown operation: " + operation);
        }
    }
}
