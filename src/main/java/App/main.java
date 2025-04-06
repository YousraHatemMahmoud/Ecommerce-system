package App;

import models.Product;
import java.time.LocalDate;
import models.Customer;
import models.CartItem;
import models.Cart;
import java.util.List;
import java.util.ArrayList;
import services.CheckOutService;

public class main {
    public static void main(String[] args) {

        Product cheese = new Product("Cheese", 100, 10,
                                     true, LocalDate.of(2025, 6, 1),
                                     true, 0.4);

        Product biscuits = new Product("Biscuits", 75, 10,
                                       true, LocalDate.of(2025, 6, 10),
                                       true, 0.7);

        Product tv = new Product("TV", 1000, 5,
                                 false, null, true, 15.0);

        Product scratchCard = new Product("Scratch Card", 20, 100,
                                          false, null, false, 0.0);

        Customer customer = new Customer("Ahmed", 10000);

        List<CartItem> cartItems = new ArrayList<>();
        Cart cart = new Cart(cartItems);

        cart.addProduct(cheese, 2);
        cart.addProduct(tv, 1);
        cart.addProduct(biscuits, 2);
        cart.addProduct(scratchCard, 1);

        CheckOutService.checkout(customer, cart);

    }
}
