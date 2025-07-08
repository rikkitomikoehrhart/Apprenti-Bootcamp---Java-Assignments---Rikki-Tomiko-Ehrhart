package com.example.Inventory.Manager.model;

public enum MenuOption {
    ADD_PRODUCT(1, "Add Product"),
    VIEW_PRODUCTS(2, "View Products"),
    SEARCH_PRODUCTS(3, "Search Products"),
    UPDATE_PRODUCT(4, "Update Product"),
    DELETE_PRODUCT(5, "Delete Product"),
    LOAD_INVENTORY(6, "Load Inventory From File"),
    EXIT(7, "Exit");

    private final int value;
    private final String description;


    MenuOption(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public static MenuOption getMenuOptionFromValue(int value) {
        for (MenuOption option : values()) {
            if (option.value == value) {
                return option;
            }
        }
        return EXIT;
    }

    public static String[] getMenuForDisplay() {
        String[] menu = new String[MenuOption.values().length];

        MenuOption[] options = values();
        for (int i = 0; i < options.length; i++) {
            menu[i] = String.format("%d. %s", options[i].value, options[i].description);
        }

        return menu;
    }

}
