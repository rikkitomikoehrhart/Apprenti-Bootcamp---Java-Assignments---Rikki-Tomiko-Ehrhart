package com.example.Inventory.Manager.service;

import com.example.Inventory.Manager.model.InventoryItem;
import com.example.Inventory.Manager.model.PerishableProduct;
import com.example.Inventory.Manager.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTests {
    private ProductService productService;
    private InventoryItem product;

    @BeforeEach
    void setUp() {
        productService = new ProductService();
        product = new InventoryItem(new PerishableProduct(new Product("ID", "Name"), LocalDate.of(2025, 7, 26)), 100, BigDecimal.valueOf(100.00));
    }

    @Test
    @DisplayName("Check if Add and Remove Quantities Work")
    public void checkAddAndRemoveQuantities() {
        productService.addStock(product, 10);

        assertEquals(110, product.getQuantity());

        productService.removeStock(product, 10);

        assertEquals(100, product.getQuantity());
    }

    @Test
    @DisplayName("Check if the quantity remove is greater thant the current quantity that it sets to zero")
    public void checkIfRemoveQuantitySetToZero() {
        productService.removeStock(product, 2000);

        assertEquals(0, product.getQuantity());
    }

    @Test
    @DisplayName("Check if increase and decrease price works")
    public void checkIfIncreaseAndDecreasePriceWork() {
        productService.increasePrice(product, BigDecimal.valueOf(200.00));

        assertEquals(BigDecimal.valueOf(300.00), product.getPrice());

        productService.decreasePrice(product, BigDecimal.valueOf(200.00));

        assertEquals(BigDecimal.valueOf(100.00), product.getPrice());
    }

    @Test
    @DisplayName("Check if decrease price is higher than the current price set to zero")
    public void checkIfDecreasePriceSetsToZero() {
        productService.decreasePrice(product, BigDecimal.valueOf(1000.00));

        assertEquals(BigDecimal.ZERO, product.getPrice());
    }


    @Test
    @DisplayName("Check if Days Until ExpirationDate is returned")
    public void checkDaysUntilExpiration() {
        PerishableProduct perishable = (PerishableProduct) product.getProduct();
        assertEquals(17, productService.daysUntilExpirationDate(perishable));
    }




}
