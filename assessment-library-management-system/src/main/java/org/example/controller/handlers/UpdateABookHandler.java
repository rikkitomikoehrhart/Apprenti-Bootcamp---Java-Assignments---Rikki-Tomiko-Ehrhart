package org.example.controller.handlers;

import org.example.model.inventory.BookItem;
import org.example.service.domain.ItemService;
import org.example.service.ui.View;

public class UpdateABookHandler implements HandlerInterface {
    private final View view;
    private final ItemService service;

    public UpdateABookHandler(View view, ItemService service) {
        this.view = view;
        this.service = service;
    }


    @Override
    public void execute() {
        String isbn = view.getUserChosenISBN();

        BookItem book = (BookItem) service.findByISBN(isbn);

        if (book == null) {
            view.displayISBNError();
        } else {
            book = view.updateBook(book);

            service.update(book);
        }
    }
}
