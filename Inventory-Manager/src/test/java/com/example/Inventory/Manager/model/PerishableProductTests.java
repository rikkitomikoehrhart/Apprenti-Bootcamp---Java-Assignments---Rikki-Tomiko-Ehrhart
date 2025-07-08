package com.example.Inventory.Manager.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PerishableProductTests {
    PerishableProduct product;

    @BeforeEach
    void setUp() {
        product = new PerishableProduct("ID", "Name", 100, BigDecimal.valueOf(100.00), LocalDate.of(2025, 7,26));

    }

    @Test
    @DisplayName("PerishableProduct -- Check Getters")
    void gettersCheck() {
        assertEquals("ID", product.getProductID());
        assertEquals("Name", product.getProductName());
        assertEquals(100, product.getQuantity());
        assertEquals(BigDecimal.valueOf(100.00), product.getPrice());
        assertEquals(LocalDate.of(2025, 7, 26), product.getExpirationDate());

    }

    @Test
    @DisplayName("PerishableProduct -- Check Setters")
    void settersCheck() {
        product.setProductID("identification");
        product.setProductName("Product");
        product.setQuantity(13);
        product.setPrice(BigDecimal.valueOf(99.99));
        product.setExpirationDate(LocalDate.of(2025, 10, 2));


        assertEquals("identification", product.getProductID());
        assertEquals("Product", product.getProductName());
        assertEquals(13, product.getQuantity());
        assertEquals(BigDecimal.valueOf(99.99), product.getPrice());
        assertEquals(LocalDate.of(2025, 10, 2), product.getExpirationDate());

    }

    @Test
    @DisplayName("Check isExpired True/False")
    void checkIsExpired() {
        assertFalse(product.isExpired());

        product.setExpirationDate(LocalDate.of(2025,1,1));

        assertTrue(product.isExpired());
    }

}
