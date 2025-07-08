package com.zkrallah.zbooks.model.book;

public abstract class Book {
    private final String title;
    private final String isbn;
    private final String author;
    private final int publishYear;
    private final int expiryYear;
    private final double price;
    private final int pages;
    private int quantity;

    public Book(final String title, final String isbn, final String author, final int publishYear, final int expiryYear,
            final double price,
            final int pages, final int quantity) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.publishYear = publishYear;
        this.expiryYear = expiryYear;
        this.price = price;
        this.pages = pages;
        this.quantity = quantity;
    }

    public boolean isOutdated(final int currentYear) {
        return currentYear > expiryYear;
    }

    // The reason why I kept this as an abstract method instead of putting
    // it in a separate interface like `Shippable` and `Mailable` is that
    // this is an attribute for all books and not a property that might
    // or might not be implemented
    public abstract boolean isPurchasable();

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public int getExpiryYear() {
        return expiryYear;
    }

    public double getPrice() {
        return price;
    }

    public int getPages() {
        return pages;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            System.out.println("Quantity can not be negative!");
            return;
        }

        this.quantity = quantity;
    }

}
