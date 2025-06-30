package learn.unexplained.ui;

public enum MenuOption {
    EXIT("Exit"),
    DISPLAY_ALL("Display All Encounters"),
    DISPLAY_ENCOUNTERS_BY_TYPE("Display Encounters By Type"),
    ADD("Add An Encounter");

    private String message;

    MenuOption(String name) {
        this.message = name;
    }

    public String getMessage() {
        return message;
    }
}
