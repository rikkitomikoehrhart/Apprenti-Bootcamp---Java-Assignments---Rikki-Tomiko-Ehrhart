package com.example.Inventory.Manager.data;

import com.example.Inventory.Manager.model.PerishableProduct;
import com.example.Inventory.Manager.model.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InventorySampleDataRepository implements InventoryRepository {
    private List<Product> inventory;
    private String fileName;    // The other Repo needs a fileName. This data is hardcoded, so this is a dummy value;

    public InventorySampleDataRepository(String fileName) {
        this.inventory = loadProduct(fileName);
        this.fileName = fileName;
    }

    @Override
    public void addProduct(Product product) {
        inventory.add(product);
    }

    @Override
    public void removeProduct(Product product) {
        inventory.remove(product);
    }

    @Override
    public Product findProductById(String id) {
        for (Product product : inventory) {
            if (product.getProductID().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product findProductByName(String name) {
        for (Product product : inventory) {
            if (product.getProductName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> loadProduct(String fileName) {
        List<Product> products = new ArrayList<>();

        products.add(new PerishableProduct("APPLE", "Apple", 100, BigDecimal.valueOf(2.99), LocalDate.of(2025, 7, 26)));
        products.add(new PerishableProduct("BANANA", "Banana", 25, BigDecimal.valueOf(1.49), LocalDate.of(2025, 7, 13)));
        products.add(new PerishableProduct("CARROT", "Carrots", 250, BigDecimal.valueOf(3.56), LocalDate.of(2025, 7, 21)));

        return products;
    }

    @Override
    public boolean saveProducts(String fileName) {
        return true;
    }

    @Override
    public List<Product> getAllInventory() {
        return inventory;
    }
}
