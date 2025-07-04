package com.zkrallah.zshop.model;

import java.time.LocalDate;

import com.zkrallah.zshop.product.Expirable;
import com.zkrallah.zshop.product.Product;
import com.zkrallah.zshop.product.Shippable;

public class Cheese extends Product implements Expirable, Shippable {
    private double weight;
    private LocalDate expiryDate;

    public Cheese(final String name, final double price, final int quantity, final double weight,
            final LocalDate expiryDate) {
        super(name, price, quantity);
        this.weight = weight;
        this.expiryDate = expiryDate;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public Boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    @Override
    public void setWeight(final double weight) {
        if (weight <= 0) {
            System.out.println("Weight must be positive");
        } else {
            this.weight = weight;
        }
    }

    @Override
    public void setExpiryDate(final LocalDate date) {
        this.expiryDate = date;
    }
}
