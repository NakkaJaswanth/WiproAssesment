package com.example.Beanfiles;

public class Account {
    private String accountNumber;
    private String type;
    private String status;

    public Account(String accountNumber, String type, String status) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.status = status;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Account [accountNumber=" + accountNumber + ", type=" + type + ", status=" + status + "]";
    }
}


