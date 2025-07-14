package com.example.Inventory.Manager.service;

import com.example.Inventory.Manager.model.CartItem;
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

    public List<InventoryItem> getAllAvailableInventory() {
        List<InventoryItem> inventory = getAllInventory();
        List<InventoryItem> available = inventory.stream().filter(item -> item.getQuantity() > 0).toList();

        return available;
    }

    public void loadInventory(String fileName) {
        repository.loadProduct(fileName);
    }

    public void saveInventory(String fileName) {
        repository.saveProducts(fileName);
    }

    public void updateItem(InventoryItem item) {
        repository.update(item);
    }

    public InventoryItem getItemFromInventory(CartItem item) {
        List<InventoryItem> inventory = getAllInventory();
        for (InventoryItem inventoryItem : inventory) {
            if (inventoryItem.getProduct().getProductID() == item.getItem().getProduct().getProductID() && inventoryItem.getProduct().getProductName() == item.getItem().getProduct().getProductName()) {
                return inventoryItem;
            }
        }
        return null;
    }
}
