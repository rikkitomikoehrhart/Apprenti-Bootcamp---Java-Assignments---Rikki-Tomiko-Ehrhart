package com.example.Inventory.Manager.ui.handlers.cart;

import com.example.Inventory.Manager.model.CartItem;
import com.example.Inventory.Manager.model.InventoryItem;
import com.example.Inventory.Manager.service.CartService;
import com.example.Inventory.Manager.service.InventoryService;
import com.example.Inventory.Manager.ui.handlers.AppHandler;

import com.example.Inventory.Manager.ui.View;

import java.util.List;

public class UpdateCartHandler implements AppHandler {
    View view;
    InventoryService service;
    CartService shoppingCart;

    public UpdateCartHandler(View view, InventoryService service, CartService shoppingCart) {
        this.view = view;
        this.service = service;
        this.shoppingCart = shoppingCart;
    }


    @Override
    public void execute() {
        view.displayUpdateCartTitle();

        List<CartItem> cartItems = shoppingCart.getCart();


        if (!shoppingCart.getCart().isEmpty()) {
            CartItem itemToUpdate = view.getItemToUpdateFromUser(cartItems);

            int newQuantity = view.getQuantityUpdateFromUser(itemToUpdate);


            if (newQuantity != itemToUpdate.getQuantity()) {
                InventoryItem itemFromInventory = service.getItemFromInventory(itemToUpdate);

                if (itemFromInventory == null) {
                    return;
                }

                if (newQuantity == 0) {
                    itemFromInventory.setQuantity(itemFromInventory.getQuantity() + itemToUpdate.getQuantity());
                    shoppingCart.removeFromCart(itemToUpdate);
                } else {
                    int difference = getDifference(newQuantity, itemToUpdate);

                    itemFromInventory.setQuantity(itemFromInventory.getQuantity() + difference);
                    itemToUpdate.setQuantity(newQuantity);
                    shoppingCart.updateSubTotal(itemToUpdate);
                }

            }
        }
    }


    private int getDifference(int newQuantity, CartItem item) {
        return item.getQuantity() - newQuantity;
    }
}
