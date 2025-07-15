package com.example.Inventory.Manager.ui;

import com.example.Inventory.Manager.model.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class View {
    UIUtils uiUtils = new UIUtils();
    private final String DISPLAY_PERISHABLE_PRODUCT = "%10s | %-17s | %-10s | $%10.2f | %s%n";
    private final String DISPLAY_HEADING = "%10s | %-17s | %-10s | %-10s  | %s%n";
    private final String DISPLAY_CART_HEADING = "%10s | %-17s | %-10s | %-10s%n";

    // UNIVERSAL FUNCTIONS
    private void displayHeader(String header) {
        uiUtils.println("");
        uiUtils.println("===== " + header + " =====");
    }

    private void displayPerishableProduct(InventoryItem product) {
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

    private void reportHeader(String reportTitle) {
        uiUtils.println("═══════════════════════════════════════════════════════════════════════════");

        int titleLength = reportTitle.length();
        int spaces = 37 - (titleLength/2);
        uiUtils.println(" ".repeat(spaces) + reportTitle);

        uiUtils.println("═══════════════════════════════════════════════════════════════════════════");

    }

    private void reportFooter() {
        uiUtils.println("═══════════════════════════════════════════════════════════════════════════");
    }

    public String searchBar() {
        return uiUtils.readString("Enter the Product ID or Product Name: ");
    }

    public void displayViewProductsTitle() {
        displayHeader("View Products");
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

    public void displaySearchProductsTitle() {
        displayHeader("Search Products");
    }

    public void displayUpdateProductTitle() {
        displayHeader("Update Product");
    }

    public void displayDeleteProductTitle() {
        displayHeader("Delete Product");
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

    public void displayAddProductsToCartTitle() {
        displayHeader("Add Products To Cart");
    }

    public void displayViewShoppingCartTitle() {
        displayHeader("View Shopping Cart");
    }

    public void displayUpdateCartTitle() {
        displayHeader("Update Shopping Cart");
    }

    public void displayCheckoutTitle() {
        displayHeader("CHECKOUT");
    }

    public void viewAvailableProducts(List<InventoryItem> inventoryItems) {
        reportHeader("PRODUCTS");
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

    public int getQuantityFromUser() {
        return uiUtils.readInt("How many to add?: ");
    }

    public void viewShoppingCart(List<CartItem> cartItems, BigDecimal total) {
        reportHeader("SHOPPING CART");
        uiUtils.printf(DISPLAY_CART_HEADING, "ID", "NAME", "QUANTITY", "PRICE");
        uiUtils.println("---------------------------------------------------------------------------");

        if (cartItems.isEmpty()) {
            uiUtils.println("Sorry, there are no products.");
        }
        for (CartItem item : cartItems) {
            displayShoppingCartItem(item);
        }

        reportFooter();
        uiUtils.println("TOTAL: \t\t$" + total);
        reportFooter();
    }

    public void displayShoppingCartItem(CartItem product) {
        String id = product.getItem().getProduct().getProductID();
        String name = product.getItem().getProduct().getProductName();
        int quantity = product.getQuantity();
        BigDecimal price = product.getSubTotal();

        if (name.length() > 20) {
            name = name.substring(0, 17) + "...";
        }

        uiUtils.printf(DISPLAY_CART_HEADING, id, name, quantity, price);
    }

    public int getQuantityUpdateFromUser(CartItem item) {
        uiUtils.println("Enter new value, press enter to keep old value, or enter 0 to remove time.");
        String quantity = uiUtils.readString("Quantity (" + item.getQuantity() + "): ");

        if (!quantity.isBlank()) {
            if (uiUtils.convertToInt(quantity) != null) {
                return (Integer) uiUtils.convertToInt(quantity);
            }
        } else if (quantity.isBlank()) {
            return item.getQuantity();
        } else {
            return 0;
        }

        return 0;
    }

    public CartItem getItemToUpdateFromUser(List<CartItem> cartItems) {
        if (cartItems.isEmpty()) {
            return null;
        } else if (cartItems.size() == 1) {
            return cartItems.get(0);
        } else {
            for (int i = 0; i < cartItems.size(); i++) {
                uiUtils.print((i + 1) + ". ");
                displayCartItem(cartItems.get(i));
            }

            int choice = uiUtils.readInt("Enter the number of the item you wish to update: ");

            if (choice < 0 || choice > cartItems.size()) {
                return null;
            } else {
                return cartItems.get(choice - 1);
            }
        }
    }

    public void displayCartItem(CartItem item) {
        uiUtils.printf(DISPLAY_CART_HEADING, item.getItem().getProduct().getProductID(), item.getItem().getProduct().getProductName(), item.getQuantity(), item.getSubTotal());
    }

    public boolean readyToCheckOut() {
        return uiUtils.readBoolean("Are you ready to check out? [y]: ");
    }

    public void displayThankYouMessage(BigDecimal total) {
        uiUtils.printf("%nYou're Total is: $%.2f%n", total);
        uiUtils.println("HAVE A NICE DAY");
    }
}
