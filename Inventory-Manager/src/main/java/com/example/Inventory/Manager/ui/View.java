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

    public void displayUpdateProductTitle() {
        displayHeader("Update Product");
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

    public InventoryItem updateProductFromUser(InventoryItem item) {
        PerishableProduct perishable = (PerishableProduct) item.getProduct();

        uiUtils.println("Enter new value or enter to keep old value");
        String id = uiUtils.readString("Product ID (" + item.getProduct().getProductID() + "): ");
        String name = uiUtils.readString("Product Name (" + item.getProduct().getProductName() + "): ");
        String quantity = uiUtils.readString("Quantity (" + item.getQuantity() + "): ");
        String price = uiUtils.readString("Price ($" + item.getPrice() + "): $");
        String expirationDate = uiUtils.readString("Expiration Date (" + perishable.getExpirationDate() + "): ");

        if (!id.isBlank()) {
            item.getProduct().setProductID(id);
        }
        if (!name.isBlank()) {
            item.getProduct().setProductName(name);
        }
        if (!quantity.isBlank()) {
            if (uiUtils.convertToInt(quantity) != null) {
                item.setQuantity((Integer) uiUtils.convertToInt(quantity));
            }
        }
        if (!price.isBlank()) {
            if (uiUtils.convertToBigDecimal(price) != null) {
                item.setPrice(uiUtils.convertToBigDecimal(price));
            }
        }
        if (!expirationDate.isBlank()) {
            if (uiUtils.convertToLocalDate(expirationDate) != null) {
                perishable.setExpirationDate(uiUtils.convertToLocalDate(expirationDate));
            }
        }

        item.setProduct(perishable);

        return item;
    }

    public void viewProductsReport(List<InventoryItem> inventoryItems) {
        reportHeader("INVENTORY");
        uiUtils.printf(DISPLAY_HEADING, "ID", "NAME", "QUANTITY", "PRICE", "EXPIRATION DATE");
        uiUtils.println("---------------------------------------------------------------------------");

        if (inventoryItems.isEmpty()) {
            uiUtils.println("Sorry, there are no products.");
        }
        for (InventoryItem item : inventoryItems) {
            displayPerishableProduct(item);
        }

        reportFooter();
    }

    public InventoryItem getItemForUser(List<InventoryItem> inventoryItems) {
        if (inventoryItems.isEmpty()) {
            return null;
        } else if (inventoryItems.size() == 1) {
            return inventoryItems.get(0);
        } else {
            for (int i = 0; i < inventoryItems.size(); i++) {
                uiUtils.print((i+1) + ". ");
                displayPerishableProduct(inventoryItems.get(i));
            }

            int choice = uiUtils.readInt("Please enter the number of the item you choose: ");

            if (choice > 0 && choice <= inventoryItems.size()) {
                return inventoryItems.get(choice-1);
            } else {
                return null;
            }
        }
    }

    public String searchBar() {
        return uiUtils.readString("Enter the Product ID or Product Name: ");
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
