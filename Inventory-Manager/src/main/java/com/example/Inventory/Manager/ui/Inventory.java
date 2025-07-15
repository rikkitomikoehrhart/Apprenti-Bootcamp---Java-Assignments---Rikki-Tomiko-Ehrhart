package com.example.Inventory.Manager.ui;

import com.example.Inventory.Manager.config.InventoryConfig;
import com.example.Inventory.Manager.model.MenuOption;
import com.example.Inventory.Manager.service.InventoryService;
import com.example.Inventory.Manager.ui.handlers.inventory.*;
import org.springframework.stereotype.Component;

@Component
public class Inventory {
    private final InventoryService service;
    private final View view;
    private final String fileName;

    public Inventory(InventoryService service, View view, InventoryConfig config) {
        this.service = service;
        this.view = view;
        this.fileName = config.getFileName();
    }

    public void run() {
        AddProductHandler addProduct = new AddProductHandler(view, service);
        ViewProductsHandler viewProducts = new ViewProductsHandler(view, service);
        SearchProductsHandler searchProducts = new SearchProductsHandler(view, service);
        UpdateProductsHandler updateProduct = new UpdateProductsHandler(view, service);
        DeleteProductsHandler deleteProduct = new DeleteProductsHandler(view, service);
        LoadInventoryHandler loadInventory = new LoadInventoryHandler(service, fileName);


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
                    deleteProduct.execute();
                    break;
                case LOAD_INVENTORY:
                    loadInventory.execute();
                    break;
                case EXIT:
                    System.exit(0);
            }

        }


    }
}
