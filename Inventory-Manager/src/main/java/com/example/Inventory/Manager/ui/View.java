package com.example.Inventory.Manager.ui;

import com.example.Inventory.Manager.model.PerishableProduct;

public class View {
    UIUtils uiUtils = new UIUtils();
    private final String DISPLAY_PERISHABLE_PRODUCT = "%10-s | %-20s | %-10s | $%10.2f | %s";



    public void displayPerishableProduct(PerishableProduct product) {
        uiUtils.printf(DISPLAY_PERISHABLE_PRODUCT, product.getProductID(), product.getProductName(), product.getQuantity(), product.getPrice(), product.getExpirationDate());
    }
}
