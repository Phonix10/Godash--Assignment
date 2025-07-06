package org.example.model;

public class SKU {
    private final String id;
    private final int unitPrice;

    public SKU(String id, int unitPrice) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("SKU ID cannot be null or empty");
        }
        if (unitPrice < 0) {
            throw new IllegalArgumentException("Unit price cannot be negative");
        }
        this.id = id;
        this.unitPrice = unitPrice;
    }

    public String getId() {
        return id;
    }

    public int getUnitPrice() {
        return unitPrice;
    }
    
}
