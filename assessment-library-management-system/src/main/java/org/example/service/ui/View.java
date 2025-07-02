package org.example.service.ui;

import org.example.model.Location;
import org.example.model.inventory.BookItem;
import org.example.model.inventory.Category;
import org.example.model.inventory.InventoryItem;
import org.example.service.MenuOption;
import org.example.service.domain.ItemResult;

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


    public InventoryItem createItem() {
        BookItem book = new BookItem();
        Location location = new Location();


        book.setAll(
                io.readString("Enter Title: "),
                io.readString("Enter Author: "),
                io.readInt("Enter Publish Year: "),
                Category.getCategoryFromDescription(io.readString("Enter Category: ")),
                location.setAll((io.readInt("Enter Shelf: ",1, 250)), (io.readInt("Enter Position: ",1,250))),
                io.readString("Enter ISBN: "));

        return book;
    }

    public String getUserChosenISBN() {
        displayHeader("Update An Item:");

        return io.readString("Enter ISBN: ");
    }

    public void displayISBNError() {
        io.println("-- That ISBN doesn't exist in the system. --");
    }

    public BookItem updateBook(BookItem book) {
        ItemResult result = new ItemResult();

        io.println("Editing " + book.getCategory().getDescription() + "-" + book.getLocation().getShelf() + "-" + book.getLocation().getPosition());
        io.println("Press [Enter] to keep original value.\n");

        String stringCategory = io.readString("Category (" + book.getCategory().getDescription() + "): ");
        if (stringCategory.trim().length() > 0) {
            book.setCategory(Category.getCategoryFromDescription(stringCategory));
        }

        String shelfNumber = io.readString("Shelf Number (" + book.getLocation().getShelf() + "): ");
        if (shelfNumber.trim().length() > 0) {
            try {
                book.getLocation().setShelf(Integer.parseInt(shelfNumber));
            } catch (NumberFormatException e) {
                result.addErrorMessage("- Shelf not updated, must be a valid number.");
            }
        }

        String position = io.readString("Position (" + book.getLocation().getPosition() + "): ");
        if (position.trim().length() > 0) {
            try {
                book.getLocation().setPosition(Integer.parseInt(position));
            } catch (NumberFormatException e) {
                result.addErrorMessage("- Position not updated, must be a valid number.");
            }
        }

        String title = io.readString("Title (" + book.getTitle() + "): ");
        if (title.trim().length() > 0) {
            book.setTitle(title);
        }


        String author = io.readString("Author (" + book.getAuthor() + "): ");
        if (author.trim().length() > 0) {
            book.setAuthor(author);
        }

        String year = io.readString("Year Published (" + book.getYear() + "): ");
        if (year.trim().length() > 0) {
            try {
                book.setYear(Integer.parseInt(year));
            } catch (NumberFormatException e) {
                result.addErrorMessage("- Year not updated, must be a valid number.");
            }
        }

        String isbn = io.readString("ISBN (" + book.getIsbn() + "): ");
        if (isbn.trim().length() > 0) {
            book.setIsbn(isbn);
        }

        if (!result.isSuccess()) {
            displayErrors(result.getErrorMessages());
        }

        return book;
    }
}
