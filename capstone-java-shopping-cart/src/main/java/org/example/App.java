package org.example;

import org.example.exception.EmptyInputException;
import org.example.exception.NullInputException;
import org.example.handler.DisplayCartHandler;
import org.example.model.MenuOption;
import org.example.model.ShoppingCart;
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

            int choice = appService.getIntFromUser("Please enter the number of your choice: ");

            switch (choice) {
                case 1:
                    new DisplayCartHandler().execute();
                    continue;
                case 2:
                    // Remove Item
                    break;
                case 3:
                    // Add Item
                    break;
                case 4:
                    // checkout
                    break;
                case 5:
                    // exit
                    break;
                default:
                    // Sorry
            }
        }
    }
}
