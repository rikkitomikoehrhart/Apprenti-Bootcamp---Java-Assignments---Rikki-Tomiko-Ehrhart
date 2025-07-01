package org.example.model;

public enum Category {
    FICTION(1, "Fiction"),
    HISTORICAL_FICTION(2, "Historical Fiction"),
    SCIENCE_FICTION(3, "Science Fiction"),
    FANTASY(4, "Fantasy"),
    HORROR(5, "Horror"),
    MYSTERY(6, "Mystery"),
    THRILLER(7, "Thriller"),
    CRIME(8, "Crime"),
    ADVENTURE(9, "Adventure"),
    ROMANCE(10, "Romance"),
    YOUNG_ADULT(11, "Young Adult"),
    LGBTQ(12, "LGBTQ+"),
    BIOGRAPHY(13, "Biography"),
    SELF_HELP(14, "Self-Help"),
    HISTORY(15, "History"),
    SCIENCES(16, "Sciences"),
    RELIGION(17, "Religions"),
    HEALTH_WELLNESS(18, "Health and Wellness"),
    TEXTBOOKS(19, "Textbooks"),
    CHILDREN(20, "Children's Books"),
    LIFESTYLE(21, "Lifestyles"),
    REFERENCE(22, "Reference and Informational"),
    MISC(23, "Miscellaneous");

    private final int value;
    private final String description;

    Category(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public static Category getCategoryFromValue(int value) {
        for (Category category : values()) {
            if (category.value == value) {
                return category;
            }
        }

        return MISC;
    }

    public String getDescription() {
        return description;
    }

    public static String[] getCategoryListForDisplay() {
        String[] categoryList = new String[Category.values().length];

        for (int i = 0; i < Category.values().length; i++) {
            categoryList[i] = String.format("%d. %s", i+1, Category.values()[i].description);
        }

        return categoryList;
    }
}
