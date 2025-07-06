package org.example.model;

public class CartItem {
    private final SKU sku;
    private final int quantity;

    public CartItem(SKU sku, int quantity) {
        if (sku == null) {
            throw new IllegalArgumentException("SKU cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        this.sku = sku;
        this.quantity = quantity;
    }

    public SKU getSku() {
        return sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return sku.getUnitPrice() * quantity;
    }
    
}
