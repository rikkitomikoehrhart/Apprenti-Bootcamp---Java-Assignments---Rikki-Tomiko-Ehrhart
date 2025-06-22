package org.example.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;


public class ShoppingCart {
    public HashMap<Item, Integer> cart;
    private BigDecimal total;

    public ShoppingCart() {
        this.cart = new HashMap<Item, Integer>();
        this.total = BigDecimal.valueOf(0.00);
    }



    public HashMap<Item, Integer> getCart() {
        return cart;
    }
    public void setCart(HashMap<Item, Integer> cart) {
        this.cart = cart;
    }

    public BigDecimal getTotal() {
        return total.setScale(2, RoundingMode.HALF_UP);
    }

    public void processTotal() {
        BigDecimal count = BigDecimal.ZERO;

        for (Item item : cart.keySet()) {
            BigDecimal price = item.getPrice();
            BigDecimal quantity = BigDecimal.valueOf(cart.get(item));

            total = total.add(price.multiply(quantity));
        }

    }

    public String getTotalForDisplay() {
        return String.format("$%.2f", getTotal());
    }
}
