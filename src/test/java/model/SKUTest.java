package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.model.SKU;
import org.junit.jupiter.api.Test;

public class SKUTest {
    

    @Test
    public void testSKUCreation() {
        SKU sku = new SKU("A", 50);
        assertEquals("A", sku.getId());
        assertEquals(50, sku.getUnitPrice());
    }

    
    
}
