package com.example.Inventory.Manager.ui;

import com.example.Inventory.Manager.model.*;

import java.math.BigDecimal;

public class View {
    UIUtils uiUtils = new UIUtils();
    private final String DISPLAY_PERISHABLE_PRODUCT = "%10-s | %-20s | %-10s | $%10.2f | %s";


    // UNIVERSAL FUNCTIONS
    public void displayHeader(String header) {
        uiUtils.println("");
        uiUtils.println("===== " + header + " =====");
    }

    public void displayPerishableProduct(InventoryItem product) {
        PerishableProduct perishable = (PerishableProduct) product.getProduct();
        uiUtils.printf(DISPLAY_PERISHABLE_PRODUCT, product.getProduct().getProductID(), product.getProduct().getProductName(), product.getQuantity(), product.getPrice(), perishable.getExpirationDate());
    }



    // INVENTORY MANAGER FUNCTIONS
    public void displayMainMenu() {
        displayHeader("Inventory Manager");

        String[] menuItems = MenuOption.getMenuForDisplay();

        for (String menuItem : menuItems) {
            uiUtils.println(menuItem);
        }
    }

    public MenuOption getMenuChoiceFromUser() {
        return MenuOption.getMenuOptionFromValue(uiUtils.readInt("Enter your choice [1-7]: "));
    }

    public void displayAddProductTitle() {
        displayHeader("Add Product");
    }

    public InventoryItem createNewProductFromUser() {
        String id = uiUtils.readString("Enter the Product ID: ");
        String name = uiUtils.readString("Enter the Product Name: ");
        int quantity = uiUtils.readInt("Enter the quantity: ");
        BigDecimal price = uiUtils.readBigDecimal("Enter the price: $");

        boolean isPerishable = uiUtils.readBoolean("Is this a Perishable Product? [y]: ");

        if (isPerishable) {
            return new InventoryItem(new PerishableProduct(new Product(id, name), uiUtils.readLocalDate("Enter Expiration Date [yyyy-mm-dd]: ")), quantity, price);
        } else {
            // for future types
        }

        return null;
    }


    // SHOPPING CART FUNCTIONS
    public void displayCartMenu() {
        displayHeader("Shopping Cart");

        String[] menuItems = CartOption.getCartMenuForDisplay();

        for (String menuItem : menuItems) {
            uiUtils.println(menuItem);
        }
    }

    public CartOption getCartChoiceFromUser() {
        return CartOption.getCartOptionFromValue(uiUtils.readInt("Enter your choice [1-7]: "));
    }


}
