package com.zkrallah.zbooks.util;

import java.util.Random;

import com.zkrallah.zbooks.model.book.Book;
import com.zkrallah.zbooks.model.book.Mailable;
import com.zkrallah.zbooks.model.book.Shippable;
import com.zkrallah.zbooks.model.customer.Customer;
import com.zkrallah.zbooks.service.inventory.InventoryServiceImpl;

public class InventoryUtils {

    // We could really use dependency injection here but anyways...
    private static final InventoryServiceImpl inventoryServiceImpl = InventoryServiceImpl.getInstance();

    public static double calculateSubtotal(final Book book, final int quantity) {
        return book.getPrice() * quantity;
    }

    // Of course I got no time to calculate shipping fees dynamically, so let's go
    // random
    public static int calculateShippingFees() {
        final int min = 15;
        final int max = 100;
        final Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public static void completeTransaction(final Customer customer, final Book book, final int quantity,
            final double newBalance) {
        // Update customer balance
        customer.setBalance(newBalance);

        // Update Inventory
        if (book instanceof Shippable) {
            // Cast is 100% safe as we check for the instance before casting
            final int newQuantity = ((Shippable) book).getQuantity() - quantity;
            final int remaindQuantity = inventoryServiceImpl.modifyBookQuantity(book, newQuantity);
            System.out.printf("Remaining %s book stock now: %d", book.getIsbn(), remaindQuantity);
        }
    }

    public static void shipBooks(final Customer customer, final Book book, final int quantity) {
        if (!(book instanceof Shippable))
            return;

        System.out.printf("Shipping %d copyies of \"%s\" to address: %s\n", quantity, book.getTitle(),
                customer.getLocation());
    }

    // Just mail one book, quantity is obsolete
    public static void mailBook(final Customer customer, final Book book, final String fileType) {
        if (!(book instanceof Mailable))
            return;

        System.out.printf("Sending \"%s\" book with file type: %s to email: %s\n", book.getTitle(), fileType,
                customer.getEmail());
    }

}
