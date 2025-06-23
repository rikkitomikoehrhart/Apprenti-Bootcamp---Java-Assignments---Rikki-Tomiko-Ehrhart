package org.example.handler;

import org.example.exception.EmptyInputException;
import org.example.exception.NullInputException;
import org.example.service.AppService;
import org.example.service.CartService;

public class CheckoutHandler implements HandlerInterface{

    @Override
    public void execute(AppService appService, CartService cartService) throws EmptyInputException, NullInputException {
        appService.displayListOfStrings(cartService.getReceiptForDisplay().toArray(new String[0]));
        String choice = appService.getStringFromUser("\nReady to checkout? (y/anything else for no): ");

        if (choice.toLowerCase().equals("y")) {
            appService.print("Total: " + cartService.shoppingCart.getTotalForDisplay() + ". Thank you! Cart is empty and ready for the next customer.");

            cartService.emptyCart();
            cartService.shoppingCart.processTotal();



        } else {
            appService.print("Checkout canceled.");
            return;
        }
    }
}
