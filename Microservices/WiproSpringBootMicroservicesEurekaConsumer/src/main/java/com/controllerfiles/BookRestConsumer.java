package com.controllerfiles;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pojos.Books;

/*
 * In our case, Student Service is the consumer Service. 
 * Moreover, the Consumer service will consume the services published by Book 
service.
 */


@FeignClient(name="WiproSpringBootMicroservicesProducer")//name of the producer/service application
//declare the methods as per the requirement.
/*
 * PRODUCER PORT NUMBER IS 9011
 * CONSUMER PORT NUMBER IS 9102
 */
/*
 * The @FeignClient annotation is used to define a declarative REST client in Spring Cloud OpenFeign. 
 * It allows you to call another microservice’s API just by declaring an interface, 
 * and Spring Cloud will automatically generate the implementation for you at runtime.
 */
public interface BookRestConsumer
{
	@GetMapping("/book/data")//9011
public String getBookData();

@GetMapping("/book/{id}")
public Books getBookById(@PathVariable(value="id") Integer id);

@GetMapping("/book/all")
public List<Books> getAllBooks();

@GetMapping("/book/entity")
public ResponseEntity<String> getEntityData();


}
