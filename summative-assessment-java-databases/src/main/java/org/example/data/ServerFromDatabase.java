package org.example.data;

import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.model.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.time.LocalDate;
import java.util.List;

public class ServerFromDatabase implements ServerRepo {
    private final JdbcTemplate jdbcTemplate;

    public ServerFromDatabase(@Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public Server getServerById(int id) throws InternalErrorException, RecordNotFoundException {
        return null;
    }

    @Override
    public List<Server> getAllAvailableServers(LocalDate date) throws InternalErrorException {
        return List.of();
    }


    private RowMapper<Server> serverRowMapper() {
        return (rs, rowNum) -> {
            Server server = new Server();

            server.setServerID(rs.getInt("ServerID"));
            server.setFirstName(rs.getString("FirstName"));
            server.setLastName(rs.getString("LastName"));
            server.setHireDate(rs.getObject("HireDate", LocalDate.class));
            server.setTermDate(rs.getObject("TermDate", LocalDate.class));

            return server;
        };
    }
}
