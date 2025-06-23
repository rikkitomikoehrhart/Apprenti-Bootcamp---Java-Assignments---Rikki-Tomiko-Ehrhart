package org.example.service;

import org.example.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class CartService {
    private final ShoppingCart shoppingCart;

    private static final String CART_ITEM_FORMAT = "%-10s   %-15s | %-10s %s";

    public CartService() {
        shoppingCart = new ShoppingCart();
    }


    public void addOrUpdateItem(Item item, int quantity) {
        if (quantity <= 0) {
            shoppingCart.removeItem(item);
        } else {
            shoppingCart.addItem(item, quantity);
        }
    }

    public void removeItem(Item item) {
        shoppingCart.removeItem(item);
    }

    public void emptyCart() {
        shoppingCart.empty();
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public int getItemQuantity(Item item) {
        return shoppingCart.getQuantity(item);
    }



    public ArrayList<String> getCartForDisplay() {
        ArrayList<String> itemsList = new ArrayList<>();

        itemsList.add("\n------------------- Shopping Cart --------------------");
        itemsList.add(String.format(CART_ITEM_FORMAT, "ITEM", "SKU", "QUANTITY", "PRICE"));


        if (shoppingCart.isEmpty()) {
            itemsList.add("Please add to your cart!");
        } else {
            for (Item item : shoppingCart.getItems()) {
                String lineItem = String.format(CART_ITEM_FORMAT, item.getName(), item.getSKU(), shoppingCart.getQuantity(item) ,item.getPrice());

                itemsList.add(lineItem);
            }
        }

        itemsList.add(String.format("%41s %s", "TOTAL:", getTotalForDisplay()));

        return itemsList;
    }

    public ArrayList<String> getReceiptForDisplay() {
        ArrayList<String> receipt;
        receipt = getCartForDisplay();

        receipt.set(0, "\n---------------------- Receipt -----------------------");
        receipt.add("\nTHANK YOU HAVE A NICE DAY!");

        return receipt;
    }

    public Item getItemFromCart(String name) {
        for (Item item : shoppingCart.getItems()) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }

        return null;
    }

    public String getTotalForDisplay() {
        return String.format("$%.2f", shoppingCart.getTotal());
    }
}
