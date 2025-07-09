package com.example.Inventory.Manager.data;

import com.example.Inventory.Manager.model.InventoryItem;
import com.example.Inventory.Manager.model.ProductType;

import java.util.List;

public interface InventoryRepository {
    void addProduct(InventoryItem product);
    void removeProduct(InventoryItem product);
    InventoryItem findProductById(String id);
    InventoryItem findProductByName(String name);
    List<InventoryItem> loadProduct(String fileName);
    boolean saveProducts(String fileName);
    List<InventoryItem> getAllInventory();
}
