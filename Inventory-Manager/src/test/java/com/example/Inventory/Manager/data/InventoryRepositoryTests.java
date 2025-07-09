package com.example.Inventory.Manager.data;

import com.example.Inventory.Manager.model.PerishableProduct;
import com.example.Inventory.Manager.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryRepositoryTests {
    InventoryFromFileRepository fromFileRepository;
    InventorySampleDataRepository sampleDataRepository;

    @BeforeEach
    void setUp() {
        fromFileRepository = new InventoryFromFileRepository("data.csv");
        sampleDataRepository = new InventorySampleDataRepository("doesn't matter");
    }

    @AfterEach
    void cleanUp() {
        new File("data.csv").delete();
    }


    @Test
    @DisplayName("Sample Data Repo has Sample Data")
    void sampleDataRepoHasSampleData(){
        List<Product> inventory = sampleDataRepository.getAllInventory();

        assertFalse(inventory.isEmpty());
    }

    @Test
    @DisplayName("Both repos can add products")
    void bothReposCanAddProducts() {
        PerishableProduct donut = new PerishableProduct("DONUT", "Donut", 10, BigDecimal.TWO, LocalDate.of(2025, 7, 8));

        sampleDataRepository.addProduct(donut);
        fromFileRepository.addProduct(donut);

        List<Product> sampleInventory = sampleDataRepository.getAllInventory();
        List<Product> fileInventory = fromFileRepository.getAllInventory();

        assertEquals(4, sampleInventory.size());
        assertEquals(1, fileInventory.size());
    }

    @Test
    @DisplayName("Both repos can remove products")
    void bothReposCanARemoveProducts() {
        PerishableProduct donut = new PerishableProduct("DONUT", "Donut", 10, BigDecimal.TWO, LocalDate.of(2025, 7, 8));

        sampleDataRepository.addProduct(donut);
        fromFileRepository.addProduct(donut);

        List<Product> sampleInventory = sampleDataRepository.getAllInventory();
        List<Product> fileInventory = fromFileRepository.getAllInventory();

        assertEquals(4, sampleInventory.size());
        assertEquals(1, fileInventory.size());

        sampleDataRepository.removeProduct(donut);
        fromFileRepository.removeProduct(donut);

        assertEquals(3, sampleInventory.size());
        assertTrue(fileInventory.isEmpty());
    }

    @Test
    @DisplayName("Both repos can find product by id")
    void bothReposCanAFindById() {
        PerishableProduct donut = new PerishableProduct("DONUT", "Donut", 10, BigDecimal.TWO, LocalDate.of(2025, 7, 8));

        sampleDataRepository.addProduct(donut);
        fromFileRepository.addProduct(donut);

        List<Product> sampleInventory = sampleDataRepository.getAllInventory();
        List<Product> fileInventory = fromFileRepository.getAllInventory();

        assertEquals(donut, sampleDataRepository.findProductById("DONUT"));
        assertEquals(donut, fromFileRepository.findProductById("DONUT"));
    }

    @Test
    @DisplayName("Both repos will return null if not found product by id")
    void bothReposWillReturnNullIfNotFoundById() {
        List<Product> sampleInventory = sampleDataRepository.getAllInventory();
        List<Product> fileInventory = fromFileRepository.getAllInventory();

        assertNull(sampleDataRepository.findProductById("Should be null"));
        assertNull(fromFileRepository.findProductById("Should be null"));
    }

    @Test
    @DisplayName("Both repos can find product by name")
    void bothReposCanAFindByName() {
        PerishableProduct donut = new PerishableProduct("DONUT", "Donut", 10, BigDecimal.TWO, LocalDate.of(2025, 7, 8));

        sampleDataRepository.addProduct(donut);
        fromFileRepository.addProduct(donut);

        List<Product> sampleInventory = sampleDataRepository.getAllInventory();
        List<Product> fileInventory = fromFileRepository.getAllInventory();

        assertEquals(donut, sampleDataRepository.findProductByName("Donut"));
        assertEquals(donut, fromFileRepository.findProductByName("Donut"));
    }

    @Test
    @DisplayName("Both repos will return null if not found product by name")
    void bothReposWillReturnNullIfNotFoundByName() {
        List<Product> sampleInventory = sampleDataRepository.getAllInventory();
        List<Product> fileInventory = fromFileRepository.getAllInventory();

        assertNull(sampleDataRepository.findProductByName("Should be null"));
        assertNull(fromFileRepository.findProductByName("Should be null"));
    }



}
