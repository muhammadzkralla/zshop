package com.zkrallah.zshop.cart;

import java.util.List;

import com.zkrallah.zshop.product.Product;

// I could make some functions return void instead of returning something
// but I preferred this way to ensure the process is done successfully.
// It's a trade-off, if memory is crucial, we may follow the other approach.
interface CartService {
    CartItem addItem(Product product, int initialCount);

    Boolean removeItem(CartItem item);

    List<CartItem> getCartItems();

    Boolean IncrementItemCount(CartItem item);

    Boolean decrementItemCount(CartItem item);

    Boolean changeItemCount(CartItem item, int newCount);

    void clearCart();

    Boolean isEmpty();
}
