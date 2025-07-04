package com.zkrallah.zshop.shipping;

import java.util.List;

import com.zkrallah.zshop.product.Shippable;

public class ShippingService {
    public void shipItems(final List<Shippable> items) {
        if (items == null || items.isEmpty()) {
            System.out.println("No shippable items.");
            return;
        }

        System.out.println("\nShipping the following items:");

        for (final Shippable item : items) {
            System.out.printf("name: %s, weight: %.2f\n", item.getName(), item.getWeight());
        }
    }
}
