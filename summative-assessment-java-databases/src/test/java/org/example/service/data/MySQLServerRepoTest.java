package org.example.service.data;

import org.example.data.impl.MySQLServerRepo;
import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.model.Server;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MySQLServerRepoTest {
    private DriverManagerDataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MySQLServerRepo serverRepo;

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

        serverRepo = new MySQLServerRepo(jdbcTemplate);
    }

    @Test
    @DisplayName("Get Server By Id")
    public void getServerById() throws InternalErrorException, RecordNotFoundException {
        Server server = serverRepo.getServerById(1);

        assertEquals(1, server.getServerID());
    }

    @Test
    @DisplayName("Get all Available Servers")
    public void getAllAvailableServers() throws InternalErrorException {
        List<Server> servers = serverRepo.getAllAvailableServers(LocalDate.of(2020, 01, 01));

        assertTrue(servers.size() > 0);
    }

}
