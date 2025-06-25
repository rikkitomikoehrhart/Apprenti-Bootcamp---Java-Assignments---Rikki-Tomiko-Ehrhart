package org.example.handler;


import org.example.service.*;


public class DisplayCartHandler implements WorkFlowHandler {
    private AppService appService;
    private CartService cartService;

    public DisplayCartHandler(AppService appService, CartService cartService) {
        this.appService = appService;
        this.cartService = cartService;
    }

    @Override
    public void execute() {
        appService.displayArrayListOfStrings(cartService.getCartForDisplay());
    }
}
