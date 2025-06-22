package org.example;

import org.example.exception.EmptyInputException;
import org.example.exception.NullInputException;
import org.example.handler.DisplayCartHandler;
import org.example.handler.RemoveItemHandler;
import org.example.model.MenuOption;
import org.example.service.AppService;
import org.example.service.CartService;

public class App
{
    public static void main( String[] args ) throws EmptyInputException, NullInputException {
        AppService appService = new AppService();
        CartService cartService = new CartService();

        appService.print("Welcome to the Shopping Cart App\n");

        while (true) {
            appService.displayListOfStrings(MenuOption.getMenuForDisplay());

            MenuOption choice = MenuOption.getMenuOptionFromValue(appService.getIntFromUser("Please enter the number of your choice: "));

            switch (choice) {
                case DISPLAY_CART:
                    new DisplayCartHandler().execute(appService, cartService);
                    continue;
                case REMOVE_ITEM:
                    new RemoveItemHandler().execute(appService, cartService);
                    break;
                case ADD_ITEM:
                    // Add Item
                    break;
                case CHECKOUT:
                    // checkout
                    break;
                case EXIT:
                    // exit
                    break;
                default:
                    // Sorry
            }
        }
    }
}
