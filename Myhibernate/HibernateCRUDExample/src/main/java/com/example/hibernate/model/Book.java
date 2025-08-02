package com.example.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String title;

	    @ManyToMany
	    @JoinTable(
	        name = "book_author",
	        joinColumns = @JoinColumn(name = "book_id"),
	        inverseJoinColumns = @JoinColumn(name = "author_id")
	    )
	    private Set<Author> authors = new HashSet<>();

	    
	    public Book() {}

	    
	    public Book(String title) {
	        this.title = title;
	    }

	    public void addAuthor(Author author) {
	        this.authors.add(author);
	    }

	    public Set<Author> getAuthors() {
	    	return authors; 
	    	}
	    public void setAuthors(Set<Author> authors) { 
	    	this.authors = authors; 
	    	}

	    public Long getId() {
	    	return id;
	    	}
	    public void setId(Long id) { 
	    	this.id = id; 
	    	}

	    public String getTitle() {
	    	return title; 
	    	}
	    public void setTitle(String title) {
	    	this.title = title;
	    	}
}
