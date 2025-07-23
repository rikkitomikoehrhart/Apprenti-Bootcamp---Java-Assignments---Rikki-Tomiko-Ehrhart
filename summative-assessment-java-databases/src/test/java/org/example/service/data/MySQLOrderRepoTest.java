package org.example.service.data;

import org.example.data.impl.MySQLOrderRepo;
import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MySQLOrderRepoTest {
    private DriverManagerDataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MySQLOrderRepo orderRepo;

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

        orderRepo = new MySQLOrderRepo(jdbcTemplate);
    }

    @Test
    @DisplayName("Get List of All order Items by OrderID")
    public void getAllOrderItemsByOrderId() throws InternalErrorException, RecordNotFoundException {
        List<OrderItem> orderItemList = orderRepo.getAllOrderItemsByOrderID(1);

        assertTrue(orderItemList.size() > 0);
    }

    @Test
    @DisplayName("Get List of All payments by OrderID")
    public void getAllPaymentsByOrderId() throws InternalErrorException, RecordNotFoundException {
        List<Payment> payments = orderRepo.getAllPaymentsByOrderID(1);

        assertTrue(payments.size() > 0);
    }

    @Test
    @DisplayName("Get an order by OrderID")
    public void getOrderById() throws RecordNotFoundException, InternalErrorException {
        Order order = orderRepo.getOrderById(1);

        assertEquals(1, order.getOrderID());
    }

    @Test
    @DisplayName("Get List of All Orders")
    public void getAllOrders() throws RecordNotFoundException, InternalErrorException {
        List<Order> orders = orderRepo.getAllOrders();

        assertTrue(orders.size() > 0);
    }

    @Test
    @DisplayName("Add new Order")
    public void addOrder() throws InternalErrorException, RecordNotFoundException {
        Order order = new Order();
        order.setServerID(8);
        order.setOrderDate(LocalDateTime.now());
        order.setSubTotal(BigDecimal.valueOf(32.00));
        order.setTax(BigDecimal.TWO);
        order.setTip(BigDecimal.valueOf(4.80));
        order.setTotal(BigDecimal.valueOf(38.80));

        Server server = new Server();
        server.setServerID(8);
        server.setFirstName("Orelee");
        server.setLastName("Mabbs");
        server.setHireDate(LocalDate.of(2020,01,01));
        server.setTermDate(LocalDate.of(2022, 05, 11));

        order.setServer(server);

        OrderItem a = new OrderItem();
        a.setOrderID(352);
        a.setItemID(27);
        a.setQuantity(1);
        a.setPrice(BigDecimal.valueOf(7.00));
        a.setItem(new Item());

        OrderItem b = new OrderItem();
        b.setOrderID(550);
        b.setItemID(19);
        b.setQuantity(1);
        b.setPrice(BigDecimal.valueOf(14.00));
        b.setItem(new Item());

        OrderItem c = new OrderItem();
        c.setOrderID(559);
        c.setItemID(20);
        c.setQuantity(1);
        c.setPrice(BigDecimal.valueOf(11.00));
        c.setItem(new Item());

        List<OrderItem> items = new ArrayList<>();
        items.add(a);
        items.add(b);
        items.add(c);

        order.setItems(items);

        Payment payment = new Payment();
        payment.setPaymentTypeID(1);
        payment.setAmount(BigDecimal.valueOf(38.80));

        List<Payment> payments = new ArrayList<>();
        payments.add(payment);

        order.setPayments(payments);



        order = orderRepo.addOrder(order);

        assertNotNull(order.getOrderID());

        assertEquals(order.getOrderID(), orderRepo.getOrderById(order.getOrderID()).getOrderID());

    }

    @Test
    @DisplayName("Update Order")
    public void updateOrder() throws RecordNotFoundException, InternalErrorException {
        Order order = orderRepo.getOrderById(1);
        BigDecimal originalTip = order.getTip();
        order.setTip(BigDecimal.valueOf(5.0));
        BigDecimal newTip = order.getTip();

        assertEquals(originalTip.setScale(2), orderRepo.getOrderById(1).getTip().setScale(2));

        orderRepo.updateOrder(order);

        assertEquals(newTip.setScale(2), orderRepo.getOrderById(1).getTip().setScale(2));

    }

    @Test
    @DisplayName("Delete Order")
    public void deleteOrder() throws InternalErrorException, RecordNotFoundException {
        orderRepo.deleteOrder(1);

        List<Order> orders = orderRepo.getAllOrders();

        assertNotEquals(1, orders.get(0).getOrderID());
    }

}
