package com.example.Inventory.Manager.service;

import com.example.Inventory.Manager.model.CartItem;
import com.example.Inventory.Manager.model.PerishableProduct;
import com.example.Inventory.Manager.repository.InventoryRepository;
import com.example.Inventory.Manager.model.InventoryItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    private InventoryRepository repository;
    private ProductService productService;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
        this.productService = new ProductService();
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
        List<InventoryItem> available = inventory.stream()
                .filter(item -> item.getQuantity() > 0)
                .filter(item -> {
                    if (item.getProduct() instanceof PerishableProduct) {
                        PerishableProduct perishable = (PerishableProduct) item.getProduct();
                        return !productService.isExpired(perishable.getExpirationDate());
                    }
                    return true;
                })
                .toList();

        return available;
    }

    public void loadInventory(String fileName) {
        repository.loadProduct(fileName);
    }

    public void saveInventory() {
        repository.saveProducts();
    }

    public void updateItem(InventoryItem item) {
        repository.update(item);
    }

    public InventoryItem getItemFromInventory(CartItem item) {
        List<InventoryItem> inventory = getAllInventory();
        for (InventoryItem inventoryItem : inventory) {
            if (inventoryItem.getProduct().getProductID().equals(item.getItem().getProduct().getProductID()) && inventoryItem.getProduct().getProductName().equals(item.getItem().getProduct().getProductName())) {
                return inventoryItem;
            }
        }
        return null;
    }

    public int adjustQuantity(InventoryItem item, int quantity) {
        return quantity > item.getQuantity() ? item.getQuantity() : quantity;
    }
}
