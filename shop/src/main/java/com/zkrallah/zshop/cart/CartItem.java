package com.zkrallah.zshop.cart;

import com.zkrallah.zshop.product.Product;

public class CartItem {
    private final Product product;
    private int count;

    public CartItem(final Product product, final int count) {
        this.product = product;
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    // I overrided the toString function for readability in console
    @Override
    public String toString() {
        return "CartItem [product=" + product + ", count=" + count + "]";
    }

    public int getCount() {
        return count;
    }

    public void setCount(final int count) {
        this.count = count;
    }
}
