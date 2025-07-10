package com.example.Inventory.Manager.ui;

import com.example.Inventory.Manager.model.MenuOption;
import com.example.Inventory.Manager.service.InventoryService;
import com.example.Inventory.Manager.ui.inventory_handlers.AddProductHandler;
import com.example.Inventory.Manager.ui.inventory_handlers.SearchProductsHandler;
import com.example.Inventory.Manager.ui.inventory_handlers.UpdateProductsHandler;
import com.example.Inventory.Manager.ui.inventory_handlers.ViewProductsHandler;
import org.springframework.stereotype.Component;

@Component
public class Inventory {
    private final InventoryService service;
    private final View view;

    public Inventory(InventoryService service, View view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        AddProductHandler addProduct = new AddProductHandler(view, service);
        ViewProductsHandler viewProducts = new ViewProductsHandler(view, service);
        SearchProductsHandler searchProducts = new SearchProductsHandler(view, service);
        UpdateProductsHandler updateProduct = new UpdateProductsHandler(view, service);


        while (true) {
            view.displayMainMenu();

            MenuOption choice = view.getMenuChoiceFromUser();

            switch (choice) {
                case ADD_PRODUCT:
                    addProduct.execute();
                    break;
                case VIEW_PRODUCTS:
                    viewProducts.execute();
                    break;
                case SEARCH_PRODUCTS:
                    searchProducts.execute();
                    break;
                case UPDATE_PRODUCT:
                    updateProduct.execute();
                    break;
                case DELETE_PRODUCT:
                case LOAD_INVENTORY:
                case EXIT:
                    System.exit(0);
            }

        }


    }
}
