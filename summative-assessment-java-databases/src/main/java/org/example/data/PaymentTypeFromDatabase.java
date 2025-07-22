package org.example.data;

import org.example.data.exceptions.InternalErrorException;
import org.example.model.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentTypeFromDatabase implements PaymentTypeRepo {
    private final JdbcTemplate jdbcTemplate;

    public PaymentTypeFromDatabase(@Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<PaymentType> getAll() throws InternalErrorException {
        String sql = "SELECT * FROM PaymentType;";
        return jdbcTemplate.query(sql, paymentTypeRowMapper());
    }

    private RowMapper<PaymentType> paymentTypeRowMapper() {
        return (rs, rowNum) -> {
            PaymentType paymentType = new PaymentType();

            paymentType.setPaymentTypeID(rs.getInt("PaymentTypeID"));
            paymentType.setPaymentTypeName(rs.getString("PaymentTypeName"));

            return paymentType;
        };
    }
}
