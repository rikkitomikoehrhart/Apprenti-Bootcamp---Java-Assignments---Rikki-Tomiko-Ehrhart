package org.example.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Item {
    private String name;
    private BigDecimal price;
    private String sku;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price.setScale(2, RoundingMode.HALF_EVEN);
    }
    public void setPrice(BigDecimal price) {
        this.price = price.setScale(2, RoundingMode.HALF_EVEN);
    }

    public String getSKU() {
        return sku;
    }
    public void setSKU(String sku) {
        this.sku = sku;
    }
}
