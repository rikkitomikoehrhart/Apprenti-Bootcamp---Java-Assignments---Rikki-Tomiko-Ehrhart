package com.example.Inventory.Manager.repository;

import com.example.Inventory.Manager.model.InventoryItem;
import com.example.Inventory.Manager.model.PerishableProduct;
import com.example.Inventory.Manager.model.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InventorySampleDataRepository implements InventoryRepository {
    private List<InventoryItem> inventory;
    private String fileName;    // The other Repo needs a fileName. This data is hardcoded, so this is a dummy value;

    public InventorySampleDataRepository(String fileName) {
        this.inventory = loadProduct(fileName);
        this.fileName = fileName;
    }

    @Override
    public void addProduct(InventoryItem product) {
        inventory.add(product);
    }

    @Override
    public void removeProduct(InventoryItem product) {
        inventory.remove(product);
    }

    @Override
    public List<InventoryItem> findProductById(String id) {
        List<InventoryItem> found = new ArrayList<>();

        for (InventoryItem product : inventory) {
            if (product.getProduct().getProductID().equals(id)) {
                found.add(product);
            }
        }
        return found;
    }

    @Override
    public List<InventoryItem> findProductByName(String name) {
        List<InventoryItem> found = new ArrayList<>();

        for (InventoryItem product : inventory) {
            if (product.getProduct().getProductName().equals(name)) {
                found.add(product);
            }
        }
        return found;
    }

    @Override
    public List<InventoryItem> loadProduct(String fileName) {
        List<InventoryItem> products = new ArrayList<>();

        products.add(new InventoryItem(new PerishableProduct(new Product("APPLE", "Apple"), LocalDate.of(2025, 7, 26)), 100, BigDecimal.valueOf(2.99)));
        products.add(new InventoryItem(new PerishableProduct(new Product("BANANA", "Banana"), LocalDate.of(2025, 7, 13)), 0, BigDecimal.valueOf(1.49)));
        products.add(new InventoryItem(new PerishableProduct(new Product("CARROT", "Carrots"), LocalDate.of(2025, 7, 21)), 250, BigDecimal.valueOf(3.56)));

        return products;
    }

    @Override
    public boolean saveProducts() {
        return true;
    }

    @Override
    public List<InventoryItem> getAllInventory() {
        return inventory;
    }

    @Override
    public void update(InventoryItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }

        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getProduct().getProductID().equals(item.getProduct().getProductID())) {
                inventory.set(i, item);
            }
        }
    }

    @Override
    public List<InventoryItem> getInStock() {
        return inventory.stream().filter(item -> item.getQuantity() > 0).collect(Collectors.toList());
    }
}
