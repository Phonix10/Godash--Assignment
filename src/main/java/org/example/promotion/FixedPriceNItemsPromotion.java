package org.example.promotion;

import java.util.List;

import org.example.model.Cart;
import org.example.model.CartItem;

public class FixedPriceNItemsPromotion implements Promotion {

    private final String skuId;
    private final int requiredQuantity;
    private final int fixedPrice;

    public FixedPriceNItemsPromotion(String skuId, int requiredQuantity, int fixedPrice) {
        this.skuId = skuId;
        this.requiredQuantity = requiredQuantity;
        this.fixedPrice = fixedPrice;
    }

    @Override
    public int apply(Cart cart) {
        List<CartItem> items = cart.getItems();
        int total = 0;

        for (CartItem item : items) {
            if (item.getSku().getId().equals(skuId)) {
                int quantity = item.getQuantity();
                int promoSets = quantity / requiredQuantity;
                int remainder = quantity % requiredQuantity;
                total += promoSets * fixedPrice + remainder * item.getSku().getUnitPrice();
            } else {
                total += item.getTotalPrice();
            }
        }

        return total;
    }
}
    

