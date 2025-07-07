package org.example.airport.domain.model;

public enum MenuOption {
    VIEW_ALL_FLIGHTS(1, "View All Flights"),
    ADD_PASSENGER(2, "Add a Passenger"),
    VIEW_PASSENGERS(3, "View Passengers On Flight"),
    SAVE(4, "Save Flight Reservations"),
    EXIT(5, "Exit");

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
