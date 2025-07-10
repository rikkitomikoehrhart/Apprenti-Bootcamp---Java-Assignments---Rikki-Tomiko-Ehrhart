package com.example.Inventory.Manager.ui.inventory_handlers;

import com.example.Inventory.Manager.service.InventoryService;
import com.example.Inventory.Manager.ui.AppHandler;
import com.example.Inventory.Manager.ui.View;

public class ViewProductsHandler implements AppHandler {
    View view;
    InventoryService service;


    public ViewProductsHandler(View view, InventoryService service) {
        this.view = view;
        this.service = service;
    }


    @Override
    public void execute() {
        view.displayViewProductsTitle();

        view.viewProductsReport(service.getAllInventory());

    }

}
