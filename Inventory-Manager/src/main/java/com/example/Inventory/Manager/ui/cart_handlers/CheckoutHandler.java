package com.example.Inventory.Manager.ui.cart_handlers;

import com.example.Inventory.Manager.model.CartItem;
import com.example.Inventory.Manager.service.CartService;
import com.example.Inventory.Manager.service.InventoryService;
import com.example.Inventory.Manager.ui.AppHandler;
import com.example.Inventory.Manager.ui.View;

import java.util.List;

public class CheckoutHandler implements AppHandler {
    View view;
    InventoryService service;
    CartService shoppingCart;

    public CheckoutHandler(View view, InventoryService service, CartService shoppingCart) {
        this.view = view;
        this.service = service;
        this.shoppingCart = shoppingCart;
    }


    @Override
    public void execute() {
        view.displayCheckoutTitle();

        List<CartItem> cartItems = shoppingCart.getCart();
        view.viewShoppingCart(cartItems, shoppingCart.getTotal());

        if (view.readyToCheckOut()) {
            view.displayThankYouMessage(shoppingCart.getTotal());
            shoppingCart.getCart().clear();
            service.saveInventory();
        }
    }
}
