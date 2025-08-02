package com.example.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




@Entity
public class Transaction {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
        @Column
	    private String type;
        @Column
	    private double amount;

	    @ManyToOne
	    @JoinColumn(name = "account_id")
	    private Account account;

	    
	    public long getId() {
	    	return id; 
	    	}

	    public String getType() {
	    	return type;
	    	}
	    public void setType(String type) {
	    	this.type = type; 
	    	}

	    public double getAmount() {
	    	return amount; 
	    	}
	    public void setAmount(double amount) { 
	    	this.amount = amount; 
	    	}

	    public Account getAccount() {
	    	return account; 
	    	}
	    public void setAccount(Account account) { 
	    	this.account = account; 
	    	}

}
   

