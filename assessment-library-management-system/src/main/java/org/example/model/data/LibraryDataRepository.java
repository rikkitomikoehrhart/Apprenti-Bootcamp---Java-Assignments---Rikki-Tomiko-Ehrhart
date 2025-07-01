package org.example.model.data;

import org.example.model.inventory.InventoryItem;

import java.util.List;

public interface LibraryDataRepository {
    List<InventoryItem> findAll() throws DataAccessException;
    InventoryItem findByISBN(String isbn) throws DataAccessException;
    boolean isbnTaken(String isbn) throws DataAccessException;
    InventoryItem add(InventoryItem item) throws DataAccessException;
    boolean update(InventoryItem item) throws DataAccessException;
    boolean deleteByIsbn(String isbn) throws DataAccessException;
}
