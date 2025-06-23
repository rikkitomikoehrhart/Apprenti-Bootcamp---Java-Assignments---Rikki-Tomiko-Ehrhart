package org.example.service;

import org.example.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class CartService {
    private ShoppingCart shoppingCart;
    private HashMap<Item, Integer> cart;

    private static final String CART_ITEM_FORMAT = "%-10s   %-15s | %-10s %s";

    public CartService() {
        shoppingCart = new ShoppingCart();
        cart = shoppingCart.getCart();
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void addOrUpdateItem(Item item, int quantity) {
        cart.put(item, quantity);
        processTotal();
    }

    public void removeItem(Item item) {
        cart.remove(item);
    }

    public void emptyCart() {
        cart.clear();
    }


    public ArrayList<String> getCartForDisplay() {
        ArrayList<String> itemsList = new ArrayList<>();

        itemsList.add("\n------------------- Shopping Cart --------------------");
        itemsList.add(String.format(CART_ITEM_FORMAT, "ITEM", "SKU", "QUANTITY", "PRICE"));


        for (Item item : cart.keySet()) {
            String lineItem = String.format(CART_ITEM_FORMAT, item.getName(), item.getSKU(), cart.get(item) ,item.getPrice());

            itemsList.add(lineItem);
        }

        if (cart.isEmpty()) {
            itemsList.add("Please add to your cart!");
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
        for (Item item : cart.keySet()) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }

        return null;
    }

    public void processTotal() {
        BigDecimal calculation = BigDecimal.ZERO;

        for (Item item : cart.keySet()) {
            BigDecimal price = item.getPrice();
            BigDecimal quantity = BigDecimal.valueOf(cart.get(item));

            calculation = calculation.add(price.multiply(quantity));
        }

        shoppingCart.setTotal(calculation);
    }

    public String getTotalForDisplay() {
        return String.format("$%.2f", shoppingCart.getTotal());
    }
}
