package com.zkrallah.zshop.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.zkrallah.zshop.cart.CartItem;
import com.zkrallah.zshop.inventory.InventoryServiceImpl;
import com.zkrallah.zshop.product.Product;
import com.zkrallah.zshop.product.Shippable;
import com.zkrallah.zshop.shipping.ShippingService;

// Look mom, I separate concerns, my code is clean!
class CustomerUtils {

    // We could really use dependency injection here but anyways...
    private static final InventoryServiceImpl inventoryServiceImpl = InventoryServiceImpl.getInstance();

    static double calculateSubtotal(final List<CartItem> cartItems) {
        double subtotal = 0;

        for (final CartItem item : cartItems) {
            final int itemCount = item.getCount();
            final double itemPrice = item.getProduct().getPrice();
            subtotal += itemCount * itemPrice;
        }

        return subtotal;
    }

    // Of course I got no time to calculate shipping fees dynamically, so let's go
    // random
    static int calculateShippingFees() {
        final int min = 15;
        final int max = 100;
        final Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    static void completeTransaction(final Customer customer, final List<CartItem> cartItems, final double newBalance) {
        // Update customer balance
        customer.setBalance(newBalance);

        // Update Inventory
        for (final CartItem item : cartItems) {
            final int itemCount = item.getCount();
            final Product itemProduct = item.getProduct();
            final int productQuantity = itemProduct.getQuantity();
            final int newQuantity = productQuantity - itemCount;
            inventoryServiceImpl.modifyProductQuantity(itemProduct, newQuantity);
        }

        // Clear Cart
        customer.getCart().clearCart();
    }

    static void shipItems(final List<CartItem> cartItems) {

        final List<Shippable> toShip = new ArrayList<>();
        final ShippingService shippingService = new ShippingService();

        for (final CartItem item : cartItems) {
            final Product product = item.getProduct();
            if (product instanceof Shippable) {
                for (int i = 0; i < item.getCount(); i++) {
                    toShip.add((Shippable) product);
                }
            }
        }

        if (!toShip.isEmpty()) {
            shippingService.shipItems(toShip);
        }
    }
}
