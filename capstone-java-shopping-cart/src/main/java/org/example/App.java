package org.example;

import org.example.exception.*;
import org.example.handler.*;
import org.example.model.MenuOption;
import org.example.service.*;

public class App {

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
                    new AddItemHandler().execute(appService, cartService);
                    break;
                case CHECKOUT:
                    new CheckoutHandler().execute(appService, cartService);
                    break;
                case EXIT:
                    new ExitHandler().execute(appService);
                    break;
                default:
                    // Sorry
            }
        }
    }
}
