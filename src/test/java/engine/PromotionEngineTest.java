package engine;


import org.example.model.*;
import org.example.promotion.*;
import org.example.engine.PromotionEngine;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PromotionEngineTest {

    @Test
    public void testScenarioA() {
        SKU a = new SKU("A", 50);
        SKU b = new SKU("B", 30);
        SKU c = new SKU("C", 20);

        Cart cart = new Cart();
        cart.addItem(a, 1);
        cart.addItem(b, 1);
        cart.addItem(c, 1);

        PromotionEngine engine = new PromotionEngine(Arrays.asList(
                new FixedPriceNItemsPromotion("A", 3, 130),
                new FixedPriceNItemsPromotion("B", 2, 45),
                new ComboPromotion("C", "D", 30)
        ));

        assertEquals(100, engine.applyPromotions(cart));
    }

    @Test
    public void testScenarioB() {
        SKU a = new SKU("A", 50);
        SKU b = new SKU("B", 30);
        SKU c = new SKU("C", 20);

        Cart cart = new Cart();
        cart.addItem(a, 5); // 130 + 2x50
        cart.addItem(b, 5); // 2x45 + 30
        cart.addItem(c, 1);

        PromotionEngine engine = new PromotionEngine(Arrays.asList(
                new FixedPriceNItemsPromotion("A", 3, 130),
                new FixedPriceNItemsPromotion("B", 2, 45),
                new ComboPromotion("C", "D", 30)
        ));

        assertEquals(370, engine.applyPromotions(cart));
    }

    @Test
    public void testScenarioC() {
        SKU a = new SKU("A", 50);
        SKU b = new SKU("B", 30);
        SKU c = new SKU("C", 20);
        SKU d = new SKU("D", 15);

        Cart cart = new Cart();
        cart.addItem(a, 3); // 130
        cart.addItem(b, 5); // 2x45 + 30
        cart.addItem(c, 1);
        cart.addItem(d, 1); // C+D combo = 30

        PromotionEngine engine = new PromotionEngine(Arrays.asList(
                new FixedPriceNItemsPromotion("A", 3, 130),
                new FixedPriceNItemsPromotion("B", 2, 45),
                new ComboPromotion("C", "D", 30)
        ));

        assertEquals(280, engine.applyPromotions(cart));
    }
}