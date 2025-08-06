package com.main;

import com.bean.Product;
import com.service.BillingException;
import com.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("WiproIOCContainer.xml");
        ProductService productService = context.getBean("productService", ProductService.class);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("**************************************************************************");
            System.out.println("1. Generate Bill by entering code and quantity ");
            System.out.println("2. Exit ");
            System.out.print("Enter option: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    int productCode = 0;
                    int quantity = 0;

                    // Validate product code
                    while (true) {
                        System.out.print("Enter product_code: ");
                        productCode = scanner.nextInt();

                        try {
                            if (!productService.validateProductCode(productCode)) {
                                throw new BillingException("Invalid product_code, it should be >0 and 4 digit +ve number");
                            }
                            break;
                        } catch (BillingException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    // Validate quantity
                    while (true) {
                        System.out.print("Enter quantity: ");
                        quantity = scanner.nextInt();

                        try {
                            if (!productService.validateQuantity(quantity)) {
                                throw new BillingException("Invalid quantity, it should be >0");
                            }
                            break;
                        } catch (BillingException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    try {
                        Product product = productService.getProductDetails(productCode);

                        System.out.println("Product Name: " + product.getProduct_name());
                        System.out.println("Product Category: " + product.getProduct_category());
                        System.out.println("Product Description: " + product.getProduct_description());
                        System.out.println("Product Price(Rs): " + product.getProduct_price());
                        System.out.println("Quantity: " + quantity);
                        System.out.println("Total Bill Amount: Rs." + productService.calculatePrice(quantity, product.getProduct_price()));

                    } catch (Exception e) {
                        System.out.println("Product not found or error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Enter option 1 to 2 only");
            }
        }
    }
}
