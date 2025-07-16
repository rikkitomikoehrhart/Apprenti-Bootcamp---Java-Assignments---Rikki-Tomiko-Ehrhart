package com.example.Inventory.Manager.service;

import com.example.Inventory.Manager.model.InventoryItem;
import com.example.Inventory.Manager.model.PerishableProduct;
import com.example.Inventory.Manager.model.Product;
import com.example.Inventory.Manager.repository.InventorySampleDataRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryServiceTests {
    InventorySampleDataRepository sampleDataRepository;
    InventoryService inventoryService;

    @BeforeEach
    void setUp() {
        sampleDataRepository = new InventorySampleDataRepository("doesn't matter");
        inventoryService = new InventoryService(sampleDataRepository);
    }

    @Test
    @DisplayName("Add product will add a product")
    public void addProduct() {
        InventoryItem donut = new InventoryItem(new PerishableProduct(new Product("DONUT", "Donut"), LocalDate.of(2025, 7, 8)), 10, BigDecimal.TWO);

        inventoryService.addProduct(donut);

        List<InventoryItem> inventory = inventoryService.getAllInventory();

        assertEquals(4, inventory.size());
    }

    @Test
    @DisplayName("Remove product will remove a product")
    public void removeProduct() {
        InventoryItem donut = new InventoryItem(new PerishableProduct(new Product("DONUT", "Donut"), LocalDate.of(2025, 7, 8)), 10, BigDecimal.TWO);

        inventoryService.addProduct(donut);

        List<InventoryItem> inventory = inventoryService.getAllInventory();


        assertEquals(4, inventory.size());

        inventoryService.removeProduct(donut);

        assertEquals(3, inventory.size());
    }

    @Test
    @DisplayName("Find Product By ID returns Item")
    public void findByIdReturnsItem() {
        InventoryItem donut = new InventoryItem(new PerishableProduct(new Product("DONUT", "Donut"), LocalDate.of(2025, 7, 8)), 10, BigDecimal.TWO);

        inventoryService.addProduct(donut);

        assertEquals(donut, inventoryService.findProductById("DONUT").get(0));
    }

    @Test
    @DisplayName("Find Product By ID returns empty list")
    public void findByIdReturnsEmptyList() {
        assertTrue(inventoryService.findProductById("This should be empty").isEmpty());
    }

    @Test
    @DisplayName("Find Product By Name returns Item")
    public void findByNameReturnsItem() {
        InventoryItem donut = new InventoryItem(new PerishableProduct(new Product("DONUT", "Donut"), LocalDate.of(2025, 7, 8)), 10, BigDecimal.TWO);

        inventoryService.addProduct(donut);

        assertEquals(donut, inventoryService.findProductByName("Donut").get(0));
    }

    @Test
    @DisplayName("Find Product By Name returns empty list")
    public void findByNameReturnsEmptyList() {
        assertTrue(inventoryService.findProductById("This should be an empty list").isEmpty());
    }

    @Test
    @DisplayName("Get All Inventory Returns Inventory")
    public void getAllInventoryNotNull() {
        List<InventoryItem> inventory = inventoryService.getAllInventory();

        assertNotNull(inventory);
    }

}
