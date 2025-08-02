package com.example.hibernate.util;

import java.util.List;
import java.util.Scanner;

import com.example.hibernate.dao.BookAuthorDAO;

public class BookAuthorMain {
    public static void main(String[] args) {
        BookAuthorDAO dao = new BookAuthorDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Book with Authors");
            System.out.println("2. View All Books");
            System.out.println("3. Delete Book");
            System.out.println("4. Exit");

            int choice = -1;
            while (true) {
                System.out.print("Choice: ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); 
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); 
                }
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();

                    int n = -1;
                    while (true) {
                        System.out.print("Number of authors: ");
                        if (scanner.hasNextInt()) {
                            n = scanner.nextInt();
                            scanner.nextLine(); 
                            if (n > 0) break;
                            else System.out.println("Number must be positive.");
                        } else {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.nextLine(); 
                        }
                    }

                    List<String> authors = new java.util.ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter author name #" + (i + 1) + ": ");
                        authors.add(scanner.nextLine());
                    }

                    dao.addBookWithAuthors(title, authors);
                    break;

                case 2:
                    dao.viewAllBooks();
                    break;

                case 3:
                    long id = -1;
                    while (true) {
                        System.out.print("Enter Book ID to delete: ");
                        if (scanner.hasNextLong()) {
                            id = scanner.nextLong();
                            scanner.nextLine(); 
                            if (id > 0) break;
                            else System.out.println("ID must be positive.");
                        } else {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.nextLine(); 
                        }
                    }

                    dao.deleteBook(id);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please select between 1 and 4.");
            }
        }
    }
}
