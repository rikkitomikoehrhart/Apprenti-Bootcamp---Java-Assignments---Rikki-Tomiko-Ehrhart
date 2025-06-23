package org.example.handler;

import org.example.model.Item;
import org.example.model.ShoppingCart;
import org.example.service.*;

import java.util.HashMap;


public class ExitHandler implements WorkFlowHandler {

    @Override
    public void execute(AppService appService, CartService cartService, ShoppingCart shoppingCart, HashMap<Item, Integer> cart) {
        appService.println("Thank you! Have a great day!");
        System.exit(0);
    }
}
