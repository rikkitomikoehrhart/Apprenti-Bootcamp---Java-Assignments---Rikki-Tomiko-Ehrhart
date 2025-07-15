package com.example.Inventory.Manager.model;

import java.time.LocalDate;

public class PerishableProduct implements ProductType {
    private Product product;
    private LocalDate expirationDate;

    public PerishableProduct(Product product, LocalDate expirationDate) {
        this.product = product;
        this.expirationDate = expirationDate;
    }

    @Override
    public Product getProduct() {
        return product;
    }

    @Override
    public String getProductID() {
        return product.getProductId();
    }

    @Override
    public void setProductID(String id) {
        this.product.setProductId(id);
    }

    @Override
    public String getProductName() {
        return product.getProductName();
    }

    @Override
    public void setProductName(String name) {
        product.setProductName(name);
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

}
