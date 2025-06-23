package org.example.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;


public class ShoppingCart {
    public HashMap<Item, Integer> cart;
    private BigDecimal total;

    public ShoppingCart() {
        this.cart = new HashMap<>();
        this.total = BigDecimal.ZERO;
    }



    private BigDecimal getTotal() {
        return total.setScale(2, RoundingMode.HALF_UP);
    }

    public void processTotal() {
        total = BigDecimal.ZERO;

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
