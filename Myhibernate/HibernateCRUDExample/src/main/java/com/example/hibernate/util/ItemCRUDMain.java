package com.example.hibernate.util;

import java.util.List;
import java.util.Scanner;

import com.example.hibernate.dao.ItemDAO;
import com.example.hibernate.model.Item;

public class ItemCRUDMain {
	 public static void main(String[] args) {
	        ItemDAO dao = new ItemDAO();
	        Scanner sc = new Scanner(System.in);

	        while (true) {
	            System.out.println("\n1. Add  2. View  3. Update  4. Delete  5. View All  6. Exit");
	            System.out.print("Enter choice: ");
	            int choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    Item item = new Item();
	                    System.out.print("Enter Name: ");
	                    item.setName(sc.next());
	                    System.out.print("Enter Price: ");
	                    item.setPrice(sc.nextDouble());
	                    dao.addItem(item);
	                    System.out.println("Item added successfully.");
	                    break;

	                case 2:
	                    System.out.print("Enter ID to view: ");
	                    Item viewItem = dao.getItem(sc.nextInt());
	                    if (viewItem != null) {
	                        System.out.println("ID: " + viewItem.getId() + ", Name: " + viewItem.getName() + ", Price: " + viewItem.getPrice());
	                    } else {
	                        System.out.println("Item not found.");
	                    }
	                    break;

	                case 3:
	                    Item updateItem = new Item();
	                    System.out.print("Enter ID to update: ");
	                    int updateId = sc.nextInt();
	                    updateItem.setId(updateId);
	                    System.out.print("Enter New Name: ");
	                    updateItem.setName(sc.next());
	                    System.out.print("Enter New Price: ");
	                    updateItem.setPrice(sc.nextDouble());
	                    boolean isUpdated = dao.updateItem(updateItem);
	                    if (isUpdated) {
	                        System.out.println("Item updated successfully.");
	                    } else {
	                        System.out.println("Item with ID " + updateId + " not found.");
	                    }
	                    break;

	                case 4:
	                    System.out.print("Enter ID to delete: ");
	                    int deleteId = sc.nextInt();
	                    boolean isDeleted = dao.deleteItem(deleteId);
	                    if (isDeleted) {
	                        System.out.println("Item deleted successfully.");
	                    } else {
	                        System.out.println("Item with ID " + deleteId + " not found.");
	                    }
	                    break;

	                case 5:
	                    List<Item> items = dao.getAllItems();
	                    for (Item i : items) {
	                        System.out.println(i.getId() + " | " + i.getName() + " | " + i.getPrice());
	                    }
	                    break;

	                case 6:
	                    sc.close();
	                    System.exit(0);
	                    break;

	                default:
	                    System.out.println("Invalid choice.");
	            }
	        }
	    }

}
