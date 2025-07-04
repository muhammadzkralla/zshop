package com.zkrallah.zshop.model;

import java.time.LocalDate;

import com.zkrallah.zshop.product.Expirable;
import com.zkrallah.zshop.product.Product;

public class Biscuit extends Product implements Expirable {
    private LocalDate expiryDate;

    public Biscuit(final String name, final double price, final int quantity, final LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public Boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    @Override
    public void setExpiryDate(final LocalDate date) {
        this.expiryDate = date;
    }
}
