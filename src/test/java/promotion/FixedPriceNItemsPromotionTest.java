package promotion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.model.Cart;
import org.example.model.SKU;
import org.example.promotion.FixedPriceNItemsPromotion;
import org.example.promotion.Promotion;
import org.junit.jupiter.api.Test;

public class FixedPriceNItemsPromotionTest {
    @Test
    public void testApplyPromotionWithExactMatch() {
        SKU a = new SKU("A", 50);
        Cart cart = new Cart();
        cart.addItem(a, 3); // 3 A's
        Promotion promo = new FixedPriceNItemsPromotion("A", 3, 130);
        assertEquals(130, promo.apply(cart));
    }

    @Test
    public void testApplyPromotionWithExtras() {
        SKU a = new SKU("A", 50);
        Cart cart = new Cart();
        cart.addItem(a, 4); // 3 A's for 130 + 1 A = 50
        Promotion promo = new FixedPriceNItemsPromotion("A", 3, 130);
        assertEquals(180, promo.apply(cart));
    }

    @Test
    public void testPromotionSkippedForDifferentSKU() {
        SKU b = new SKU("B", 30);
        Cart cart = new Cart();
        cart.addItem(b, 2); // Not eligible for this promo
        Promotion promo = new FixedPriceNItemsPromotion("A", 3, 130);
        assertEquals(60, promo.apply(cart));
    }
}
