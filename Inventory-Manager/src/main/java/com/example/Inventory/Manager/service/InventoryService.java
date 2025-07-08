package com.example.Inventory.Manager.service;

import com.example.Inventory.Manager.data.InventoryRepository;
import com.example.Inventory.Manager.model.Product;

import java.util.List;

public class InventoryService {
    private InventoryRepository repository;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    public void addProduct(Product product) {
        repository.addProduct(product);
    }

    public void removeProduct(Product product) {
        repository.removeProduct(product);
    }

    public Product findProductById(String id) {
        return repository.findProductById(id);
    }

    public Product findProductByName(String name) {
        return repository.findProductByName(name);
    }

    public List<Product> getAllInventory() {
        return repository.getAllInventory();
    }

    public void loadInventory(String fileName) {
        repository.loadProduct(fileName);
    }

    public void saveInventory(String fileName) {
        repository.saveProducts(fileName);
    }

}
