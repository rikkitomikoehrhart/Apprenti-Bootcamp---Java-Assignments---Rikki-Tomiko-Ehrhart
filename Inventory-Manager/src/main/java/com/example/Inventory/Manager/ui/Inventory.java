package com.example.Inventory.Manager.ui;

import com.example.Inventory.Manager.model.MenuOption;
import org.springframework.stereotype.Component;

@Component
public class Inventory {

    public void run() {
        View view = new View();

        while (true) {
            MenuOption choice = view.getMenuChoiceFromUser();

            switch (choice) {
                case ADD_PRODUCT:
                case VIEW_PRODUCTS:
                case SEARCH_PRODUCTS:
                case UPDATE_PRODUCT:
                case DELETE_PRODUCT:
                case LOAD_INVENTORY:
                case EXIT:
                    System.exit(0);
            }

        }


    }
}
