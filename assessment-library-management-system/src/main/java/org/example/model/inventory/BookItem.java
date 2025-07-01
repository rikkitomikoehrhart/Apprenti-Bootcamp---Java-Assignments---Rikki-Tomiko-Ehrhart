package org.example.model.inventory;

import org.example.model.Location;

public class BookItem implements InventoryItem {
    private String title;
    private String author;
    private int year;
    private Category category;
    private Location location;
    private final String isbn;

    public BookItem(String title, String author, int year, Category category, Location location, String isbn) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.category = category;
        this.location = location;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return String.format("Shelf %d - Position %d | %s | %s by %s (%d)",
                this.location.getShelf(),
                this.location.getPosition(),
                this.category.getDescription(),
                this.title,
                this.author,
                this.year);
    }
}
