package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> items = new ArrayList<>();

    public void addItem(SKU sku, int quantity) {
        items.add(new CartItem(sku, quantity));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public int getTotalWithoutPromotions() {
        return items.stream()
                .mapToInt(CartItem::getTotalPrice)
                .sum();
    }
    public Cart cloneCart() {
        Cart clone = new Cart();
        for (CartItem item : items) {
            clone.addItem(item.getSku(), item.getQuantity());
        }
        return clone;
    }
    
}

