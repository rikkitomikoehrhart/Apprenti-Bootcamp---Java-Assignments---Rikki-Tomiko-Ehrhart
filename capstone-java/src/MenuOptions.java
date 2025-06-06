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
    public String getDescription() {
        return description;
    }

    // OTHER
    public static MenuOptions getMenuOptionFromValue(int value) {
        for (MenuOptions option : values()) {
            if (option.value == value) {
                return option;
            }
        }
        return EXIT;
    }

}
