package com.example.Inventory.Manager.ui.handlers.inventory;

import com.example.Inventory.Manager.model.InventoryItem;
import com.example.Inventory.Manager.service.InventoryService;
import com.example.Inventory.Manager.ui.handlers.AppHandler;
import com.example.Inventory.Manager.ui.View;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SearchProductsHandler implements AppHandler {
    View view;
    InventoryService service;

    public SearchProductsHandler(View view, InventoryService service) {
        this.view = view;
        this.service = service;
    }


    @Override
    public void execute() {
        view.displaySearchProductsTitle();

        String searchCriteria = view.searchBar();

        Set<InventoryItem> searchResults = new HashSet<>();

        searchResults.addAll(service.findProductById(searchCriteria));
        searchResults.addAll(service.findProductByName(searchCriteria));

        view.viewProductsReport(new ArrayList<>(searchResults));
    }
}
