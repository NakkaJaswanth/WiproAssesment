package com.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pojos.Books;

@RestController
@RequestMapping("/book")
/*
 * In our case, Book Service is the provider/producer Service. 
 * Moreover, the Book service will publish the REST endpoints.
 */

public class BookRestController 
{
	@Autowired
	 Environment environment;//READING THE VALUE FROM APPLICATION.PROPERTIES File
	@GetMapping("/data")//1
	public String getBookData() 
	 {
	return "data of BOOK-SERVICE, Running on port: "+environment.getProperty("local.server.port");//9011
	 }

	@GetMapping("/{id}")//2
	public Books getBookById(@PathVariable(value="id") Integer id)
	 {
	return new Books(id, "Head First Java", 500.75);
	 }
	
	///http://localhost:9011/book/all
	@GetMapping("/all")//3
	public List<Books> getAll()
	 {
	return Arrays.asList(new Books(501, "Head First Java", 439.75),
	new Books(502, "Spring in Action", 340.75),
	new Books(503, "Hibernate in Action", 355.75)
	 );
	 }
	
	//http://localhost:9011/book/entity
	@GetMapping("/entity")//4
	public ResponseEntity<String> getEntityData() 
	 {
	return new ResponseEntity<String>("Hello from 	BookRestController",HttpStatus.OK);
	 }




}
