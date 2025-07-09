package com.example.Inventory.Manager.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTests {
    InventoryItem product;

    @BeforeEach
    void setUp() {
        product = new InventoryItem(new PerishableProduct(new Product("ID", "Name"), LocalDate.of(2025, 7,26)), 100, BigDecimal.valueOf(100.00));

    }

    @Test
    @DisplayName("PerishableProduct -- Check Getters")
    void gettersCheck() {
        PerishableProduct perishable = (PerishableProduct) product.getProduct();

        assertEquals("ID", product.getProduct().getProductID());
        assertEquals("Name", product.getProduct().getProductName());
        assertEquals(100, product.getQuantity());
        assertEquals(BigDecimal.valueOf(100.00), product.getPrice());
        assertEquals(LocalDate.of(2025, 7, 26), perishable.getExpirationDate());

    }

    @Test
    @DisplayName("PerishableProduct -- Check Setters")
    void settersCheck() {
        PerishableProduct perishable = (PerishableProduct) product.getProduct();

        product.getProduct().setProductID("identification");
        product.getProduct().setProductName("Product");
        product.setQuantity(13);
        product.setPrice(BigDecimal.valueOf(99.99));
        perishable.setExpirationDate(LocalDate.of(2025, 10, 2));


        assertEquals("identification", product.getProduct().getProductID());
        assertEquals("Product", product.getProduct().getProductName());
        assertEquals(13, product.getQuantity());
        assertEquals(BigDecimal.valueOf(99.99), product.getPrice());
        assertEquals(LocalDate.of(2025, 10, 2), perishable.getExpirationDate());

    }

    @Test
    @DisplayName("Check isExpired True/False")
    void checkIsExpired() {
        PerishableProduct perishable = (PerishableProduct) product.getProduct();

        assertFalse(perishable.isExpired());

        perishable.setExpirationDate(LocalDate.of(2025,1,1));

        assertTrue(perishable.isExpired());
    }

}
