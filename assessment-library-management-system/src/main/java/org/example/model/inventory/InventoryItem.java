package org.example.model.inventory;

import org.example.model.Location;

public interface InventoryItem {
    String toString();
    void setAll(String title, String author, int year, Category category, Location location, String isbn);
    String getTitle();
    String getAuthor();
    int getYear();
    Category getCategory();
    Location getLocation();
    String getIsbn();
}
