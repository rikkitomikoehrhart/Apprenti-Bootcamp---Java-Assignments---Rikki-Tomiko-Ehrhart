package com.example.Inventory.Manager.repository;

import com.example.Inventory.Manager.model.InventoryItem;
import com.example.Inventory.Manager.model.PerishableProduct;
import com.example.Inventory.Manager.model.Product;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class InventoryFromFileRepository implements InventoryRepository {
    private final List<InventoryItem> inventory;
    private final String fileName;
    private final String HEADER = "productId,productName,quantity,price,productType,expirationDate";
    private final String CSV_LINE_FORMAT = "%s,%s,%d,%.2f,%s,%s%n";

    public InventoryFromFileRepository(String fileName) {
        this.inventory = loadProduct(fileName);
        this.fileName = fileName;
    }

    @Override
    public void addProduct(InventoryItem product) {
        inventory.add(product);
        saveProducts();
    }

    @Override
    public void removeProduct(InventoryItem product) {
        inventory.remove(product);
        saveProducts();
    }

    @Override
    public List<InventoryItem> findProductById(String id) {
        List<InventoryItem> found = new ArrayList<>();

        for (InventoryItem product : inventory) {
            if (product.getProduct().getProductID().equals(id)){
                found.add(product);
            }
        }
        return found;
    }

    @Override
    public List<InventoryItem> findProductByName(String name) {
        List<InventoryItem> found = new ArrayList<>();

        for (InventoryItem product : inventory) {
            if (product.getProduct().getProductName().equals(name)) {
                found.add(product);
            }
        }
        return found;
    }

    @Override
    public List<InventoryItem> loadProduct(String fileName) {
        List<InventoryItem> fromFile = new ArrayList<>();
        File csvFile = new File(fileName);

        if (!csvFile.exists()) {
            return fromFile;
        }


        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            boolean isFirstLine = true;

            while((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] parts = line.split(",");
                InventoryItem product = null;

                if (parts[4].equals("PerishableProduct")) {
                    product = createNewPerishableProduct(parts);
                } else {
                    // For when there are additional types of products
                }

                fromFile.add(product);
            }
        } catch (IOException | NullPointerException e) {
            return fromFile;
        }

        return fromFile;
    }

    @Override
    public boolean saveProducts() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println(HEADER);
            for (InventoryItem product : inventory) {
                if (product.getProduct().getClass().getSimpleName().equals("PerishableProduct")) {
                    PerishableProduct perishable = (PerishableProduct) product.getProduct();
                    writer.printf(CSV_LINE_FORMAT, product.getProduct().getProductID(), product.getProduct().getProductName(), product.getQuantity(), product.getPrice(), product.getProduct().getClass().getSimpleName(), perishable.getExpirationDate());
                } else {
                    writer.printf(CSV_LINE_FORMAT, product.getProduct().getProductID(), product.getProduct().getProductName(), product.getQuantity(), product.getPrice(), product.getClass().getSimpleName(), "");
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public List<InventoryItem> getAllInventory() {
        return inventory;
    }

    public InventoryItem createNewPerishableProduct(String[] parts) {
        String id = parts[0];
        String name = parts[1];
        int quantity = Integer.parseInt(parts[2]);
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(parts[3]));
        LocalDate expirationDate = LocalDate.parse(parts[5]);

        return new InventoryItem(new PerishableProduct(new Product(id, name), expirationDate), quantity, price);
    }


    @Override
    public void update(InventoryItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }

        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getProduct().getProductID().equals(item.getProduct().getProductID())) {
                inventory.set(i, item);
            }
        }

        saveProducts();
    }

    @Override
    public List<InventoryItem> getInStock() {
        return inventory.stream().filter(item -> item.getQuantity() > 0).collect(Collectors.toList());
    }

}
