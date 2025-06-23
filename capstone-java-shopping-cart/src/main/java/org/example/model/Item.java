package org.example.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Item implements ProductInterface {
    private String name;
    private BigDecimal price;
    private String sku;

    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public BigDecimal getPrice() {
        return price.setScale(2, RoundingMode.HALF_EVEN);
    }
    public void setPrice(BigDecimal price) {
        this.price = price.setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public String getSKU() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }
}
