package org.example.controller.handlers;

import org.example.service.domain.ItemService;
import org.example.service.ui.View;

public class DisplayAllBookHandler implements HandlerInterface {
    private View view;
    private ItemService service;


    public DisplayAllBookHandler(View view, ItemService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public void execute() {
        view.displayInventory(service.findAll());
    }
}
