package com.springbootmainfiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication

@EnableEurekaServer//Eureka dashboard will be displayed

//http://localhost:8761/

public class SpringBootEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEurekaServerApplication.class, 	args);
		
	}

}

