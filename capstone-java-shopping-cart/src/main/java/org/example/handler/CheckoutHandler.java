package org.example.handler;

import org.example.service.*;


public class CheckoutHandler implements WorkFlowHandler {
    private AppService appService;
    private CartService cartService;

    public CheckoutHandler(AppService appService, CartService cartService) {
        this.appService = appService;
        this.cartService = cartService;
    }

    @Override
    public void execute() {
        appService.displayArrayListOfStrings(cartService.getReceiptForDisplay());

        String choice = appService.getStringFromUser("\nReady to checkout? (y/anything else for no): ");

        if (choice.equalsIgnoreCase("y")) {
            appService.println("Total: " + cartService.getTotalForDisplay() + ". Thank you! Cart is empty and ready for the next customer.");

            cartService.emptyCart();


        } else {
            appService.println("Checkout canceled.");
        }
    }

}
