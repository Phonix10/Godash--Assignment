package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.example.model.SKU;
import org.junit.jupiter.api.Test;

public class SKUTest {
    

    @Test
    public void testSKUCreation() {
        SKU sku = new SKU("A", 50);
        assertEquals("A", sku.getId());
        assertEquals(50, sku.getUnitPrice());
    }

    @Test
    public void testSKUWithDifferentIdAndPrice() {
        SKU sku = new SKU("B", 30);
        assertEquals("B", sku.getId());
        assertEquals(30, sku.getUnitPrice());
    }

    @Test
    public void testSKUWithEdgeCaseZeroPrice() {
        SKU sku = new SKU("X", 0);
        assertEquals("X", sku.getId());
        assertEquals(0, sku.getUnitPrice());
    }

    @Test
    public void testSKUWithNullIdShouldThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new SKU(null, 50);
        });
        assertEquals("SKU ID cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testSKUWithEmptyIdShouldThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new SKU("  ", 50);
        });
        assertEquals("SKU ID cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testSKUWithNegativePriceShouldThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new SKU("A", -10);
        });
        assertEquals("Unit price cannot be negative", exception.getMessage());
    }

    
    
}
