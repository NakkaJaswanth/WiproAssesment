package Wiprospringframework;

import java.util.Date;

public class Purchase {
    private int purchaseId;
    private Date purchaseDate;
    private Product product;

    public Purchase(int purchaseId, Date purchaseDate, Product product) {
        this.purchaseId = purchaseId;
        this.purchaseDate = purchaseDate;
        this.product = product;
    }

    public void display() {
        System.out.println("Purchase ID: " + purchaseId);
        System.out.println("Purchase Date: " + purchaseDate);
        product.display();
    }
}
