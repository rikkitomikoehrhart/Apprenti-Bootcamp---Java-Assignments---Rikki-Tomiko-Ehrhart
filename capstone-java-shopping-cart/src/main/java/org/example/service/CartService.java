package org.example.service;

import org.example.model.Item;
import org.example.model.ShoppingCart;

import java.util.ArrayList;

public class CartService {
    public ShoppingCart shoppingCart;


    public CartService() {
        shoppingCart = new ShoppingCart();
    }


    public void addOrUpdateItem(Item item, int quantity) {
        shoppingCart.cart.put(item, quantity);
    }

    public void removeItem(Item item) {
        shoppingCart.cart.remove(item);
    }

    public void emptyCart() {
        shoppingCart.cart.clear();
    }

    public ArrayList<String> getCartForDisplay() {
        ArrayList<String> itemsList = new ArrayList<String>();

        itemsList.add("--------------- Shopping Cart ----------------");
        itemsList.add(String.format("%-10s - %-15s | %-10s %s", "ITEM", "SKU", "QUANTITY", "PRICE"));


        for (Item item : shoppingCart.cart.keySet()) {
            String lineItem = String.format("%-10s - %-15s | %-10s $%.2f", item.getName(), item.getSKU(), shoppingCart.cart.get(item) ,item.getPrice());

            itemsList.add(lineItem);
        }

        if (shoppingCart.cart.size() == 0) {
            itemsList.add("Please add to your cart!");
        }

        itemsList.add(String.format("%40s %s", "TOTAL:", shoppingCart.getTotalForDisplay()));

        return itemsList;
    }

    public ArrayList<String> getReceiptForDisplay() {
        ArrayList<String> receipt = new ArrayList<String>();
        receipt = getCartForDisplay();

        receipt.set(0, "------------------ Receipt -------------------");
        receipt.add("\nTHANK YOU HAVE A NICE DAY!");

        return receipt;
    }

    public Item getItemFromCart(String name) {
        for (Item item : shoppingCart.cart.keySet()) {
            if (item.getName().toLowerCase() == name.toLowerCase()) {
                return item;
            }
        }

        return null;
    }
}
