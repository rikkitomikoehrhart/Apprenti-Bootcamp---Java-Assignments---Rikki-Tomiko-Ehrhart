package com.example.Inventory.Manager.ui.handlers.cart;

import com.example.Inventory.Manager.service.InventoryService;
import com.example.Inventory.Manager.ui.handlers.AppHandler;
import com.example.Inventory.Manager.ui.View;

public class ViewAvailableProductsHandler implements AppHandler {
    View view;
    InventoryService service;


    public ViewAvailableProductsHandler(View view, InventoryService service) {
        this.view = view;
        this.service = service;
    }


    @Override
    public void execute() {
        view.displayViewProductsTitle();

        view.viewProductsReport(service.getAllAvailableInventory());

    }
}
