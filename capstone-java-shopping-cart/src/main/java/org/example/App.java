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
                    new DisplayCartHandler(appService, cartService).execute();
                    continue;
                case REMOVE_ITEM:
                    new RemoveItemHandler(appService, cartService).execute();
                    continue;
                case ADD_ITEM:
                    new AddItemHandler(appService, cartService).execute();
                    continue;
                case CHECKOUT:
                    new CheckoutHandler(appService, cartService).execute();
                    continue;
                case EXIT:
                    new ExitHandler(appService).execute();
                    break;
                default:
                    appService.println("Sorry, there was an error processing. Please try again.");
            }

            break;
        }
    }
}
