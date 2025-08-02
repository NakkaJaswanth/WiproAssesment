package com.example.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Account {
	 @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long id;

	    @Column(length = 50)
	    private String holderName;

	    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Transaction> transactions = new ArrayList<>();

	   

	  
	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public String getHolderName() {
	        return holderName;
	    }

	    public void setHolderName(String holderName) {
	        this.holderName = holderName;
	    }

	    public List<Transaction> getTransactions() {
	        return transactions;
	    }

	    public void setTransactions(List<Transaction> transactions) {
	        this.transactions = transactions;
	    }

	    
	    public void addTransaction(Transaction t) {
	        transactions.add(t);
	        t.setAccount(this);
	    }

	    public void removeTransaction(Transaction t) {
	        transactions.remove(t);
	        t.setAccount(null);
	    }
	}
