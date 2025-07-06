package org.example.promotion;

import java.util.List;

import org.example.model.Cart;
import org.example.model.CartItem;

public class ComboPromotion implements Promotion {

    private final String sku1;
    private final String sku2;
    private final int comboPrice;

    public ComboPromotion(String sku1, String sku2, int comboPrice) {
        this.sku1 = sku1;
        this.sku2 = sku2;
        this.comboPrice = comboPrice;
    }

    @Override
    public int apply(Cart cart) {
        List<CartItem> items = cart.getItems();
        int count1 = 0, count2 = 0;
        int price1 = 0, price2 = 0;
        int otherTotal = 0;

        for (CartItem item : items) {
            String id = item.getSku().getId();
            if (id.equals(sku1)) {
                count1 = item.getQuantity();
                price1 = item.getSku().getUnitPrice();
            } else if (id.equals(sku2)) {
                count2 = item.getQuantity();
                price2 = item.getSku().getUnitPrice();
            } else {
                otherTotal += item.getTotalPrice();
            }
        }

        int comboCount = Math.min(count1, count2);
        int remaining1 = count1 - comboCount;
        int remaining2 = count2 - comboCount;

        return (comboCount * comboPrice) + (remaining1 * price1) + (remaining2 * price2) + otherTotal;
    }
    
}
