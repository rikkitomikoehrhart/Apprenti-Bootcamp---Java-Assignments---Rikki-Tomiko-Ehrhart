package org.example.controller.handlers;

import org.example.model.inventory.BookItem;
import org.example.service.domain.ItemResult;
import org.example.service.domain.ItemService;
import org.example.service.ui.View;

public class AddABookHandler implements HandlerInterface {
    private final View view;
    private final ItemService service;

    public AddABookHandler(View view, ItemService service) {
        this.view = view;
        this.service = service;
    }


    @Override
    public void execute() {
        BookItem book = (BookItem) view.createItem();

        ItemResult result = service.okToAdd(book);

        if (result.isSuccess()) {
            book = (BookItem) service.addItemToLibrary(book);
        } else {
            view.displayErrors(result.getErrorMessages());
        }

    }
}
