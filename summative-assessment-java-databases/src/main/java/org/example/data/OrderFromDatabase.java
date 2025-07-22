package org.example.data;

import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class OrderFromDatabase implements OrderRepo {
    private final JdbcTemplate jdbcTemplate;

    public OrderFromDatabase(@Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Order getOrderById(int id) throws RecordNotFoundException, InternalErrorException {
        String sql = "SELECT * FROM Order WHERE OrderID = ?;";

        return null;
    }

    @Override
    public List<Order> getAllOrders() throws InternalErrorException, RecordNotFoundException {
        return List.of();
    }

    @Override
    public Order addOrder(Order order) throws InternalErrorException {
        return null;
    }

    @Override
    public void updateOrder(Order order) throws InternalErrorException {

    }

    @Override
    public Order deleteOrder(int id) throws InternalErrorException {
        return null;
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


}

