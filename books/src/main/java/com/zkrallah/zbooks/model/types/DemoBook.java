package com.zkrallah.zbooks.model.types;

import com.zkrallah.zbooks.model.book.Book;

public class DemoBook extends Book {

    public DemoBook(final String title, final String isbn, final String author, final int publishYear,
            final int expiryYear, final double price,
            final int pages) {
        super(title, isbn, author, publishYear, expiryYear, price, pages);
    }

    @Override
    public boolean isPurchasable() {
        return false;
    }

}
