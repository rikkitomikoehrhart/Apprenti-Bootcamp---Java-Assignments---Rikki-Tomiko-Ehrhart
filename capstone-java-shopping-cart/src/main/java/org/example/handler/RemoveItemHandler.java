package org.example.handler;


import org.example.model.Item;
import org.example.service.*;


public class RemoveItemHandler implements WorkFlowHandler {

    @Override
    public void execute(AppService appService, CartService cartService) {
        new DisplayCartHandler().execute(appService, cartService);

        String itemName = appService.getItemNameFromUser();
        Item item = cartService.getItemFromCart(itemName);


        if (item == null) {
            appService.println("ERROR: That item isn't in the cart.");
            return;
        }

        int quantityToRemove = appService.getItemQuantityFromUser();

        if (quantityToRemove == 0) {
            appService.println("Since you entered 0, the quantity will stay the same");
        } else if (quantityToRemove >= cartService.getItemQuantity(item)) {
            cartService.removeItem(item);
            appService.println(String.format("%s has been successfully removed", item.getName()));
        } else {
            int newQuantity = cartService.getItemQuantity(item) - quantityToRemove;
            cartService.addOrUpdateItem(item, newQuantity);
        }

    }
}
