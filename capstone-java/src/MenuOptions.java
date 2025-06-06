public enum MenuOptions {
    RENT(1, "Rent a locker"),
    ACCESS(2, "Access a Locker"),
    RELEASE(3, "Release a Locker"),
    EXIT(0, "Exit");

    private final int value;
    private final String description;

    MenuOptions(int value, String description) {
        this.value = value;
        this.description = description;
    }


    // GETS
    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    // OTHER
    public static MenuOptions getMenuOptionFromValue(int value) {
        /*
        *  Get MenuOptions From Value returns the menu option enum
        *  based on the value entered by the user or EXIT if any
        *  other value
        *
        *  ARGS:
        *       - int value : a user entered value used for navigating
        *  RETURNS:
        *       - MenuOption enum
        * */
        for (MenuOptions option : values()) {
            if (option.value == value) {
                return option;
            }
        }
        return EXIT;
    }

}
