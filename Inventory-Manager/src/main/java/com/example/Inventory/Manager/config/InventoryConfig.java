package com.example.Inventory.Manager.config;

import com.example.Inventory.Manager.repository.InventoryFromFileRepository;
import com.example.Inventory.Manager.repository.InventoryRepository;
import com.example.Inventory.Manager.repository.InventorySampleDataRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryConfig {

    @Value("${inventory.repository.type:memory}")
    private String repositoryType;

    @Value("${inventory.csv.filepath:data/inventory.csv")
    private String fileName;

    @Bean
    public InventoryRepository inventoryRepository() {
        switch (repositoryType.toLowerCase()) {
            case "csv":
                return new InventoryFromFileRepository(fileName);
            case "memory":
                return new InventorySampleDataRepository("");
            default:
                throw new IllegalArgumentException("Invalid repository type: " + repositoryType + ". Supported types are: `csv` and `memory`");
        }
    }

}
