package org.example.service.data;

import org.example.data.PaymentTypeFromDatabase;
import org.example.data.exceptions.InternalErrorException;
import org.example.model.PaymentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTypeFromDatabaseTest {
    private DriverManagerDataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PaymentTypeFromDatabase paymentTypeRepo;

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

        paymentTypeRepo = new PaymentTypeFromDatabase(jdbcTemplate);
    }


    @Test
    @DisplayName("Get list of all payment types")
    public void getAll() throws InternalErrorException {
        List<PaymentType> paymentTypes = paymentTypeRepo.getAll();

        assertTrue(paymentTypes.size() > 0);
    }

}
