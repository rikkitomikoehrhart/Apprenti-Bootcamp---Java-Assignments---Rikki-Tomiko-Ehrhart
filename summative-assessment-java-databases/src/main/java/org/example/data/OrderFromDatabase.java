package org.example.data;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.security.Key;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class OrderFromDatabase implements OrderRepo {
    private final JdbcTemplate jdbcTemplate;

    public OrderFromDatabase(@Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Order getOrderById(int id) throws RecordNotFoundException, InternalErrorException {
        String sql = "SELECT o.OrderID, o.ServerID, o.OrderDate, o.SubTotal, o.Tax, o.Tip, o.Total, s.FirstName, s.LastName, s.HireDate, s.TermDate FROM `Order` o INNER JOIN `Server` s ON o.ServerID = s.ServerID WHERE o.OrderID = ?;";

        try {
            return jdbcTemplate.queryForObject(sql, orderRowMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            throw new RecordNotFoundException("Order not found with ID: " + id);
        }
    }

    @Override
    public List<Order> getAllOrders() throws InternalErrorException, RecordNotFoundException {
        String sql = "SELECT o.OrderID, o.ServerID, o.OrderDate, o.SubTotal, o.Tax, o.Tip, o.Total, s.FirstName, s.LastName, s.HireDate, s.TermDate FROM `Order` o INNER JOIN `Server` s ON o.ServerID = s.ServerID;";

        return jdbcTemplate.query(sql, orderRowMapper());
    }

    @Override
    public Order addOrder(Order order) throws InternalErrorException {
        String sql = "INSERT INTO `Order` (ServerID, OrderDate, SubTotal, Tax, Tip, Total) VALUES (?, ?, ?, ?, ?, ?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, order.getServerID());
            ps.setDate(2, Date.valueOf(order.getOrderDate().toLocalDate()));
            ps.setBigDecimal(3, order.getSubTotal());
            ps.setBigDecimal(4, order.getTax());
            ps.setBigDecimal(5, order.getTip());
            ps.setBigDecimal(6, order.getTotal());

            return ps;
        }, keyHolder);

        order.setOrderID(keyHolder.getKey().intValue());

        for (OrderItem item : order.getItems()) {
            item.setOrderID(order.getOrderID());

            item = addOrderItem(item);
        }

        for (Payment payment : order.getPayments()) {
            payment.setOrderID(order.getOrderID());

            payment = addPayment(payment);
        }


        return order;
    }

    public OrderItem addOrderItem(OrderItem item) throws InternalErrorException {
        String sql = "INSERT INTO OrderItem (OrderID, ItemID, Quantity, Price) VALUES (?, ?, ?, ?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, item.getOrderID());
            ps.setInt(2, item.getItemID());
            ps.setInt(3, item.getQuantity());
            ps.setBigDecimal(4, item.getPrice());

            return ps;
        }, keyHolder);

        item.setOrderItemID(keyHolder.getKey().intValue());

        return item;
    }

    public Payment addPayment(Payment payment) throws InternalErrorException {
        String sql = "INSERT INTO Payment (PaymentTypeID, OrderID, Amount) VALUES (?, ?, ?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, payment.getPaymentTypeID());
            ps.setInt(2, payment.getOrderID());
            ps.setBigDecimal(3, payment.getAmount());

            return ps;
        }, keyHolder);

        payment.setPaymentID(keyHolder.getKey().intValue());

        return payment;
    }


    @Override
    public void updateOrder(Order order) throws InternalErrorException {
        String sql = "UPDATE `Order` SET ServerID = ?, OrderDate = ?, SubTotal = ?, Tax = ?, Tip = ?, Total = ?";

        try {
            int rowsAffected = jdbcTemplate.update(sql,
                    order.getServerID(),
                    order.getOrderDate(),
                    order.getSubTotal(),
                    order.getTax(),
                    order.getTip(),
                    order.getTotal()
            );

            if (rowsAffected == 0) {
                throw new RuntimeException("Order with ID " + order.getOrderID() + " is not found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order deleteOrder(int id) throws InternalErrorException {
        String sql1 = "DELETE FROM OrderItem WHERE OrderID = ?";
        jdbcTemplate.update(sql1, id);

        String sql2 = "DELETE FROM Payment WHERE OrderID = ?";
        jdbcTemplate.update(sql2, id);

        String sql3 = "DELETE FROM `Order` WHERE OrderID = ?;";
        Order order;

        try {
            order = getOrderById(id);
        } catch (RecordNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            int rowsAffected = jdbcTemplate.update(sql3, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return order;
    }


    private RowMapper<Order> orderRowMapper() {
        return (rs, rowNum) -> {
            Order order = new Order();

            order.setOrderID(rs.getInt("OrderID"));
            order.setServerID(rs.getInt("ServerID"));
            order.setOrderDate(rs.getObject("OrderDate", LocalDateTime.class));
            order.setSubTotal(rs.getBigDecimal("SubTotal"));
            order.setTax(rs.getBigDecimal("Tax"));
            order.setTip(rs.getBigDecimal("Tip"));
            order.setTotal(rs.getBigDecimal("Total"));


            Server server = new Server();

            server.setServerID(order.getServerID());
            server.setFirstName(rs.getString("FirstName"));
            server.setLastName(rs.getString("LastName"));
            server.setHireDate(rs.getObject("HireDate", LocalDate.class));
            server.setTermDate(rs.getObject("TermDate", LocalDate.class));


            order.setServer(server);

            try {
                order.setItems(getAllOrderItemsByOrderID(order.getOrderID()));
            } catch (Exception e) {
                order.setItems(null);
            }


            try {
                order.setPayments(getAllPaymentsByOrderID(order.getOrderID()));
            } catch (Exception e) {
                order.setPayments(null);
            }

            return order;
        };

    }

    public List<OrderItem> getAllOrderItemsByOrderID(int orderID) throws InternalErrorException, RecordNotFoundException {
        String sql = "SELECT * FROM OrderItem INNER JOIN Item ON OrderItem.ItemID = Item.ItemID WHERE OrderID = ?";
        return jdbcTemplate.query(sql, orderItemRowMapper(), orderID);

    }

    private RowMapper<OrderItem> orderItemRowMapper() {
        return (rs, rowNun) -> {
            OrderItem orderItem = new OrderItem();

            orderItem.setOrderItemID(rs.getInt("OrderItemID"));
            orderItem.setOrderID(rs.getInt("OrderID"));
            orderItem.setItemID(rs.getInt("ItemID"));
            orderItem.setQuantity(rs.getInt("Quantity"));
            orderItem.setPrice(rs.getBigDecimal("Price"));


            Item item = new Item();

            item.setItemID(orderItem.getItemID());
            item.setItemCategoryID(rs.getInt("ItemCategoryID"));
            item.setItemName(rs.getString("ItemName"));
            item.setItemDescription(rs.getString("ItemDescription"));
            item.setStartDate(rs.getObject("StartDate", LocalDate.class));
            item.setEndDate(rs.getObject("EndDate", LocalDate.class));
            item.setUnitPrice(rs.getBigDecimal("UnitPrice"));

            orderItem.setItem(item);

            return orderItem;
        };
    }

    public List<Payment> getAllPaymentsByOrderID(int orderID) throws InternalErrorException, RecordNotFoundException {
        String sql = "SELECT p.PaymentID, p.OrderID, p.Amount, pt.PaymentTypeID, pt.PaymentTypeName FROM Payment p INNER JOIN PaymentType pt ON p.PaymentTypeID = pt.PaymentTypeID WHERE OrderID = ?";
        return jdbcTemplate.query(sql, paymentRowMapper(), orderID);

    }

    private RowMapper<Payment> paymentRowMapper() {
        return (rs, rowNun) -> {
            Payment payment = new Payment();

            payment.setPaymentID(rs.getInt("PaymentID"));
            payment.setPaymentTypeID(rs.getInt("PaymentTypeID"));
            payment.setOrderID(rs.getInt("OrderID"));
            payment.setAmount(rs.getBigDecimal("Amount"));

            PaymentType paymentType = new PaymentType();
            paymentType.setPaymentTypeID(payment.getPaymentTypeID());
            paymentType.setPaymentTypeName(rs.getString("PaymentTypeName"));

            payment.setPaymentType(paymentType);

            return payment;
        };
    }
}

