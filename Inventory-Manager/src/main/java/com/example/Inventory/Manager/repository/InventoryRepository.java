package com.example.Inventory.Manager.repository;

import com.example.Inventory.Manager.model.InventoryItem;
import com.example.Inventory.Manager.model.ProductType;

import java.util.List;

public interface InventoryRepository {
    void addProduct(InventoryItem product);
    void removeProduct(InventoryItem product);
    List<InventoryItem> findProductById(String id);
    List<InventoryItem> findProductByName(String name);
    List<InventoryItem> loadProduct(String fileName);
    boolean saveProducts(String fileName);
    List<InventoryItem> getAllInventory();

    void update(InventoryItem item);
    List<InventoryItem> getInStock();

}
