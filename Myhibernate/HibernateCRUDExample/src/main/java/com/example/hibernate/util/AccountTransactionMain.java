package com.example.hibernate.util;

import java.util.Scanner;

import com.example.hibernate.dao.AccountTransactionDAO;
import com.example.hibernate.model.Account;
import com.example.hibernate.model.Transaction;

public class AccountTransactionMain {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        AccountTransactionDAO dao = new AccountTransactionDAO();

	        while (true) {
	            System.out.println("\n==== Account - Transaction Menu ====");
	            System.out.println("1. Add Account with Transactions");
	            System.out.println("2. View All Accounts");
	            System.out.println("3. Delete Transaction from Account");
	            System.out.println("4. Update Transaction Amount");
	            System.out.println("5. Delete Entire Account");
	            System.out.println("6. Exit");
	            System.out.print("Enter your choice: ");
	            int ch = sc.nextInt();

	            switch (ch) {
	                case 1:
	                    Account acc = new Account();
	                    System.out.print("Enter Account ID: ");
	                    acc.setId(sc.nextLong());
	                    System.out.print("Enter Holder Name: ");
	                    acc.setHolderName(sc.next());

	                    System.out.print("How many transactions? ");
	                    int n = sc.nextInt();

	                    for (int i = 0; i < n; i++) {
	                        Transaction txn = new Transaction();
	                        System.out.print("Enter Transaction Type: ");
	                        txn.setType(sc.next());
	                        System.out.print("Enter Amount: ");
	                        txn.setAmount(sc.nextDouble());
	                        acc.addTransaction(txn);  // Synchronize both ends
	                    }
	                    dao.addAccountWithTransactions(acc);
	                    break;

	                case 2:
	                    dao.viewAllAccounts();
	                    break;

	                case 3:
	                    System.out.print("Enter Account ID: ");
	                    long accountId = sc.nextLong();
	                    System.out.print("Enter Transaction ID to delete: ");
	                    long txnId = sc.nextLong();
	                    dao.deleteTransactionFromAccount(accountId, txnId);
	                    break;

	                case 4:
	                    System.out.print("Enter Transaction ID: ");
	                    long transactionId = sc.nextLong();
	                    System.out.print("Enter New Amount: ");
	                    double newAmount = sc.nextDouble();
	                    dao.updateTransactionAmount(transactionId, newAmount);
	                    break;

	                case 5:
	                    System.out.print("Enter Account ID to delete: ");
	                    long accId = sc.nextLong();
	                    dao.deleteAccount(accId);
	                    break;

	                case 6:
	                    System.out.println("Exiting...");
	                    sc.close();
	                    System.exit(0);
	                    break;

	                default:
	                    System.out.println("Invalid choice!");
	            }
	        }
	    }
}



