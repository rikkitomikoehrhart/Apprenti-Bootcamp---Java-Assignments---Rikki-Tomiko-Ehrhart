package org.example;

import org.example.handler.*;
import org.example.model.MenuOption;
import org.example.service.*;

public class App {

    public static void main( String[] args ) {
        AppService appService = new AppService();
        CartService cartService = new CartService();

        appService.println("Welcome to the Shopping Cart App\n");

        while (true) {
            appService.displayListOfStrings(MenuOption.getMenuForDisplay());

            MenuOption choice = MenuOption.getMenuOptionFromValue(appService.getIntFromUser("Please enter the number of your choice: "));

            switch (choice) {
                case DISPLAY_CART:
                    new DisplayCartHandler().execute(appService, cartService);
                    continue;
                case REMOVE_ITEM:
                    new RemoveItemHandler().execute(appService, cartService);
                    continue;
                case ADD_ITEM:
                    new AddItemHandler().execute(appService, cartService);
                    continue;
                case CHECKOUT:
                    new CheckoutHandler().execute(appService, cartService);
                    continue;
                case EXIT:
                    new ExitHandler().execute(appService, cartService);
                    break;
                default:
                    appService.println("Sorry, there was an error processing. Please try again.");
            }

            break;
        }
    }
}
