package org.example.handler;

import org.example.exception.EmptyInputException;
import org.example.exception.NullInputException;
import org.example.model.Item;
import org.example.model.ShoppingCart;
import org.example.service.*;

import java.util.HashMap;


public class CheckoutHandler implements WorkFlowHandler {

    @Override
    public void execute(AppService appService, CartService cartService, ShoppingCart shoppingCart, HashMap<Item, Integer> cart) throws EmptyInputException, NullInputException {
        appService.displayListOfStrings(cartService.getReceiptForDisplay().toArray(new String[0]));

        String choice = appService.getStringFromUser("\nReady to checkout? (y/anything else for no): ");

        if (choice.equalsIgnoreCase("y")) {
            appService.println("Total: " + cartService.getTotalForDisplay() + ". Thank you! Cart is empty and ready for the next customer.");

            cartService.emptyCart();
            cartService.processTotal();



        } else {
            appService.println("Checkout canceled.");
        }
    }

}
