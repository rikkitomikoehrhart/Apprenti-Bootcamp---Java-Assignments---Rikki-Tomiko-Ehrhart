package com.example.Inventory.Manager.ui.cart_handlers;

import com.example.Inventory.Manager.service.InventoryService;
import com.example.Inventory.Manager.ui.AppHandler;
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
