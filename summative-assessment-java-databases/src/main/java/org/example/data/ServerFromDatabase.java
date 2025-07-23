package org.example.data;

import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.model.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ServerFromDatabase implements ServerRepo {
    private final JdbcTemplate jdbcTemplate;

    public ServerFromDatabase(@Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public Server getServerById(int id) throws InternalErrorException, RecordNotFoundException {
        String sql = "SELECT * FROM Server WHERE ServerID = ?;";
        return jdbcTemplate.queryForObject(sql, serverRowMapper(), id);
    }

    @Override
    public List<Server> getAllAvailableServers(LocalDate date) throws InternalErrorException {
        String sql = "SELECT * FROM Server WHERE HireDate <= ? AND (TermDate >= ? OR TermDate IS NULL);";
        return jdbcTemplate.query(sql, serverRowMapper(), date, date);
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
