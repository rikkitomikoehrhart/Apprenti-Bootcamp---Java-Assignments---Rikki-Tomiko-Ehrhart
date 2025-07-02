package org.example.service.domain;

import org.example.model.data.DataAccessException;
import org.example.model.data.LibraryDataRepository;
import org.example.model.inventory.Category;
import org.example.model.inventory.InventoryItem;

import java.util.ArrayList;
import java.util.List;

public class ItemService {
    private final LibraryDataRepository repository;

    public ItemService(LibraryDataRepository repository) {
        this.repository = repository;
    }

    public List<InventoryItem> findAll() throws DataAccessException {
        return repository.findAll();
    }


    public InventoryItem findByISBN(String isbn) throws DataAccessException {
        return repository.findByISBN(isbn);
    }

    public boolean isbnTaken(String isbn) throws DataAccessException {
        return repository.isbnTaken(isbn);
    }


    private ItemResult validate(InventoryItem item) {
        ItemResult result = new ItemResult();

        if (item == null) {
            result.addErrorMessage("Item cannot be null.");
            return result;
        }

        if (item.getIsbn() == null || item.getIsbn().equals("")) {
            result.addErrorMessage("- ISBN cannot be blank");
        }

        if (item.getTitle() == null || item.getTitle().equals("")) {
            result.addErrorMessage("- Title cannot be blank");
        }

        if (item.getAuthor() == null || item.getAuthor().equals("")) {
            result.addErrorMessage("- Author cannot be blank");
        }

        return result;
    }

    public ItemResult okToAdd(InventoryItem item) {
        ItemResult result = validate(item);
        List<InventoryItem> items = findAll();

        for (InventoryItem i : items) {
            if (i.getIsbn().equals(item.getIsbn())) {
                result.addErrorMessage("- Duplicate ISBN");
            }

            if (i.getYear() > 2025) {
                result.addErrorMessage("- Book Release Year can only be in the past or present, not the future");
            }

            if (i.getLocation().getShelf() == item.getLocation().getShelf()) {
                if (i.getLocation().getPosition() == item.getLocation().getPosition()) {
                    result.addErrorMessage("- There is already a book on Shelf " + i.getLocation().getShelf() + ", Position " + i.getLocation().getPosition());
                }
            }
        }

        return result;
    }


    public List<InventoryItem> findAllByCategory(Category category) {
        List<InventoryItem> all = findAll();
        List<InventoryItem> items = new ArrayList<>();

        for (InventoryItem item : all) {
            if (item.getCategory() == category) {
                items.add(item);
            }
        }

        return items;

    }

    public InventoryItem addItemToLibrary(InventoryItem item) {
        return repository.add(item);
    }

    public void update(InventoryItem item) {
        this.repository.update(item);
    }

    public void delete(InventoryItem item) {
        this.repository.deleteByIsbn(item.getIsbn());
    }

}
