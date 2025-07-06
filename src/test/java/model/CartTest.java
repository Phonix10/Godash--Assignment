package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.example.model.Cart;
import org.example.model.CartItem;
import org.example.model.SKU;
import org.junit.jupiter.api.Test;

public class CartTest {
     @Test
    public void testAddSingleItemToCart() {
        SKU a = new SKU("A", 50);
        Cart cart = new Cart();
        cart.addItem(a, 2);
        assertEquals(1, cart.getItems().size());
        assertEquals(100, cart.getTotalWithoutPromotions());
    }

    @Test
    public void testMultipleItemsTotal() {
        SKU a = new SKU("A", 50);
        SKU b = new SKU("B", 30);
        Cart cart = new Cart();
        cart.addItem(a, 1);
        cart.addItem(b, 2);
        assertEquals(110, cart.getTotalWithoutPromotions());
    }

    @Test
    public void testInvalidCartItemThrowsException() {
        SKU a = new SKU("A", 50);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new CartItem(a, 0);
        });
        assertEquals("Quantity must be greater than 0", ex.getMessage());
    }

    @Test
    public void testGetItemDetailsAfterAdding() {
        SKU c = new SKU("C", 20);
        Cart cart = new Cart();
        cart.addItem(c, 3);
        CartItem item = cart.getItems().get(0);
        assertEquals("C", item.getSku().getId());
        assertEquals(3, item.getQuantity());
        assertEquals(60, item.getTotalPrice());
    }

    @Test
    public void testAddingMultipleItemsOfSameSKU() {
        SKU d = new SKU("D", 15);
        Cart cart = new Cart();
        cart.addItem(d, 1);
        cart.addItem(d, 2);
        assertEquals(2, cart.getItems().size()); // No merge, should count as separate items
        assertEquals(45, cart.getTotalWithoutPromotions());
    }

    @Test
    public void testCartWithNoItemsShouldHaveZeroTotal() {
        Cart cart = new Cart();
        assertEquals(0, cart.getTotalWithoutPromotions());
    }
    
}
