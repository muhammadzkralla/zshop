package com.zkrallah.zbooks.model.types;

import com.zkrallah.zbooks.book.Book;
import com.zkrallah.zbooks.book.Mailable;

public class EBook extends Book implements Mailable {

    public EBook(final String title, final String isbn, final String author, final int publishYear,
            final int expiryYear, final double price,
            final int pages) {
        super(title, isbn, author, publishYear, expiryYear, price, pages);
    }

    @Override
    public boolean isPurchasable() {
        return true;
    }

}
