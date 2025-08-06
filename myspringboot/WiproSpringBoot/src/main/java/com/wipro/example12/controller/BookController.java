package com.wipro.example12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.example12.model.Book;
import com.wipro.example12.repository.BookRepository;


@RestController
@RequestMapping("/books")
public class BookController {
	  @Autowired
	    private BookRepository bookRepository;

	    @GetMapping("/list")
	    public List<Book> getAllBooks() {
	        return bookRepository.findAll();
	    }
	}


