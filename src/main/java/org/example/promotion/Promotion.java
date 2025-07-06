package org.example.promotion;

import org.example.model.Cart;

public interface Promotion {
    int apply(Cart cart);
}
