package com.example.Inventory.Manager.data;

import com.example.Inventory.Manager.model.Product;

import java.util.List;

public interface InventoryRepository {
    void addProduct(Product product);
    void removeProduct(Product product);
    Product findProductById(String id);
    Product findProductByName(String name);
    List<Product> loadProduct(String fileName);
    boolean saveProducts(String fileName);
    List<Product> getAllInventory();
}
