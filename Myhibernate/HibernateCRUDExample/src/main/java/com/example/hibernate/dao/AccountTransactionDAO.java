package com.example.hibernate.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.model.Account;





public class AccountTransactionDAO {


	    private SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	    public void addAccountWithTransactions(Account account) {
	        Session session = factory.openSession();
	        Transaction tx = session.beginTransaction();
	        session.save(account);
	        tx.commit();
	        session.close();
	    }

	    public void viewAllAccounts() {
	        Session session = factory.openSession();
	        List<Account> list = session.createQuery("from Account").list();
	        for (Account a : list) {
	            System.out.println("Account ID: " + a.getId() + ", Holder: " + a.getHolderName());
	            for (com.example.hibernate.model.Transaction t : a.getTransactions()) {
	                System.out.println("   - Transaction ID: " + t.getId() + ", Type: " + t.getType() + ", Amount: " + t.getAmount());
	            }
	        }
	        session.close();
	    }

	    public void deleteTransactionFromAccount(long accountId, long txnId) {
	        Session session = factory.openSession();
	        org.hibernate.Transaction tx = session.beginTransaction();

	        Account acc = session.get(Account.class, accountId);
	        if (acc != null) {
	            com.example.hibernate.model.Transaction toRemove = null;
	            for (com.example.hibernate.model.Transaction t : acc.getTransactions()) {
	                if (t.getId() == txnId) {
	                    toRemove = t;
	                    break;
	                }
	            }

	            if (toRemove != null) {
	                acc.removeTransaction(toRemove); // This also handles orphan removal
	                session.update(acc);
	                System.out.println("Transaction removed successfully.");
	            } else {
	                System.out.println("Transaction not found in this account.");
	            }
	        } else {
	            System.out.println("Account not found.");
	        }

	        tx.commit();
	        session.close();
	    }

	    public void updateTransactionAmount(long txnId, double newAmount) {
	        Session session = factory.openSession();
	        org.hibernate.Transaction tx = session.beginTransaction();

	        com.example.hibernate.model.Transaction t = session.get(com.example.hibernate.model.Transaction.class, txnId);
	        if (t != null) {
	            t.setAmount(newAmount);
	            session.update(t);
	            System.out.println("Transaction amount updated successfully.");
	        } else {
	            System.out.println("Transaction not found.");
	        }

	        tx.commit();
	        session.close();
	    }

	   

	    public void deleteAccount(long accountId) {
	        Session session = factory.openSession();
	        Transaction tx = session.beginTransaction();
	        Account acc = session.get(Account.class, accountId);
	        if (acc != null) {
	            session.delete(acc);
	        }
	        tx.commit();
	        session.close();
	    }
	}

  
