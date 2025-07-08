package com.zkrallah.zshop.cart;

import java.util.ArrayList;
import java.util.List;

import com.zkrallah.zshop.product.Expirable;
import com.zkrallah.zshop.product.Product;

public class CartServiceImpl implements CartService {

    private final List<CartItem> items = new ArrayList<>();

    @Override
    public CartItem addItem(final Product product, final int initialCount) {
        if (product.getQuantity() < initialCount) {
            System.out.println("Insufficient amount in inventory!");
            return null;
        }

        if (product instanceof Expirable) {
            if (((Expirable) product).isExpired()) {
                System.out.println("Product Expired!");
                return null;
            }
        }

        final CartItem item = new CartItem(product, initialCount);
        if (items.add(item)) {
            return item;
        }

        return null;
    }

    @Override
    public Boolean removeItem(final CartItem item) {
        return items.remove(item);
    }

    @Override
    public void clearCart() {
        items.clear();
    }

    @Override
    public Boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public List<CartItem> getCartItems() {
        return items;
    }

    @Override
    public Boolean IncrementItemCount(final CartItem item) {
        if (item != null && items.contains(item)) {
            final int itemCount = item.getCount();
            return changeItemCount(item, itemCount + 1);
        } else {
            System.out.println("Could not find item in cart!");
        }

        return false;
    }

    @Override
    public Boolean decrementItemCount(final CartItem item) {
        if (item != null && items.contains(item)) {
            final int itemCount = item.getCount();
            return changeItemCount(item, itemCount - 1);
        } else {
            System.out.println("Could not find item in cart!");
        }

        return false;

    }

    @Override
    public Boolean changeItemCount(final CartItem item, final int newCount) {
        if (newCount < 1) {
            System.out.println("Item count must be at least 1.");
            return false;
        }

        if (item != null && items.contains(item)) {
            try {
                item.setCount(newCount);
                return true;
            } catch (final Exception ex) {
                System.out.println("Unexpected error happened: " + ex.getMessage());
            }
        } else {
            System.out.println("Could not find item in cart!");
        }

        return false;
    }
}
