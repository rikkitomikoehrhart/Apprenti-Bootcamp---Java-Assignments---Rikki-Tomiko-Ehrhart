package com.example.Inventory.Manager.data;

import com.example.Inventory.Manager.model.PerishableProduct;
import com.example.Inventory.Manager.model.Product;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InventoryFromFileRepository implements InventoryRepository {
    private List<Product> inventory;
    private String fileName;
    private final String HEADER = "productId,productName,quantity,price,productType,expirationDate";
    private final String CSV_LINE_FORMAT = "%s,%s,%d,%.2f,%s,%s%n";

    public InventoryFromFileRepository(String fileName) {
        this.inventory = loadProduct(fileName);
        this.fileName = fileName;
    }

    @Override
    public void addProduct(Product product) {
        inventory.add(product);
        saveProducts(fileName);
    }

    @Override
    public void removeProduct(Product product) {
        inventory.remove(product);
        saveProducts(fileName);
    }

    @Override
    public Product findProductById(String id) {
        for (Product product : inventory) {
            if (product.getProductID().equals(id)){
                return product;
            }
        }
        return null;
    }

    @Override
    public Product findProductByName(String name) {
        for (Product product : inventory) {
            if (product.getProductName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> loadProduct(String fileName) {
        List<Product> fromFile = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Product product = null;

                if (parts[4].equals("PerishableProduct")) {
                    product = createNewPerishableProduct(parts);
                } else {
                    // For when there are additional types of products
                }

                fromFile.add(product);
            }
        } catch (IOException e) {
            return null;
        }

        return fromFile;
    }

    @Override
    public boolean saveProducts(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println(HEADER);
            for (Product product : inventory) {
                if (product.getClass().getSimpleName().equals("PerishableProduct")) {
                    PerishableProduct perishable = (PerishableProduct) product;
                    writer.printf(CSV_LINE_FORMAT, perishable.getProductID(), perishable.getProductName(), perishable.getQuantity(), perishable.getPrice(), perishable.getClass().getSimpleName(), perishable.getExpirationDate());
                } else {
                    writer.printf(CSV_LINE_FORMAT, product.getProductID(), product.getProductName(), product.getQuantity(), product.getPrice(), product.getClass().getSimpleName(), "");
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public List<Product> getAllInventory() {
        return inventory;
    }

    public PerishableProduct createNewPerishableProduct(String[] parts) {
        String id = parts[0];
        String name = parts[1];
        int quantity = Integer.parseInt(parts[2]);
        BigDecimal price = BigDecimal.valueOf(Long.parseLong(parts[3]));
        LocalDate expirationDate = LocalDate.parse(parts[5]);

        return new PerishableProduct(id, name, quantity, price, expirationDate);
    }
}
