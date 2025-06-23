package org.example.handler;

import org.example.service.*;

public class DisplayCartHandler implements HandlerInterface {

    @Override
    public void execute(AppService appService, CartService cartService) {
        appService.displayListOfStrings(cartService.getCartForDisplay().toArray(new String[0]));
    }
}
