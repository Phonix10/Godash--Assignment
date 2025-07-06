package org.example;

import java.util.Arrays;
import java.util.List;

import org.example.engine.PromotionEngine;
import org.example.model.Cart;
import org.example.model.CartItem;
import org.example.model.SKU;
import org.example.promotion.ComboPromotion;
import org.example.promotion.FixedPriceNItemsPromotion;
import org.example.promotion.Promotion;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Define SKUs and unit prices
        SKU skuA = new SKU("A", 50);
        SKU skuB = new SKU("B", 30);
        SKU skuC = new SKU("C", 20);
        SKU skuD = new SKU("D", 15);

        // Scenario C setup
        Cart cart = new Cart();
        cart.addItem(skuA, 3); // 3A = 130
        cart.addItem(skuB, 5); // 2B+2B+1B = 45+45+30
        cart.addItem(skuC, 1); // with D combo
        cart.addItem(skuD, 1); // C+D = 30

        // Active promotions
        List<Promotion> promotions = Arrays.asList(
                new FixedPriceNItemsPromotion("A", 3, 130),
                new FixedPriceNItemsPromotion("B", 2, 45),
                new ComboPromotion("C", "D", 30)
        );

        // Use PromotionEngine
        PromotionEngine engine = new PromotionEngine(promotions);
        int total = engine.applyPromotions(cart);

        System.out.println("=== Checkout Summary ===");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%s x %d = %d%n", item.getSku().getId(), item.getQuantity(), item.getTotalPrice());
        }
        System.out.println("--------------------------");
        System.out.println("Total Price After Promotions: ₹" + total);
    }
}