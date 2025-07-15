package com.example.Inventory.Manager.ui.handlers.inventory;

import com.example.Inventory.Manager.model.InventoryItem;
import com.example.Inventory.Manager.service.InventoryService;
import com.example.Inventory.Manager.ui.handlers.AppHandler;
import com.example.Inventory.Manager.ui.View;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DeleteProductsHandler implements AppHandler {
    View view;
    InventoryService service;

    public DeleteProductsHandler(View view, InventoryService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public void execute() {
        view.displayDeleteProductTitle();

        String itemIdOrName = view.searchBar();

        Set<InventoryItem> inventoryItems = new HashSet<>();

        inventoryItems.addAll(service.findProductById(itemIdOrName));
        inventoryItems.addAll(service.findProductByName(itemIdOrName));

        InventoryItem itemToDelete = view.getItemForUser(new ArrayList<>(inventoryItems));

        service.removeProduct(itemToDelete);
    }
}
