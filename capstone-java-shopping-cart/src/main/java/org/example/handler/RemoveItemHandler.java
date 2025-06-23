package org.example.handler;


import org.example.model.Item;
import org.example.model.ShoppingCart;
import org.example.service.*;

import java.util.HashMap;

public class RemoveItemHandler implements WorkFlowHandler {

    @Override
    public void execute(AppService appService, CartService cartService, ShoppingCart shoppingCart, HashMap<Item, Integer> cart) {
        new DisplayCartHandler().execute(appService, cartService, shoppingCart, cart);

        String itemName = appService.getItemNameFromUser();
        Item item = cartService.getItemFromCart(itemName);


        if (item == null) {
            appService.println("ERROR: That item isn't in the cart.");
            return;
        }

        int quantityToRemove = appService.getItemQuantityFromUser();

        if (quantityToRemove == 0) {
            appService.println("Since you entered 0, the quantity will stay the same");
        } else if (quantityToRemove >= cart.get(item)) {
            cartService.removeItem(item);
            appService.println(String.format("%s has been successfully removed", item.getName()));
        } else {
            int newQuantity = cart.get(item) - quantityToRemove;
            cartService.addOrUpdateItem(item, newQuantity);
        }

    }
}
