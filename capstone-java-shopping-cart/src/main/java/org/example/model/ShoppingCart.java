package org.example.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Set;


public class ShoppingCart {
    private final HashMap<Item, Integer> cart;
    private BigDecimal total;

    public ShoppingCart() {
        this.cart = new HashMap<>();
        this.total = BigDecimal.ZERO;
    }

    public void addItem(Item item, int quantity) {
        cart.put(item, quantity);
        calculateTotal();
    }

    public void removeItem(Item item) {
        cart.remove(item);
        calculateTotal();
    }

    public void empty() {
        cart.clear();
        total = BigDecimal.ZERO;
    }

    public int getQuantity(Item item) {
        return cart.getOrDefault(item, 0);
    }

    public boolean isEmpty() {
        return cart.isEmpty();
    }

    public BigDecimal getTotal() {
        return total.setScale(2, RoundingMode.HALF_UP);
    }

    public void calculateTotal() {
        total = BigDecimal.ZERO;

        for (Item item : cart.keySet()) {
            BigDecimal price = item.getPrice();
            BigDecimal quantity = BigDecimal.valueOf(cart.get(item));

            total = total.add(price.multiply(quantity));
        }
    }
    

    public Set<Item> getItems() {
        return cart.keySet();
    }


}
