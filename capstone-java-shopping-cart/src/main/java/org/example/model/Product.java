package org.example.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
    private String name;
    private BigDecimal price;
    private String sku;

    public String getName() {
        return name;
    }
    public BigDecimal getPrice() {
        return price.setScale(2, RoundingMode.HALF_EVEN);
    }
    public String getSKU() {
        return sku;
    }

    public void setAll(String name, BigDecimal price, String sku) {
        this.name = name;
        this.price = price.setScale(2, RoundingMode.HALF_EVEN);
        this.sku = sku;
    }
}
