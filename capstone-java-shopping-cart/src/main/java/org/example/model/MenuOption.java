package org.example.model;

public enum MenuOption {
    DISPLAY_CART(1, "Display Cart"),
    REMOVE_ITEM(2, "Remove an Item"),
    ADD_ITEM(3, "Add an Item"),
    CHECKOUT(4, "Checkout"),
    EXIT(5, "Exit");

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
        String[] menu = new String[MenuOption.values().length + 1];

        menu[0] = "Main Menu";

        MenuOption[] options = values();
        for (int i = 1; i < menu.length; i++) {
            MenuOption option = options[i - 1];
            menu[i] = String.format("%d. %s", option.value, option.description);
        }
        return menu;
    }

}
