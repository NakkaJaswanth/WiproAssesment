package com.mainfiles;
/*
 * In order to get the features of OpenFeign, we will additionally need to 
apply @EnableFeignClients
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
/*
 * http://localhost:8761/
 * http://localhost:9102/student/data
 * http://localhost:9102/student/allBooks
 * http://localhost:9102/student/entityData
 * http://localhost:9102/student/getOneBook/500
 */
@ComponentScan(basePackages= {"com"})
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.controllerfiles")//package name
public class SpringCloudMicroClients {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudMicroClients.class, args);
	}

}
