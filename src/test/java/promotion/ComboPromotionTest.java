package promotion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.model.Cart;
import org.example.model.SKU;
import org.example.promotion.ComboPromotion;
import org.junit.jupiter.api.Test;

public class ComboPromotionTest {
     @Test
    public void testSingleComboApplied() {
        SKU c = new SKU("C", 20);
        SKU d = new SKU("D", 15);

        Cart cart = new Cart();
        cart.addItem(c, 1);
        cart.addItem(d, 1);

        ComboPromotion promo = new ComboPromotion("C", "D", 30);
        assertEquals(30, promo.apply(cart));
    }

    @Test
    public void testComboWithExtraC() {
        SKU c = new SKU("C", 20);
        SKU d = new SKU("D", 15);

        Cart cart = new Cart();
        cart.addItem(c, 2); // 1 extra
        cart.addItem(d, 1);

        ComboPromotion promo = new ComboPromotion("C", "D", 30);
        assertEquals(30 + 20, promo.apply(cart)); // combo + 1C
    }

    @Test
    public void testComboWithExtraD() {
        SKU c = new SKU("C", 20);
        SKU d = new SKU("D", 15);

        Cart cart = new Cart();
        cart.addItem(c, 1);
        cart.addItem(d, 3); // 2 extra

        ComboPromotion promo = new ComboPromotion("C", "D", 30);
        assertEquals(30 + (2 * 15), promo.apply(cart)); // combo + 2D
    }

    @Test
    public void testNoComboApplied() {
        SKU c = new SKU("C", 20);
        Cart cart = new Cart();
        cart.addItem(c, 1);

        ComboPromotion promo = new ComboPromotion("C", "D", 30);
        assertEquals(20, promo.apply(cart));
    }

    @Test
    public void testUnrelatedItemsRemainUnaffected() {
        SKU a = new SKU("A", 50);
        SKU c = new SKU("C", 20);
        SKU d = new SKU("D", 15);

        Cart cart = new Cart();
        cart.addItem(a, 2); // ₹100
        cart.addItem(c, 1); // combo
        cart.addItem(d, 1); // combo

        ComboPromotion promo = new ComboPromotion("C", "D", 30);
        assertEquals(100 + 30, promo.apply(cart));
    }
    
}
