package org.example.controller.handlers;

import org.example.model.inventory.Category;
import org.example.model.inventory.InventoryItem;
import org.example.service.domain.ItemService;
import org.example.service.ui.View;

import java.util.List;

public class FindBooksByCategory implements HandlerInterface {
    private final View view;
    private final ItemService service;

    public FindBooksByCategory(View view, ItemService service) {
        this.view = view;
        this.service = service;
    }


    @Override
    public void execute() {
        view.displayCategories();

        Category category = view.getCategoryFromUser();

        List<InventoryItem> itemsFromCategory = service.findAllByCategory(category);

        view.displayInventory(itemsFromCategory);
    }
}
