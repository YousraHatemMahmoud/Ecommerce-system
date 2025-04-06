package services;

import models.Product;
import models.CartItem;
import java.util.List;

public class ShippingService {

    // Method to process the shipping of products
    public static void shipProducts(List<CartItem> cartItems) {

        System.out.println("** Shipment notice **");

        double totalWeight = 0;

        for (CartItem item : cartItems) {
            Product product = item.getProduct();

            // Check if the product is shippable
            if (product.isShippable()) {
                int quantity = item.getQuantity();
                double productWeightInKg = product.getWeight() * quantity;

                // Print the product's shipping details: quantity, name, and weight in grams
                System.out.println(quantity + "x " + product.getName() + " " + productWeightInKg * 1000 + "g");
                totalWeight += productWeightInKg;
            }
        }

        System.out.println("Total package weight " + totalWeight + "kg");
    }
}
