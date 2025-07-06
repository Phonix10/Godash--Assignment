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
        Cart tempCart = cart.cloneCart(); // use a copy for isolated mutation if needed
        int total = 0;

        for (Promotion promo : promotions) {
            total = promo.apply(tempCart);
            tempCart = cart; // (Optional): if each promo should apply independently, reuse cart
        }

        return total;
    }
}
