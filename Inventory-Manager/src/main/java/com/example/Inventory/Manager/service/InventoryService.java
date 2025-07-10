package com.example.Inventory.Manager.service;

import com.example.Inventory.Manager.repository.InventoryRepository;
import com.example.Inventory.Manager.model.InventoryItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    private InventoryRepository repository;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    public void addProduct(InventoryItem product) {
        repository.addProduct(product);
    }

    public void removeProduct(InventoryItem product) {
        repository.removeProduct(product);
    }

    public List<InventoryItem> findProductById(String id) {
        return repository.findProductById(id);
    }

    public List<InventoryItem> findProductByName(String name) {
        return repository.findProductByName(name);
    }

    public List<InventoryItem> getAllInventory() {
        return repository.getAllInventory();
    }

    public void loadInventory(String fileName) {
        repository.loadProduct(fileName);
    }

    public void saveInventory(String fileName) {
        repository.saveProducts(fileName);
    }

}
