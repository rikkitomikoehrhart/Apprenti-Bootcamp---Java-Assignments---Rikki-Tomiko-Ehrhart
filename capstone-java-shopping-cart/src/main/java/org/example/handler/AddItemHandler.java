package org.example.handler;

import org.example.exception.EmptyInputException;
import org.example.exception.NullInputException;
import org.example.model.Item;
import org.example.service.AppService;
import org.example.service.CartService;

import java.math.BigDecimal;

public class AddItemHandler implements HandlerInterface {

    @Override
    public void execute(AppService appService, CartService cartService) throws EmptyInputException, NullInputException {
        new DisplayCartHandler().execute(appService, cartService);
        Item item;


        String itemName = appService.getStringFromUser("Enter the name of the product you wish to add: ");
        BigDecimal itemPrice = appService.getBigDecimalFromUser("Enter the price for 1 " + itemName + ": $");
        String itemSKU = appService.getStringFromUser("Enter the item's SKU: ");
        int itemQuantity = appService.getIntFromUser("Enter the quantity for the item: ");


        item = cartService.getItemFromCart(itemName);

        if (item != null) {
            if (itemQuantity != 0) {
                appService.print("That item was already in your cart. It is now updated with your new entries.");
            } else {
                appService.print("That item was already in your cart. Since you updated the quantity to 0, that product has been removed.");
                cartService.removeItem(item);
                return;
            }

        }

        item.setName(itemName);
        item.setPrice(itemPrice);
        item.setSKU(itemSKU);

        cartService.addOrUpdateItem(item, itemQuantity);
        cartService.shoppingCart.processTotal();

    }
}
