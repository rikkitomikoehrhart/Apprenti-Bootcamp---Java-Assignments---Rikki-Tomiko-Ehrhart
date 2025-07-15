package com.example.Inventory.Manager.model;

import java.math.BigDecimal;

public class CartItem {
    InventoryItem item;
    int quantity;
    BigDecimal subTotal;

    public CartItem(InventoryItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        this.subTotal = item.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    public InventoryItem getItem() {
        return item;
    }

    public void setItem(InventoryItem item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

}
