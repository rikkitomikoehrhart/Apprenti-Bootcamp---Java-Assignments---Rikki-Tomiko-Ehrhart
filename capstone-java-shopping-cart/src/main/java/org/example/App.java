package org.example;

import org.example.handler.*;
import org.example.model.Item;
import org.example.model.MenuOption;
import org.example.model.ShoppingCart;
import org.example.service.*;

import java.util.HashMap;

public class App {

    public static void main( String[] args ) {
        AppService appService = new AppService();
        CartService cartService = new CartService();
        ShoppingCart shoppingCart = cartService.getShoppingCart();
        HashMap<Item, Integer> cart = shoppingCart.getCart();

        appService.println("Welcome to the Shopping Cart App\n");

        while (true) {
            appService.displayListOfStrings(MenuOption.getMenuForDisplay());

            MenuOption choice = MenuOption.getMenuOptionFromValue(appService.getIntFromUser("Please enter the number of your choice: "));

            switch (choice) {
                case DISPLAY_CART:
                    new DisplayCartHandler().execute(appService, cartService, shoppingCart, cart);
                    continue;
                case REMOVE_ITEM:
                    new RemoveItemHandler().execute(appService, cartService, shoppingCart, cart);
                    continue;
                case ADD_ITEM:
                    new AddItemHandler().execute(appService, cartService, shoppingCart, cart);
                    continue;
                case CHECKOUT:
                    new CheckoutHandler().execute(appService, cartService, shoppingCart, cart);
                    continue;
                case EXIT:
                    new ExitHandler().execute(appService, cartService, shoppingCart, cart);
                    break;
                default:
                    appService.println("Sorry, there was an error processing. Please try again.");
            }

            break;
        }
    }
}
