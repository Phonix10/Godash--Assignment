package org.example.model;

public class SKU {
    private final String id;
    private final int unitPrice;

    public SKU(String id, int unitPrice) {
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
