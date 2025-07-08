package com.zkrallah.zbooks.model.types;

import com.zkrallah.zbooks.book.Book;

public class DemoBook extends Book {

    public DemoBook(String title, String isbn, String author, int publishYear, int expiryYear, double price,
            int pages) {
        super(title, isbn, author, publishYear, expiryYear, price, pages);
    }

    @Override
    public boolean isPurchasable() {
        return false;
    }

}
