package com.example.Inventory.Manager.ui;

import com.example.Inventory.Manager.model.CartOption;
import org.springframework.stereotype.Component;

@Component
public class Cart {

    public void run() {
        View view = new View();

        while (true) {
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
