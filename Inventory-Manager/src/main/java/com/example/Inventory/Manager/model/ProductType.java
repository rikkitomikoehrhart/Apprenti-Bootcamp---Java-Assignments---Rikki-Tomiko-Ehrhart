package com.example.Inventory.Manager.model;

import java.math.BigDecimal;

public interface ProductType {
    Product getProduct();
    String getProductID();
    void setProductID(String id);
    String getProductName();
    void setProductName(String name);
}
