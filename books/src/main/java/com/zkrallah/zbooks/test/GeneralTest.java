package com.zkrallah.zbooks.test;

import java.util.List;

import com.zkrallah.zbooks.factory.BookFactory;
import com.zkrallah.zbooks.model.book.Book;
import com.zkrallah.zbooks.model.customer.Customer;
import com.zkrallah.zbooks.service.inventory.InventoryServiceImpl;

public class GeneralTest {

    private static List<Book> books;

    public static void test() {

        final InventoryServiceImpl inventory = InventoryServiceImpl.getInstance();

        // Create books
        final Book paperBook = BookFactory.createPaperBook(
                "DDIA", "ISBN-101", "Martin Kleppmann", 2017, 2030, 55.0, 416, 5);

        final Book ebook = BookFactory.createEBook(
                "Grokking Concurrency", "ISBN-102", "Kiril Bobrov", 2024, 2030, 45.0, 432, "PDF");

        final Book demoBook = BookFactory.createDemoBook(
                "NeoVim", "ISBN-103", "Zkrallah", 2020, 2025, 0.0, 100);

        // Add outdated book
        final Book outdatedBook = BookFactory.createPaperBook(
                "Old Book", "ISBN-999", "Vintage Author", 2000, 2023, 10.0, 300, 10);

        // Create customer
        final Customer customer1 = new Customer(
                "zkrallah", 200.0, "Egypt, Cairo", "zkrallah@example.com");

        // Create customer
        final Customer customer2 = new Customer(
                "rich zkrallah", 1000.0, "Egypt, Cairo", "zkrallah@example.com");

        System.out.println("--------------CUSTOMER ONE TURN-----------------");

        // Add books
        inventory.addBook(paperBook);
        inventory.addBook(ebook);
        inventory.addBook(demoBook);
        inventory.addBook(outdatedBook);

        // Try adding duplicate
        inventory.addBook(paperBook);

        System.out.println("\nBooks in inventory before removing outdated books: ");
        books = inventory.getBooks();
        for (Book book : books) {
            System.out.println(book);
        }

        // Remove outdated books
        inventory.checkOutdatedBooks(2025);

        System.out.println("\nBooks in inventory after removing outdated books: ");
        books = inventory.getBooks();
        for (Book book : books) {
            System.out.println(book);
        }

        System.out.println("\nBooks in inventory before removing: ");
        books = inventory.getBooks();
        for (Book book : books) {
            System.out.println(book);
        }

        // Remove a book
        inventory.removeBook(demoBook);

        System.out.println("\nBooks in inventory after removing: ");
        books = inventory.getBooks();
        for (Book book : books) {
            System.out.println(book);
        }

        // Buy 2 copies of paper book
        System.out.println("\nBuying paper book:");
        inventory.buyBook(customer1, paperBook, 2);

        // Buy eBook
        System.out.println("\nBuying ebook:");
        inventory.buyBook(customer1, ebook, 1);

        // Attempt to buy more paper books than available
        System.out.println("\nBuying too many paper books:");
        // Should fail
        inventory.buyBook(customer1, paperBook, 20);

        // Attempt to buy with low balance
        System.out.println("\nBuying when balance is low:");
        // Might fail based on balance left
        inventory.buyBook(customer1, ebook, 1);

        System.out.println("--------------CUSTOMER TWO TURN-----------------");

        // Buy exactly all remaining paper books (3)
        System.out.println("\nBuying all remaining paper books:");
        inventory.buyBook(customer2, paperBook, 3);

        // Attempt to buy 1 more, should fail
        System.out.println("\nBuying after stock is 0:");
        // Should fail
        inventory.buyBook(customer2, paperBook, 1);

        // Buy another ebook
        System.out.println("\nBuying ebook:");
        inventory.buyBook(customer2, ebook, 1);

        // Attempt to buy removed book
        System.out.println("\nBuying removed demo book:");
        // Should fail
        inventory.buyBook(customer2, demoBook, 1);
    }

}
