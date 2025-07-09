package com.example.Inventory.Manager.ui;

import com.example.Inventory.Manager.model.CartOption;
import com.example.Inventory.Manager.model.InventoryItem;
import com.example.Inventory.Manager.model.MenuOption;
import com.example.Inventory.Manager.model.PerishableProduct;

public class View {
    UIUtils uiUtils = new UIUtils();
    private final String DISPLAY_PERISHABLE_PRODUCT = "%10-s | %-20s | %-10s | $%10.2f | %s";


    public void displayHeader(String header) {
        uiUtils.println("");
        uiUtils.println("===== " + header + " =====");
    }

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

    public CartOption getCartChoiceFromUser() {
        return CartOption.getCartOptionFromValue(uiUtils.readInt("Enter your choice [1-7]: "));
    }

    public void displayPerishableProduct(InventoryItem product) {
        PerishableProduct perishable = (PerishableProduct) product.getProduct();
        uiUtils.printf(DISPLAY_PERISHABLE_PRODUCT, product.getProduct().getProductID(), product.getProduct().getProductName(), product.getQuantity(), product.getPrice(), perishable.getExpirationDate());
    }
}
