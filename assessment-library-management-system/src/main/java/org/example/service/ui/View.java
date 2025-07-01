package org.example.service.ui;

import org.example.model.Location;
import org.example.model.inventory.Category;
import org.example.model.inventory.InventoryItem;
import org.example.service.MenuOption;

import java.util.List;

public class View {
    private final TextIO io;
    private final String ITEM_STRING_FORMAT = "%-10s | %-15s | %-25s by %-25s (%d) | %s";

    public View(TextIO io) {
        this.io = io;
    }

    public MenuOption chooseMainMenuOption(){
        String[] menu = MenuOption.getMenuForDisplay();
        displayHeader("Main Menu");

        for (String menuItem : menu) {
            io.println(menuItem);
        }

        return MenuOption.getMenuOptionFromValue(io.readInt("Choose [0-5]: ", 0, 5));
    }

    public InventoryItem chooseItem(List<InventoryItem> items) {
        if (items.size() > 0) {
            int shelf = io.readInt("Shelf Number: ", 1, 250);
            int position = io.readInt("Position: ", 1, 250);

            for (InventoryItem item : items) {
                Location itemLocation = item.getLocation();
                if (itemLocation.getShelf() == shelf && itemLocation.getPosition() == position) {
                    return item;
                }
            }
        }

        return null;
    }


    public void displayHeader(String header) {
        int length = header.length();
        io.print("");
        io.println(header);
        io.println("=".repeat(length));
    }

    public void displayErrors(List<String> errors) {
        displayHeader("Errors:");
        for (String error : errors) {
            io.println(error);
        }
    }

    public void displayInventory(List<InventoryItem> items) {
        if (items.size() == 0) {
            displayHeader("No Items Found.");
        } else {
            displayHeader("Items:");
            io.printf(ITEM_STRING_FORMAT, "Shelf", "Position", "Title", "Author", "Year", "Category");
            for (InventoryItem item : items) {
                io.printf(
                        ITEM_STRING_FORMAT,
                        item.getLocation().getShelf(),
                        item.getLocation().getPosition(),
                        item.getTitle(),
                        item.getAuthor(),
                        item.getYear(),
                        item.getCategory().getDescription()
                );
            }
        }
    }

    public void displayCategories() {
        String[] list = Category.getCategoryListForDisplay();

        displayHeader("Categories:");
        for (String display : list) {
            io.println(display);
        }
    }


    public Category getCategoryFromUser() {
        return Category.getCategoryFromValue(io.readInt("Choose [1-23]: ", 1, 23));
    }

}
