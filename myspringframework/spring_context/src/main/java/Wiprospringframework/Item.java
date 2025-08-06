package Wiprospringframework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Item {
    private int id = 101;
    private String name = "Laptop";
    private double price = 55000.50;

    @Autowired
    private Category category;

    public void displayDetails() {
        System.out.println("Item Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: ₹" + price);
        System.out.println("Category ID: " + category.getCategoryId());
        System.out.println("Category Name: " + category.getCategoryName());
    }
}
