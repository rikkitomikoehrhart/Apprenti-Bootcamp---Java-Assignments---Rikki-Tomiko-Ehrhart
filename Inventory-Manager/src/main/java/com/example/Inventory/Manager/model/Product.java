package com.example.Inventory.Manager.model;

import java.math.BigDecimal;

public interface Product {
    String getProductID();
    void setProductID(String id);
    String getProductName();
    void setProductName(String name);
    int getQuantity();
    void setQuantity(int quantity);
    BigDecimal getPrice();
    void setPrice(BigDecimal price);
}
