package com.zkrallah.zshop.inventory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.zkrallah.zshop.product.Expirable;
import com.zkrallah.zshop.product.Product;
import com.zkrallah.zshop.product.Shippable;

public class InventoryServiceImpl implements InventoryService {

    private static final InventoryServiceImpl INSTANCE = new InventoryServiceImpl();

    private final List<Product> products = new ArrayList<>();

    // Private constructor for the singleton design pattern
    private InventoryServiceImpl() {
    }

    // Apply the singleton design pattern as we only have one inventory
    public static InventoryServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public Product addProduct(final Product product) {
        if (products.contains(product)) {
            System.out.println("Product already exists in inventory.");
            return null;
        }

        products.add(product);
        return product;

    }

    @Override
    public Boolean removeProduct(final Product product) {
        return products.remove(product);
    }

    @Override
    public List<Product> getInventoryProducts() {
        return products;
    }

    @Override
    public Product modifyProductName(final Product product, final String newName) {
        if (product != null && products.contains(product)) {
            product.setName(newName);
            return product;
        } else {
            System.out.println("Could not find product in inventory!");
        }

        return null;
    }

    @Override
    public Product modifyProductQuantity(final Product product, final int newQuantity) {
        if (product != null && products.contains(product)) {
            product.setQuantity(newQuantity);
            return product;
        } else {
            System.out.println("Could not find product in inventory!");
        }

        return null;
    }

    @Override
    public Product modifyProductPrice(final Product product, final double newPrice) {
        if (product != null && products.contains(product)) {
            product.setPrice(newPrice);
            return product;
        } else {
            System.out.println("Could not find product in inventory!");
        }

        return null;
    }

    @Override
    public Product modifyProductWeight(final Product product, final double newWeight) {
        if (product instanceof Shippable) {
            // Cast is 100% safe as we check for the instance before casting
            ((Shippable) product).setWeight(newWeight);
            return product;
        } else {
            System.out.println("Product is not shippable!");
            return null;
        }
    }

    @Override
    public Product modifyProductExpiryDate(final Product product, final LocalDate newDate) {
        if (product instanceof Expirable) {
            // Cast is 100% safe as we check for the instance before casting
            ((Expirable) product).setExpiryDate(newDate);
            return product;
        } else {
            System.out.println("Product is not expirable!");
            return null;
        }
    }
}
