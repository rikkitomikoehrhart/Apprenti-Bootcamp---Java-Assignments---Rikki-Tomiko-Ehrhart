package org.example.service.data;

import org.example.data.ItemRepo;
import org.example.service.BistroService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class ItemFromDatabaseTest {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private BistroService service;

    @BeforeEach
    public void setup() {

    }
}
