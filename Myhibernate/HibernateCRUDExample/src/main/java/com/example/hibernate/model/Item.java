package com.example.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "itemslist")
public class Item {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
        @Column
	    private String name;
        @Column
	    private double price;

	    public Item() {}

	    public Item(String name, double price) {
	        this.name = name;
	        this.price = price;
	    }

	   
	    public int getId() { 
	    	return id; 
	    	}
	    public void setId(int id) { 
	    	this.id = id; 
	    	}

	    public String getName() {
	    	return name;
	    	}
	    public void setName(String name) { 
	    	this.name = name; 
	    	}

	    public double getPrice() {
	    	return price;
	    	}
	    public void setPrice(double price) {
	    	this.price = price; 
	    	}

	    @Override
	    public String toString() {
	        return String.format("Item [ID=%d, Name=%s, Price=%.2f]", id, name, price);
	    }

}
