package com.zkrallah.zbooks.model.book;

public abstract class Book {
    private final String title;
    private final String isbn;

    @Override
    public String toString() {
        return "Book [title=" + title + ", isbn=" + isbn + ", author=" + author + "]";
    }

    private final String author;
    private final int publishYear;
    private final int expiryYear;
    private final double price;
    private final int pages;

    public Book(final String title, final String isbn, final String author, final int publishYear, final int expiryYear,
            final double price,
            final int pages) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.publishYear = publishYear;
        this.expiryYear = expiryYear;
        this.price = price;
        this.pages = pages;
    }

    public boolean isOutdated(final int currentYear) {
        return currentYear > expiryYear;
    }

    // The reason why I kept this as an abstract method instead of putting
    // it in a separate interface like `Shippable` and `Mailable` is that
    // this is an attribute for all books and not a property that might
    // or might not be implemented
    public abstract boolean isPurchasable();

    // Mark the ISBN as the unique identifier of a book
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Book other = (Book) obj;
        return isbn.equals(other.isbn);
    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }

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

}
