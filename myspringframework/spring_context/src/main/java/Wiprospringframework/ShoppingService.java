package Wiprospringframework;
public class ShoppingService {

    public void addToCart(String item) {
        System.out.println("Item added to cart: " + item);
    }

    public void makePayment(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount");
        }
        System.out.println("Payment made: $" + amount);
    }

    public void placeOrder() {
        System.out.println("Order placed successfully");
    }
}