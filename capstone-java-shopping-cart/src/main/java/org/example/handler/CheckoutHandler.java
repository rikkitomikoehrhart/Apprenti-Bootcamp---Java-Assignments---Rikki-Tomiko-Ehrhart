package org.example.handler;

import org.example.service.*;


public class CheckoutHandler implements WorkFlowHandler {

    @Override
    public void execute(AppService appService, CartService cartService) {
        appService.displayListOfStrings(cartService.getReceiptForDisplay().toArray(new String[0]));

        String choice = appService.getStringFromUser("\nReady to checkout? (y/anything else for no): ");

        if (choice.equalsIgnoreCase("y")) {
            appService.println("Total: " + cartService.getTotalForDisplay() + ". Thank you! Cart is empty and ready for the next customer.");

            cartService.emptyCart();



        } else {
            appService.println("Checkout canceled.");
        }
    }

}
