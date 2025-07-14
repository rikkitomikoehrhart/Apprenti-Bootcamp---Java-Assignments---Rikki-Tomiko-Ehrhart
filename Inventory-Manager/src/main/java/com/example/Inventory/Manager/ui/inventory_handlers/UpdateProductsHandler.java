package com.example.Inventory.Manager.ui.inventory_handlers;

import com.example.Inventory.Manager.model.InventoryItem;
import com.example.Inventory.Manager.service.InventoryService;
import com.example.Inventory.Manager.ui.AppHandler;
import com.example.Inventory.Manager.ui.View;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UpdateProductsHandler implements AppHandler {
    View view;
    InventoryService service;

    public UpdateProductsHandler(View view, InventoryService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public void execute() {
        view.displayUpdateProductTitle();

        String itemIdOrName = view.searchBar();

        Set<InventoryItem> inventoryItems = new HashSet<>();

        inventoryItems.addAll(service.findProductById(itemIdOrName));
        inventoryItems.addAll(service.findProductByName(itemIdOrName));

        InventoryItem itemToUpdate = view.getItemForUser(new ArrayList<>(inventoryItems));

        itemToUpdate = view.updateProductFromUser(itemToUpdate);


        service.updateItem(itemToUpdate);
    }

}
