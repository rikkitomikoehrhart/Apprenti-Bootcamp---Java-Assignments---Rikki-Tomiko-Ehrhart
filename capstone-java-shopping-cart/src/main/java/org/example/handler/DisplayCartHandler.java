package org.example.handler;

import org.example.model.Item;
import org.example.model.ShoppingCart;
import org.example.service.*;

import java.util.HashMap;

public class DisplayCartHandler implements WorkFlowHandler {

    @Override
    public void execute(AppService appService, CartService cartService, ShoppingCart shoppingCart, HashMap<Item, Integer> cart) {
        appService.displayListOfStrings(cartService.getCartForDisplay().toArray(new String[0]));
    }
}
