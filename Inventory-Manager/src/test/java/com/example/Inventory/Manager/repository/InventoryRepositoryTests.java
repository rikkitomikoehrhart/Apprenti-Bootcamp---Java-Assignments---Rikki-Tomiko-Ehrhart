package com.example.Inventory.Manager.repository;

import com.example.Inventory.Manager.model.InventoryItem;
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
    InventoryItem donut;

    @BeforeEach
    void setUp() {
        fromFileRepository = new InventoryFromFileRepository("test_data.csv");
        sampleDataRepository = new InventorySampleDataRepository("doesn't matter");
        donut = new InventoryItem(new PerishableProduct(new Product("DONUT", "Donut"), LocalDate.of(2025, 7, 8)), 10, BigDecimal.TWO);

    }

    @AfterEach
    void cleanUp() {
        new File("test_data.csv").delete();
    }


    @Test
    @DisplayName("Sample Data Repo has Sample Data")
    void sampleDataRepoHasSampleData(){
        List<InventoryItem> inventory = sampleDataRepository.getAllInventory();

        assertFalse(inventory.isEmpty());
    }

    @Test
    @DisplayName("CSV Repo can add products")
    void csvRepoCanAddProducts() {
        fromFileRepository.addProduct(donut);
        List<InventoryItem> fileInventory = fromFileRepository.getAllInventory();

        assertEquals(1, fileInventory.size());
    }

    @Test
    @DisplayName("Sample Repo can add products")
    void sampleReposCanAddProducts() {
        sampleDataRepository.addProduct(donut);
        List<InventoryItem> sampleInventory = sampleDataRepository.getAllInventory();

        assertEquals(4, sampleInventory.size());
    }

    @Test
    @DisplayName("CSV Repo can remove products")
    void csvRepoCanRemoveProducts() {
        fromFileRepository.addProduct(donut);
        List<InventoryItem> fileInventory = fromFileRepository.getAllInventory();

        assertEquals(1, fileInventory.size());

        fromFileRepository.removeProduct(donut);
        assertTrue(fileInventory.isEmpty());
    }

    @Test
    @DisplayName("Sample Repo can remove products")
    void SampleRepoCanARemoveProducts() {
        sampleDataRepository.addProduct(donut);
        List<InventoryItem> sampleInventory = sampleDataRepository.getAllInventory();

        assertEquals(4, sampleInventory.size());

        sampleDataRepository.removeProduct(donut);
        assertEquals(3, sampleInventory.size());
    }

    @Test
    @DisplayName("CSV Repo can find product by id")
    void csvRepoCanFindById() {
        fromFileRepository.addProduct(donut);
        assertEquals(donut, fromFileRepository.findProductById("DONUT").get(0));
    }


    @Test
    @DisplayName("Sample Repo can find product by id")
    void SampleRepoCanFindById() {
        sampleDataRepository.addProduct(donut);
        assertEquals(donut, sampleDataRepository.findProductById("DONUT").get(0));
    }


    @Test
    @DisplayName("CSV Repo will return an empty list if product not found by id")
    void csvRepoWillReturnEmptyListIfNotFoundById() {
        assertTrue(fromFileRepository.findProductById("Should be nothing").isEmpty());
    }


    @Test
    @DisplayName("Sample Repo will return an empty list if product not found by id")
    void sampleRepoWillReturnEmptyListIfNotFoundById() {
        assertTrue(sampleDataRepository.findProductById("Should be nothing").isEmpty());
    }


    @Test
    @DisplayName("CSV Repo can find product by name")
    void csvRepoCanFindByName() {
        fromFileRepository.addProduct(donut);
        assertEquals(donut, fromFileRepository.findProductByName("Donut").get(0));
    }


    @Test
    @DisplayName("Sample Repo can find product by name")
    void sampleRepoCanFindByName() {
        sampleDataRepository.addProduct(donut);
        assertEquals(donut, sampleDataRepository.findProductByName("Donut").get(0));
    }


    @Test
    @DisplayName("CSV Repo will return empty list if product not found by name")
    void csvRepoWillReturnEmptyListIfNotFoundByName() {
        assertTrue(fromFileRepository.findProductByName("Should be empty").isEmpty());
    }


    @Test
    @DisplayName("Sample Repo will return empty list if product not found by name")
    void sampleRepoWillReturnEmptyListIfNotFoundByName() {
        assertTrue(sampleDataRepository.findProductByName("Should be null").isEmpty());
    }


    @Test
    @DisplayName("CSV Repo can update items")
    void csvRepoUpdatedItems() {
        List<InventoryItem> fileInventory = fromFileRepository.getAllInventory();
        fileInventory.add(donut);

        assertEquals(1, fileInventory.size());

        InventoryItem updatedDonut = new InventoryItem(new PerishableProduct(new Product("DONUT", "Donut"), LocalDate.of(2025, 7, 8)), 10, BigDecimal.TWO);

        fromFileRepository.update(updatedDonut);

        assertEquals(10, fileInventory.get(0).getQuantity());
    }



    @Test
    @DisplayName("Sample Repos can update items")
    void sampleRepoUpdatedItems() {
        List<InventoryItem> sampleInventory = sampleDataRepository.getAllInventory();
        sampleInventory.add(donut);

        assertEquals(4, sampleInventory.size());

        InventoryItem updatedDonut = new InventoryItem(new PerishableProduct(new Product("DONUT", "Donut"), LocalDate.of(2025, 7, 8)), 10, BigDecimal.TWO);

        sampleDataRepository.update(updatedDonut);

        assertEquals(10, sampleInventory.get(3).getQuantity());
    }


    @Test
    @DisplayName("CSV Repo can return a list of just the items in stock")
    void csvItemsInStock() {
        InventoryItem eclair = new InventoryItem(new PerishableProduct(new Product("ECLAIR", "Eclair"), LocalDate.of(2025, 12, 1)), 0, BigDecimal.TWO);
        List<InventoryItem> fileInventory = fromFileRepository.getAllInventory();

        fileInventory.add(donut);
        fileInventory.add(eclair);

        assertEquals(2, fileInventory.size());

        List<InventoryItem> fileInStock = fromFileRepository.getInStock();

        assertEquals(1, fileInStock.size());
    }

    @Test
    @DisplayName("Sample Repo can return a list of just the items in stock")
    void SampleRepoInStock() {
        InventoryItem eclair = new InventoryItem(new PerishableProduct(new Product("ECLAIR", "Eclair"), LocalDate.of(2025, 12, 1)), 0, BigDecimal.TWO);
        List<InventoryItem> sampleInventory = sampleDataRepository.getAllInventory();

        sampleInventory.add(donut);
        sampleInventory.add(eclair);

        assertEquals(5, sampleInventory.size());

        List<InventoryItem> sampleInStock = sampleDataRepository.getInStock();

        assertEquals(3, sampleInStock.size());
    }

}
