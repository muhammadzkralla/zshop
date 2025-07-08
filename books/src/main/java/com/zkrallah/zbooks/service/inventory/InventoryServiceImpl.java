package com.zkrallah.zbooks.service.inventory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.zkrallah.zbooks.model.book.Book;
import com.zkrallah.zbooks.model.book.Mailable;
import com.zkrallah.zbooks.model.book.Shippable;
import com.zkrallah.zbooks.model.customer.Customer;
import com.zkrallah.zbooks.util.InventoryUtils;

public class InventoryServiceImpl implements InventoryService {

    private static final InventoryServiceImpl INSTANCE = new InventoryServiceImpl();

    // I used a hash set here, unlike the other project, to eliminate duplicate
    // books
    private final Set<Book> books = new HashSet<>();

    // Private constructor for the singleton design pattern
    private InventoryServiceImpl() {
    }

    // Apply the singleton design pattern as we only have one inventory
    public static InventoryServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public Book addBook(final Book book) {
        if (books.contains(book)) {
            System.out.println("Book already exists in inventory.");
            return null;
        }

        books.add(book);
        return book;
    }

    @Override
    public boolean removeBook(final Book book) {
        return books.remove(book);

    }

    @Override
    public List<Book> getBooks() {
        return List.copyOf(books);
    }

    @Override
    public int modifyBookQuantity(final Book book, final int newQuantity) {
        if (book != null && books.contains(book)) {
            if (book instanceof Shippable) {
                // Cast is 100% safe as we check for the instance before casting
                ((Shippable) book).setQuantity(newQuantity);
                return ((Shippable) book).getQuantity();
            }
        }

        System.out.println("Could not find book in inventory!");
        return -1;
    }

    @Override
    public void checkOutdatedBooks(final int currentYear) {
        books.removeIf(book -> {
            final boolean flag = book.isOutdated(currentYear);

            if (flag) {
                System.out.println("Removing outdated book: " + book);
            }

            return flag;
        });
    }

    @Override
    public void buyBook(final Customer customer, final Book book, final int quantity) {
        if (customer == null || book == null || quantity == 0) {
            System.out.println("Bad purchase!");
            return;
        }

        if (!books.contains(book)) {
            System.out.println("Book is not available in inventory!");
            return;
        }

        final double subtotal = InventoryUtils.calculateSubtotal(book, quantity);
        final int shippingFee = (book instanceof Shippable) ? InventoryUtils.calculateShippingFees() : 0;

        final double paidAmount = subtotal + shippingFee;
        final double customerBalance = customer.getBalance();

        // Early return before the transaction
        if (paidAmount > customerBalance) {
            System.out.println("Insufficient balance to complete the transaction!");
            System.out.println("Total balance: " + customerBalance);
            System.out.println("paidAmount: " + paidAmount);
            return;
        }

        // Early return before the transaction
        if (book instanceof Shippable) {
            if (((Shippable) book).getQuantity() < quantity) {
                System.out.println("Not enough copies in stock.");
                return;
            }
        }

        if (book instanceof Shippable) {
            InventoryUtils.shipBooks(customer, book, quantity);
        }

        if (book instanceof Mailable) {
            String fileType = ((Mailable) book).getFileType();
            InventoryUtils.mailBook(customer, book, fileType);
        }

        InventoryUtils.completeTransaction(customer, book, quantity, customerBalance - paidAmount);

        System.out.printf("\n-------- CHECK‑OUT SUMMARY --------\n");
        System.out.printf("Sub‑total    : %.2f\n", subtotal);
        System.out.printf("Shipping fee : %d\n", shippingFee);
        System.out.printf("Paid amount  : %.2f\n", paidAmount);
        System.out.printf("Balance left : %.2f\n", customer.getBalance());
        System.out.printf("-----------------------------------\n");
    }

}
