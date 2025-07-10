package com.example.Inventory.Manager.ui;

import com.example.Inventory.Manager.model.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class View {
    UIUtils uiUtils = new UIUtils();
    private final String DISPLAY_PERISHABLE_PRODUCT = "%7s | %-20s | %-10s | $%10.2f | %s%n";
    private final String DISPLAY_HEADING = "%7s | %-20s | %-10s | %-10s  | %s%n";

    // UNIVERSAL FUNCTIONS
    public void displayHeader(String header) {
        uiUtils.println("");
        uiUtils.println("===== " + header + " =====");
    }

    public void displayPerishableProduct(InventoryItem product) {
        PerishableProduct perishable = (PerishableProduct) product.getProduct();

        String id = product.getProduct().getProductID();
        String name = product.getProduct().getProductName();
        int quantity = product.getQuantity();
        BigDecimal price = product.getPrice();
        LocalDate expirationDate = perishable.getExpirationDate();

        if (name.length() > 20) {
            name = name.substring(0, 17) + "...";
        }

        uiUtils.printf(DISPLAY_PERISHABLE_PRODUCT, id, name, quantity, price, expirationDate);
    }

    public void reportHeader(String reportTitle) {
        uiUtils.println("═══════════════════════════════════════════════════════════════════════════");

        int titleLength = reportTitle.length();
        int spaces = 37 - (titleLength/2);
        uiUtils.println(" ".repeat(spaces) + reportTitle);

        uiUtils.println("═══════════════════════════════════════════════════════════════════════════");

    }

    public void reportFooter() {
        uiUtils.println("═══════════════════════════════════════════════════════════════════════════");
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

    public void displayViewProductsTitle() {
        displayHeader("View Products");
    }

    public void displaySearchProductsTitle() {
        displayHeader("Search Products");
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

    public void viewProductsReport(List<InventoryItem> inventoryItems) {
        reportHeader("INVENTORY");
        uiUtils.printf(DISPLAY_HEADING, "ID", "NAME", "QUANTITY", "PRICE", "EXPIRATION DATE");
        uiUtils.println("---------------------------------------------------------------------------");

        if (inventoryItems.isEmpty()) {
            uiUtils.print("Sorry, there are no products.");
        }
        for (InventoryItem item : inventoryItems) {
            displayPerishableProduct(item);
        }

        reportFooter();
    }

    public String searchBar() {
        return uiUtils.readString("Enter a Product ID or Product Name: ");
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
