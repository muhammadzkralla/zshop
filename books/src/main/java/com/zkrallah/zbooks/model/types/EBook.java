package com.zkrallah.zbooks.model.types;

import com.zkrallah.zbooks.model.book.Book;
import com.zkrallah.zbooks.model.book.Mailable;

public class EBook extends Book implements Mailable {

    private final String fileType;

    public EBook(final String title, final String isbn, final String author, final int publishYear,
            final int expiryYear, final double price,
            final int pages, final String fileType) {
        super(title, isbn, author, publishYear, expiryYear, price, pages);
        this.fileType = fileType;
    }

    @Override
    public boolean isPurchasable() {
        return true;
    }

    public String getFileType() {
        return fileType;
    }

}
