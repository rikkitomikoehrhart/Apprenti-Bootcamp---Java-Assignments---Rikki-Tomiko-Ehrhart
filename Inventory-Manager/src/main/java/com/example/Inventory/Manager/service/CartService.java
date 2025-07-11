package com.example.Inventory.Manager.service;


import com.example.Inventory.Manager.model.CartItem;
import com.example.Inventory.Manager.model.InventoryItem;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    List<CartItem> cart;

    public void CartService() {
        cart = new ArrayList<>();
    }

    public void addToCart(InventoryItem item, int quantity) {
        cart.add(new CartItem(item, quantity));
    }



}
