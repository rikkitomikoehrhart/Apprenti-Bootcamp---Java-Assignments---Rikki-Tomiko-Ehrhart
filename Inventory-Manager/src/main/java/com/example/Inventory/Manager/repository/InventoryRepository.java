package com.example.Inventory.Manager.repository;

import com.example.Inventory.Manager.model.InventoryItem;

import java.util.List;

public interface InventoryRepository {
    void addProduct(InventoryItem product);
    void removeProduct(InventoryItem product);
    List<InventoryItem> findProductById(String id);
    List<InventoryItem> findProductByName(String name);
    List<InventoryItem> loadProduct(String fileName);
    boolean saveProducts();
    List<InventoryItem> getAllInventory();

    void update(InventoryItem item);
    List<InventoryItem> getInStock();

}
