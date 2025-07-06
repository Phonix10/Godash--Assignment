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


public class Main {
    public static void main(String[] args) {

        SKU skuA = new SKU("A", 50);
        SKU skuB = new SKU("B", 30);
        SKU skuC = new SKU("C", 20);
        SKU skuD = new SKU("D", 15);


        Cart cart = new Cart();
        cart.addItem(skuA, 3); 
        cart.addItem(skuB, 5); 
        cart.addItem(skuC, 1); 
        cart.addItem(skuD, 1); 

        List<Promotion> promotions = Arrays.asList(
                new FixedPriceNItemsPromotion("A", 3, 130),
                new FixedPriceNItemsPromotion("B", 2, 45),
                new ComboPromotion("C", "D", 30)
        );


        PromotionEngine engine = new PromotionEngine(promotions);
        int total = engine.applyPromotions(cart);

        System.out.println("=== Checkout Summary ===");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%s x %d = %d%n", item.getSku().getId(), item.getQuantity(), item.getTotalPrice());
        }
        System.out.println("--------------------------");
        System.out.println("Total Price After Promotions: " + total);
    }
}