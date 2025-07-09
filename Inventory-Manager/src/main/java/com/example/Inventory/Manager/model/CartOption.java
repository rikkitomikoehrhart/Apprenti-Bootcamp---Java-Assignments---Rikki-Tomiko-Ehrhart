package com.example.Inventory.Manager.model;

public enum CartOption {
    ADD_PRODUCT(1, "Add Product to Cart"),
    VIEW_PRODUCTS(2, "View All Products"),
    SEARCH_PRODUCTS(3, "Search All Products"),
    UPDATE_CART(4, "Update Cart"),
    VIEW_CART(5, "View Cart"),
    CHECKOUT(6, "Checkout"),
    EXIT(7, "Exit");

    private final int value;
    private final String description;


    CartOption(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public static CartOption getCartOptionFromValue(int value) {
        for (CartOption option : values()) {
            if (option.value == value) {
                return option;
            }
        }
        return EXIT;
    }

    public static String[] getCartMenuForDisplay() {
        String[] menu = new String[CartOption.values().length];

        CartOption[] options = values();
        for (int i = 0; i < options.length; i++) {
            menu[i] = String.format("%d. %s", options[i].value, options[i].description);
        }

        return menu;
    }

}
