package com.example.Inventory.Manager.service;

import com.example.Inventory.Manager.model.InventoryItem;
import com.example.Inventory.Manager.model.PerishableProduct;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ProductService {

    public void addStock(InventoryItem product, int quantityChange) {
        product.setQuantity(product.getQuantity() + quantityChange);
    }

    public void removeStock(InventoryItem product, int quantityChange) {
        if (quantityChange < product.getQuantity()) {
            product.setQuantity(product.getQuantity() - quantityChange);
        } else {
            product.setQuantity(0);
        }
    }

    public void increasePrice(InventoryItem product, BigDecimal priceChange) {
        product.setPrice(product.getPrice().add(priceChange));
    }

    public void decreasePrice(InventoryItem product, BigDecimal priceChange) {
        if (product.getPrice().compareTo(priceChange) > 0) {
            product.setPrice(product.getPrice().subtract(priceChange));
        } else {
            product.setPrice(BigDecimal.ZERO);
        }
    }

    public Long daysUntilExpirationDate(PerishableProduct product) {
        return LocalDate.now().until(product.getExpirationDate(), ChronoUnit.DAYS);
    }

}
