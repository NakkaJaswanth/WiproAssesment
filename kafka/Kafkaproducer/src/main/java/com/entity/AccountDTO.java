package com.entity;

public class AccountDTO {
    private Long id;
    private String name;
    private double balance;
    private String operation; 

    public AccountDTO() {}

    public AccountDTO(Long id, String name, double balance, String operation) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.operation = operation;
    }

    public Long getId() { 
    	return id; 
    	}
    public void setId(Long id) { 
    	this.id = id;
    	}

    public String getName() { 
    	return name;
    	}
    public void setName(String name) { 
    	this.name = name;
    	}

    public double getBalance() { 
    	return balance;
    	}
    public void setBalance(double balance) { 
    	this.balance = balance;
    	}

    public String getOperation() { 
    	return operation;
    	}
    public void setOperation(String operation) { 
    	this.operation = operation;
    	}
}

