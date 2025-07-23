package org.example.service.data;

import org.example.data.impl.MySQLTaxRepo;
import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.model.Tax;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class MySQLTaxRepoTest {
    private DriverManagerDataSource dataSource;
    private JdbcTemplate jdbcTemplate;


    @Autowired
    private MySQLTaxRepo taxRepo;

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

        taxRepo = new MySQLTaxRepo(jdbcTemplate);
    }

    @Test
    @DisplayName("Get current tax")
    public void getCurrentTax() throws RecordNotFoundException, InternalErrorException {
        Tax tax = taxRepo.getCurrentTax(LocalDate.now());

        assertEquals(2, tax.getTaxID());
    }
}
