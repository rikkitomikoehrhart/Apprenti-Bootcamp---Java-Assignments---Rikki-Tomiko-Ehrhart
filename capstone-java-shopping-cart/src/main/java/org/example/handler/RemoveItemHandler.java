package org.example.handler;

import org.example.exception.*;
import org.example.model.Item;
import org.example.service.*;

public class RemoveItemHandler implements HandlerInterface {

    @Override
    public void execute(AppService appService, CartService cartService) throws EmptyInputException, NullInputException {
        new DisplayCartHandler().execute(appService, cartService);

        String itemName = appService.getStringFromUser("Please enter the name of the product you wish to remove");

        Item item = cartService.getItemFromCart(itemName);

        if (item == null) {
            appService.print("ERROR: That item isn't in the cart.");
            return;
        }

        int quantityToRemove = appService.getIntFromUser("Please enter the amount you would like to remove: ");

        if (quantityToRemove == 0) {
            appService.print("Since you entered 0, the quantity will stay the same");
            return;
        } else {
            if (quantityToRemove >= cartService.shoppingCart.cart.get(item)) {
                cartService.removeItem(item);
                appService.print(String.format("%s has been successfully removed", item.getName()));
            } else {
                int newQuantity = cartService.shoppingCart.cart.get(item) - quantityToRemove;
                cartService.addOrUpdateItem(item, newQuantity);
            }
        }


    }
}
