package com.example.Inventory.Manager.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PerishableProduct implements Product {
    private String productId;
    private String productName;
    private int quantity;
    private BigDecimal price;
    private LocalDate expirationDate;

    public PerishableProduct(String productId, String productName, int quantity, BigDecimal price, LocalDate expirationDate) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.expirationDate = expirationDate;
    }

    @Override
    public String getProductID() {
        return productId;
    }

    @Override
    public void setProductID(String id) {
        this.productId = id;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public void setProductName(String name) {
        this.productName = name;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expirationDate);
    }
}
