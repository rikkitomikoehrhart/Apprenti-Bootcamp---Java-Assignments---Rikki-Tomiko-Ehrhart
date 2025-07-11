package com.example.Inventory.Manager.ui.cart_handlers;

import com.example.Inventory.Manager.model.InventoryItem;
import com.example.Inventory.Manager.service.CartService;
import com.example.Inventory.Manager.service.InventoryService;
import com.example.Inventory.Manager.ui.AppHandler;
import com.example.Inventory.Manager.ui.View;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddProductHandler implements AppHandler {
    View view;
    InventoryService service;
    CartService shoppingCart;

    public AddProductHandler(View view, InventoryService service, CartService shoppingCart) {
        this.view = view;
        this.service = service;
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void execute() {
        view.displayAddProductsToCartTitle();


        List<InventoryItem> availableItems = service.getAllAvailableInventory();

        view.viewAvailableProducts(availableItems);

        String itemIdOrName = view.searchBar();

        Set<InventoryItem> selection = new HashSet<>();

        selection.addAll(service.findProductById(itemIdOrName));
        selection.addAll(service.findProductByName(itemIdOrName));

        InventoryItem itemToAddToCart = view.getItemForUser(new ArrayList<>(selection));

        int quantity = view.getQuantityFromUser();
        if (quantity > itemToAddToCart.getQuantity()) {
            quantity = itemToAddToCart.getQuantity();
        }

        shoppingCart.addToCart(itemToAddToCart, quantity);
    }
}
