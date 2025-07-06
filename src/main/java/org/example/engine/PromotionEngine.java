package org.example.engine;

import java.util.List;

import org.example.model.Cart;
import org.example.promotion.Promotion;

public class PromotionEngine {
    private final List<Promotion> promotions;

    public PromotionEngine(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public int applyPromotions(Cart cart) {
        int total = cart.getTotalWithoutPromotions(); // Start from regular total

        for (Promotion promo : promotions) {
            total = Math.min(total, promo.apply(cart)); // Use best discount
        }

        return total;
        }
}
