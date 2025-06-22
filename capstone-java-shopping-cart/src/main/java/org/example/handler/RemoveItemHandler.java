package org.example.handler;

import org.example.exception.EmptyInputException;
import org.example.exception.NullInputException;
import org.example.model.Item;
import org.example.service.AppService;
import org.example.service.CartService;

public class RemoveItemHandler {

    public void execute(AppService appService, CartService cartService) throws EmptyInputException, NullInputException {
        new DisplayCartHandler().execute(appService, cartService);

        String itemName = appService.getStringFromUser("Please enter the name of the product you wish to remove");

        Item item = cartService.getItemFromCart(itemName);

        if (item == null) {
            appService.print("ERROR: That item isn't in the cart.");
            return;
        }

        cartService.removeItem(item);
        appService.print(String.format("%s has been successfully removed", item.getName()));
    }
}
