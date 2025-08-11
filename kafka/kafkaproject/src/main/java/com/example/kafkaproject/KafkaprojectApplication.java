package com.example.kafkaproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com")
public class KafkaprojectApplication {
	  public static void main(String[] args) {
	        SpringApplication.run(KafkaprojectApplication.class, args);
	    }
}
