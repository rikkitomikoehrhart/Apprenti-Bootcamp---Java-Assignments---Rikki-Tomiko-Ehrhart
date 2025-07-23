package org.example.data;

import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.model.Tax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.time.LocalDate;

public class TaxFromDatabase implements TaxRepo {
    private final JdbcTemplate jdbcTemplate;

    public TaxFromDatabase(@Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Tax getCurrentTax(LocalDate dateOf) throws InternalErrorException, RecordNotFoundException {
        String sql = "SELECT * FROM Tax WHERE StartDate <= ? AND (EndDate >= ? OR EndDate IS NULL);";
        return jdbcTemplate.queryForObject(sql, taxRowMapper(), dateOf, dateOf);
    }


    private RowMapper<Tax> taxRowMapper() {
        return (rs, rowNum) -> {
          Tax tax = new Tax();

          tax.setTaxID(rs.getInt("TaxID"));
          tax.setTaxPercentage(rs.getBigDecimal("TaxPercentage"));
          tax.setStartDate(rs.getObject("StartDate", LocalDate.class));
          tax.setEndDate(rs.getObject("EndDate", LocalDate.class));

          return tax;
        };
    }
}
