package org.example.model.data;

import org.example.model.Location;
import org.example.model.inventory.BookItem;
import org.example.model.inventory.Category;
import org.example.model.inventory.InventoryItem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryBookRepository implements LibraryDataRepository {
    private final String filePath;
    private final String DELIMITER = "~";

    public LibraryBookRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<InventoryItem> findAll() throws DataAccessException {
        ArrayList<InventoryItem> library = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                String[] elements = line.split(DELIMITER);

                String title = elements[1];
                String author = elements[2];
                int year = Integer.parseInt(elements[3]);
                Category category = Category.getCategoryFromCategory(elements[4]);
                Location location = new Location();
                location.setShelf(Integer.parseInt(elements[5]));
                location.setPosition(Integer.parseInt(elements[6]));
                String isbn = elements[7];

                if (elements[0] == "BookItem") {
                    BookItem book = new BookItem();
                    book.setAll(title, author, year, category, location, isbn);

                    library.add(book);
                }
            }
        } catch (FileNotFoundException ex) {
            // If it doesn't exist, we'll create it.
        } catch (IOException ex) {
            throw new DataAccessException("Could not open the file path: " + filePath, ex);
        }

        return library;
    }


    @Override
    public InventoryItem findByISBN(String isbn) throws DataAccessException {
        List<InventoryItem> all = findAll();

        for (InventoryItem item : all) {
            if (item.getIsbn() == isbn) {
                return item;
            }
        }
        return null;
    }


    @Override
    public boolean isbnTaken(String isbn) throws DataAccessException {
        List<InventoryItem> all = findAll();

        for (InventoryItem item : all) {
            if (item.getIsbn() == isbn) {
                return true;
            }
        }
        return false;
    }


    @Override
    public InventoryItem add(InventoryItem item) throws DataAccessException {
        List<InventoryItem> all = findAll();
        all.add(item);
        writeToFile(all);
        return item;
    }

    @Override
    public boolean update(InventoryItem item) throws DataAccessException {
        List<InventoryItem> all = findAll();

        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getIsbn() == item.getIsbn()) {
                all.set(i, item);
                writeToFile(all);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteByIsbn(String isbn) throws DataAccessException {
        List<InventoryItem> all = findAll();

        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getIsbn() == isbn) {
                all.remove(i);
                writeToFile(all);
                return true;
            }
        }
        return false;
    }

    private void writeToFile(List<InventoryItem> items) throws DataAccessException {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (InventoryItem item : items) {
                writer.println(String.format(
                        "%s%s%s%s%s%s%s%s%s%s%s%s%s",
                        item.getClass(), DELIMITER,
                        item.getTitle(), DELIMITER,
                        item.getAuthor(), DELIMITER,
                        item.getCategory(), DELIMITER,
                        item.getLocation().getShelf(), DELIMITER,
                        item.getLocation().getPosition(), DELIMITER,
                        item.getIsbn()
                ));
            }
        } catch (IOException ex) {
            throw new DataAccessException("Could not write to file path: " + filePath, ex);
        }
    }

}
