package com.zkrallah.zbooks.service.inventory;

import java.util.List;

import com.zkrallah.zbooks.model.book.Book;
import com.zkrallah.zbooks.model.customer.Customer;

interface InventoryService {
    Book addBook(Book book);

    boolean removeBook(Book book);

    List<Book> getBooks();

    int modifyBookQuantity(Book book, int newQuantity);

    void checkOutdatedBooks(int currentYear);

    // IMPORTANT: You only mentioned buying a single book with an option
    // of more than one copy, but you DID NOT mention buying different books
    // at a time, so I didn't implement cart logic and instead, I only
    // implemented this function
    void buyBook(Customer customer, Book book, int quantity);
}
