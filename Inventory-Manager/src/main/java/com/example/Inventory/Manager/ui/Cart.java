package com.example.Inventory.Manager.ui;

import com.example.Inventory.Manager.config.InventoryConfig;
import com.example.Inventory.Manager.model.CartOption;
import com.example.Inventory.Manager.service.CartService;
import com.example.Inventory.Manager.service.InventoryService;
import org.springframework.stereotype.Component;

@Component
public class Cart {
    private final InventoryService service;
    private final CartService shoppingCart;
    private final View view;
    private final String fileName;

    public Cart(InventoryService service, CartService shoppingCart, View view, InventoryConfig config) {
        this.service = service;
        this.shoppingCart = shoppingCart;
        this.view = view;
        this.fileName = config.getFileName();
    }

    public void run() {

        while (true) {
            view.displayCartMenu();

            CartOption choice = view.getCartChoiceFromUser();

            switch (choice) {
                case ADD_PRODUCT:
                case VIEW_PRODUCTS:
                case SEARCH_PRODUCTS:
                case UPDATE_CART:
                case VIEW_CART:
                case CHECKOUT:
                case EXIT:
                    System.exit(0);
            }
        }
    }
}
