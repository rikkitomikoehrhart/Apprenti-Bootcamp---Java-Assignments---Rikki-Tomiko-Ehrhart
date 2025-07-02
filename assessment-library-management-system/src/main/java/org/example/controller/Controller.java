package org.example.controller;


import org.example.controller.handlers.*;
import org.example.model.data.DataAccessException;
import org.example.service.MenuOption;
import org.example.service.domain.ItemService;
import org.example.service.ui.View;

import java.util.List;

public class Controller {
    private final View view;
    private final ItemService service;
    private final DisplayAllBookHandler displayAllBookHandler;
    private final FindBooksByCategory findBooksByCategory;
    private final AddABookHandler addABookHandler;
    private final UpdateABookHandler updateABookHandler;
    private final RemoveABookHandler removeABookHandler;

    public Controller(View view, ItemService service) {
        this.view = view;
        this.service = service;

        this.displayAllBookHandler = new DisplayAllBookHandler(view, service);
        this.findBooksByCategory = new FindBooksByCategory(view, service);
        this.addABookHandler = new AddABookHandler(view, service);
        this.updateABookHandler = new UpdateABookHandler(view, service);
        this.removeABookHandler = new RemoveABookHandler(view, service);
    }

    public void run() {
        view.displayHeader("Welcome to The Library Management Application");

        try {
            runApp();
        } catch (DataAccessException ex) {
            view.displayErrors(List.of(ex.getMessage()));
        }
    }

    private void runApp() throws DataAccessException {
        while (true) {
            MenuOption option = view.chooseMainMenuOption();

            switch (option) {
                case DISPLAY_ALL_BOOKS:
                    displayAllBookHandler.execute();
                    break;
                case FIND_BOOKS_BY_CATEGORY:
                    findBooksByCategory.execute();
                    break;
                case ADD_A_BOOK:
                    addABookHandler.execute();
                    break;
                case UPDATE_A_BOOK:
                    updateABookHandler.execute();
                    break;
                case REMOVE_A_BOOK:
                    removeABookHandler.execute();
                    break;
                case EXIT:
                    System.exit(0);
                    break;
            }
        }
    }
}
