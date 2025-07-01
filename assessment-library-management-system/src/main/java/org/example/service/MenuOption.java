package org.example.service;

public enum MenuOption {
    EXIT(0, "Exit"),
    DISPLAY_ALL_BOOKS(1, "Display All Books"),
    FIND_BOOKS_BY_CATEGORY(2, "Find Books By Category"),
    ADD_A_BOOK(3, "Add a Book"),
    UPDATE_A_BOOK(4, "Update a Book"),
    REMOVE_A_BOOK(5, "Remove a Book");

    private int value;
    private String description;

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
