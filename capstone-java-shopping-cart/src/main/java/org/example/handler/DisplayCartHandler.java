package org.example.handler;

import org.example.service.AppService;
import org.example.service.CartService;

public class DisplayCartHandler implements HandlerInterface {

    @Override
    public void execute(AppService appService, CartService cartService) {
        appService.displayListOfStrings(cartService.getCartForDisplay().toArray(new String[0]));
    }
}
