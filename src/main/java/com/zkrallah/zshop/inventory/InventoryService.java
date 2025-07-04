package com.zkrallah.zshop.inventory;

import java.time.LocalDate;
import java.util.List;

import com.zkrallah.zshop.product.Product;

// I could make some functions return void instead of returning something
// but I preferred this way to ensure the process is done successfully.
// It's a trade-off, if memory is crucial, we may follow the other approach.
interface InventoryService {

    Product addProduct(Product product);

    Boolean removeProduct(Product product);

    List<Product> getInventoryProducts();

    Product modifyProductName(Product product, String newName);

    Product modifyProductQuantity(Product product, int newQuantity);

    Product modifyProductPrice(Product product, double newPrice);

    Product modifyProductWeight(Product product, double newWeight);

    Product modifyProductExpiryDate(Product product, LocalDate newDate);
}
