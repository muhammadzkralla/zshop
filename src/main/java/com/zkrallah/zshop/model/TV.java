package com.zkrallah.zshop.model;

import com.zkrallah.zshop.product.Product;
import com.zkrallah.zshop.product.Shippable;

public class TV extends Product implements Shippable {
    private double weight;

    public TV(final String name, final double price, final int quantity, final double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void setWeight(final double weight) {
        this.weight = weight;
    }
}
