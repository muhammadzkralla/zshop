package com.zkrallah.zbooks.model.types;

import com.zkrallah.zbooks.model.book.Book;
import com.zkrallah.zbooks.model.book.Shippable;

public class PaperBook extends Book implements Shippable {
    private int quantity;

    public PaperBook(final String title, final String isbn, final String author, final int publishYear,
            final int expiryYear, final double price, final int pages, final int quantity) {
        super(title, isbn, author, publishYear, expiryYear, price, pages);
        this.quantity = quantity;
    }

    @Override
    public boolean isPurchasable() {
        return true;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(final int quantity) {
        if (quantity < 0) {
            System.out.println("Quantity cannot be negative!");
            return;
        }
        this.quantity = quantity;
    }

}
