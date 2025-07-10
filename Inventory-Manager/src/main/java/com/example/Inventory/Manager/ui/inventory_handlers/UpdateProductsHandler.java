package com.example.Inventory.Manager.ui.inventory_handlers;

import com.example.Inventory.Manager.model.InventoryItem;
import com.example.Inventory.Manager.service.InventoryService;
import com.example.Inventory.Manager.ui.AppHandler;
import com.example.Inventory.Manager.ui.Inventory;
import com.example.Inventory.Manager.ui.View;

import java.util.ArrayList;
import java.util.List;

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

        List<InventoryItem> inventoryItems = new ArrayList<>();

        inventoryItems.addAll(service.findProductById(itemIdOrName));
        inventoryItems.addAll(service.findProductByName(itemIdOrName));

        InventoryItem itemToUpdate = view.getItemForUser(inventoryItems);

        itemToUpdate = view.updateProductFromUser(itemToUpdate);


        service.updateItem(itemToUpdate);
    }

}
