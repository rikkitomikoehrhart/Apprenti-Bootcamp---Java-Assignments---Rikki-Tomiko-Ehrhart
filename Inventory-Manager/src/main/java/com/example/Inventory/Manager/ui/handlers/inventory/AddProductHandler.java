package com.example.Inventory.Manager.ui.handlers.inventory;

import com.example.Inventory.Manager.model.InventoryItem;
import com.example.Inventory.Manager.service.InventoryService;
import com.example.Inventory.Manager.ui.handlers.AppHandler;
import com.example.Inventory.Manager.ui.View;

public class AddProductHandler implements AppHandler {
    View view;
    InventoryService service;

    public AddProductHandler(View view, InventoryService service) {
        this.view = view;
        this.service = service;
    }


    @Override
    public void execute() {
        view.displayAddProductTitle();

        InventoryItem newItem = view.createNewProductFromUser();

        service.addProduct(newItem);
    }
}
