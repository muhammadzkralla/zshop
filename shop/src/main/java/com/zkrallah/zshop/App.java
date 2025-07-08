package com.zkrallah.zshop;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import com.zkrallah.zshop.cart.CartItem;
import com.zkrallah.zshop.cart.CartServiceImpl;
import com.zkrallah.zshop.customer.Customer;
import com.zkrallah.zshop.customer.CustomerServiceImpl;
import com.zkrallah.zshop.inventory.InventoryServiceImpl;
import com.zkrallah.zshop.model.Biscuit;
import com.zkrallah.zshop.model.Cheese;
import com.zkrallah.zshop.model.MobileCard;
import com.zkrallah.zshop.model.TV;
import com.zkrallah.zshop.product.Product;

class App {
    private static final InventoryServiceImpl inventoryServiceImpl = InventoryServiceImpl.getInstance();
    private static final CustomerServiceImpl customerServiceImpl = CustomerServiceImpl.getInstance();

    private static Customer customer;

    public static void main(String[] args) {
        // We could really make use of the builder design pattern for these functions
        // for better readability, but again, no time :)
        createCheese();
        createTVs();
        createMobileCards();
        createBiscuits();

        customer = new Customer("Zkrallah", 1000, "NeoVim");
        CartServiceImpl cart = customer.getCart();
        List<Product> products = inventoryServiceImpl.getInventoryProducts();

        final Random random = new Random();

        // Add 5 random products with random counts
        for (int i = 0; i < 5; ++i) {
            int idx = random.nextInt(products.size());
            int initialCount = random.nextInt(7) + 1;

            Product product = products.get(idx);

            cart.addItem(product, initialCount);
        }

        System.out.println("\nItems in cart now:");
        for (CartItem cartItem : cart.getCartItems()) {
            System.out.println(cartItem);
        }

        customerServiceImpl.checkout(customer);
    }

    private static void createCheese() {
        Cheese cheese1 = new Cheese("Cheddar", 15.3, 5, 0.5, LocalDate.of(2025, 12, 31));
        Cheese cheese2 = new Cheese("Mozzarella", 18.0, 3, 0.6, LocalDate.of(2025, 11, 30));

        // Expired one
        Cheese cheese3 = new Cheese("Parmesan", 25.0, 6, 1, LocalDate.of(2024, 11, 30));

        inventoryServiceImpl.addProduct(cheese1);
        inventoryServiceImpl.addProduct(cheese2);
        inventoryServiceImpl.addProduct(cheese3);
    }

    private static void createTVs() {
        TV tv1 = new TV("Samsung", 500.0, 2, 10.0);
        TV tv2 = new TV("LG", 400.0, 4, 8.0);
        inventoryServiceImpl.addProduct(tv1);
        inventoryServiceImpl.addProduct(tv2);
    }

    private static void createMobileCards() {
        MobileCard card1 = new MobileCard("Vodafone 100EGP", 100.0, 10);
        MobileCard card2 = new MobileCard("Etisalat 50EGP", 50.0, 20);
        inventoryServiceImpl.addProduct(card1);
        inventoryServiceImpl.addProduct(card2);
    }

    private static void createBiscuits() {
        Biscuit biscuit1 = new Biscuit("Oreo", 5.0, 30, LocalDate.of(2025, 9, 1));
        Biscuit biscuit2 = new Biscuit("Digestive", 4.5, 20, LocalDate.of(2025, 8, 15));

        // Expired one
        Biscuit biscuit3 = new Biscuit("Todo", 5.0, 25, LocalDate.of(2024, 8, 15));

        inventoryServiceImpl.addProduct(biscuit1);
        inventoryServiceImpl.addProduct(biscuit2);
        inventoryServiceImpl.addProduct(biscuit3);

    }
}
