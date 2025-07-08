package com.zkrallah.zbooks.factory;

import com.zkrallah.zbooks.model.types.PaperBook;
import com.zkrallah.zbooks.model.types.EBook;
import com.zkrallah.zbooks.model.types.DemoBook;

public class BookFactory {

    public static PaperBook createPaperBook(String title, String isbn, String author,
            int publishYear, int expiryYear, double price,
            int pages, int quantity) {
        return new PaperBook(title, isbn, author, publishYear, expiryYear, price, pages, quantity);
    }

    public static EBook createEBook(String title, String isbn, String author,
            int publishYear, int expiryYear, double price,
            int pages, String fileType) {
        return new EBook(title, isbn, author, publishYear, expiryYear, price, pages, fileType);
    }

    public static DemoBook createDemoBook(String title, String isbn, String author,
            int publishYear, int expiryYear, double price,
            int pages) {
        return new DemoBook(title, isbn, author, publishYear, expiryYear, price, pages);
    }

}
