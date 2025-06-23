package org.example.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;


public class ShoppingCart {
    private HashMap<Item, Integer> cart;
    private BigDecimal total;

    public ShoppingCart() {
        this.cart = new HashMap<>();
        this.total = BigDecimal.ZERO;
    }

    public HashMap<Item, Integer> getCart() {
        return cart;
    }

    public BigDecimal getTotal() {
        return total.setScale(2, RoundingMode.HALF_UP);
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
