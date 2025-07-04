package com.zkrallah.zshop.customer;

import java.util.List;

import com.zkrallah.zshop.cart.CartItem;
import com.zkrallah.zshop.cart.CartServiceImpl;

public class CustomerServiceImpl implements CustomerService {

    private static final CustomerServiceImpl INSTANCE = new CustomerServiceImpl();

    // Private constructor for the singleton design pattern
    private CustomerServiceImpl() {
    }

    // Apply the singleton design pattern as we only have one customer service
    public static CustomerServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public double updateBalance(final Customer customer, final double newBalance) {
        if (customer != null) {
            customer.setBalance(newBalance);
            return customer.getBalance();
        }

        return -1;
    }

    @Override
    public String updateLocation(final Customer customer, final String newLocation) {
        if (customer != null) {
            customer.setLocation(newLocation);
            return customer.getLocation();
        }

        return null;
    }

    @Override
    public void checkout(final Customer customer) {
        final CartServiceImpl cart = customer.getCart();
        final List<CartItem> cartItems = cart.getCartItems();

        if (cartItems.size() == 0) {
            System.out.println("Empty cart!");
            return;
        }

        final double subtotal = CustomerUtils.calculateSubtotal(cartItems);
        final int shippingFee = CustomerUtils.calculateShippingFees();

        final double paidAmount = subtotal + shippingFee;
        final double customerBalance = customer.getBalance();

        // Early return before the transaction
        if (paidAmount > customerBalance) {
            System.out.println("Insufficient balance to complete the transaction!");
            System.out.println("Total balance: " + customerBalance);
            System.out.println("paidAmount: " + paidAmount);
            return;
        }

        CustomerUtils.shipItems(cartItems);

        CustomerUtils.completeTransaction(customer, cartItems, customerBalance - paidAmount);

        System.out.printf("\n-------- CHECK‑OUT SUMMARY --------\n");
        System.out.printf("Sub‑total    : %.2f\n", subtotal);
        System.out.printf("Shipping fee : %d\n", shippingFee);
        System.out.printf("Paid amount  : %.2f\n", paidAmount);
        System.out.printf("Balance left : %.2f\n", customer.getBalance());
        System.out.printf("-----------------------------------\n");
    }
}
