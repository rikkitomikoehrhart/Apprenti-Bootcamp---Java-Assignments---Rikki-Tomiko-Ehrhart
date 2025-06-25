package org.example.handler;


import org.example.model.Product;
import org.example.service.*;


public class RemoveItemHandler implements WorkFlowHandler {
    AppService appService;
    CartService cartService;

    public RemoveItemHandler(AppService appService, CartService cartService) {
        this.appService = appService;
        this.cartService = cartService;
    }

    @Override
    public void execute() {
        new DisplayCartHandler(appService, cartService).execute();

        String itemName = appService.getItemNameFromUser();
        Product item = cartService.getItemFromCart(itemName);


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
