package org.example.service.data;

import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.data.impl.MySQLItemRepo;
import org.example.model.Item;
import org.example.model.ItemCategory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class MySQLItemRepoTest {
    private DriverManagerDataSource dataSource;
    private JdbcTemplate jdbcTemplate;


    @Autowired
    private MySQLItemRepo itemRepo;



    @BeforeEach
    public void setup() {
        dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/SimpleBistroTest");
        dataSource.setUsername("newuser");
        dataSource.setPassword("Test123!");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "CALL set_known_good_state;";

        jdbcTemplate.update(sql);

        itemRepo = new MySQLItemRepo(jdbcTemplate);
    }

    @Test
    @DisplayName("Can get item by id")
    public void getById() throws RecordNotFoundException, InternalErrorException {
        Item item = itemRepo.getItemById(1);

        assertEquals(1, item.getItemID());
    }

    @Test
    @DisplayName("Get full list of available items from the database")
    public void getAllAvailableItems() throws InternalErrorException {
        List<Item> items = itemRepo.getAllAvailableItems(LocalDate.of(2021, 01, 01));

        assertTrue(items.size() > 0);
    }

    @Test
    @DisplayName("Get full list of available items by category")
    public void getItemsByCategory() throws InternalErrorException {
        List<Item> items = itemRepo.getItemsByCategory(LocalDate.of(2021, 01, 01), 1);

        assertTrue(items.size() > 0);
    }

    @Test
    @DisplayName("Get all Categories from database")
    public void getAllItemCategories() throws InternalErrorException {
        List<ItemCategory> itemCategories = itemRepo.getAllItemCategories();

        assertTrue(itemCategories.size() > 0);
    }




}
