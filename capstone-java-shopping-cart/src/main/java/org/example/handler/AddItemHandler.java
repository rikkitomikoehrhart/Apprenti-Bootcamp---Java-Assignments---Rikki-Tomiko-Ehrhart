package org.example.handler;

import org.example.exception.EmptyInputException;
import org.example.exception.NullInputException;
import org.example.model.Item;
import org.example.model.ShoppingCart;
import org.example.service.*;
import java.math.BigDecimal;
import java.util.HashMap;

public class AddItemHandler implements WorkFlowHandler {

    @Override
    public void execute(AppService appService, CartService cartService, ShoppingCart shoppingCart, HashMap<Item, Integer> cart) throws EmptyInputException, NullInputException {
        new DisplayCartHandler().execute(appService, cartService, shoppingCart, cart);
        Item item;


        String itemName = appService.getItemNameFromUser();
        BigDecimal itemPrice = appService.getItemPriceFromUser(itemName);
        String itemSKU = appService.getItemSKUFromUser();
        int itemQuantity = appService.getItemQuantityFromUser();


        item = cartService.getItemFromCart(itemName);

        if (item != null) {
            appService.print("That item was already in your cart. ");
            if (itemQuantity != 0) {
                appService.println("It is now updated with your new entries.");
                itemPrice = item.getPrice();
                itemSKU = item.getSKU();
            } else {
                appService.println("Since you updated the quantity to 0, that product has been removed.");
                cartService.removeItem(item);
                return;
            }
        } else {
            item = new Item();
        }

        item.setAll(itemName, itemPrice, itemSKU);
        cartService.addOrUpdateItem(item, itemQuantity);
    }
}
