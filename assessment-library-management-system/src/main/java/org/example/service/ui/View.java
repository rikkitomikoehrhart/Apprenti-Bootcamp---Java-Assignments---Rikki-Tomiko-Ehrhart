package org.example.service.ui;

import org.example.model.Location;
import org.example.model.inventory.InventoryItem;
import org.example.service.MenuOption;

import java.util.List;

public class View {
    private final TextIO io;

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
}
