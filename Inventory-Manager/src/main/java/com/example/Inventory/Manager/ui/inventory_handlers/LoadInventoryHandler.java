package com.example.Inventory.Manager.ui.inventory_handlers;

import com.example.Inventory.Manager.service.InventoryService;
import com.example.Inventory.Manager.ui.AppHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class LoadInventoryHandler implements AppHandler {
    InventoryService service;
    private final String fileName;

    @Autowired
    public LoadInventoryHandler(InventoryService service, String fileName) {
        this.service = service;
        this.fileName = fileName;
    }

    @Override
    public void execute() {
        service.loadInventory(fileName);
    }
}
