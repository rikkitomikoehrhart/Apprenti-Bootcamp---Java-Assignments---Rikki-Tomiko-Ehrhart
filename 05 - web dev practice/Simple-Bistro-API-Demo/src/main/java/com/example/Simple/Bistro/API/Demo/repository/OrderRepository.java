package com.example.Simple.Bistro.API.Demo.repository;

import com.example.Simple.Bistro.API.Demo.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    List<Order> findAll();
    Optional<Order> findById();
    Order save(Order order);
    Order update(Order order);
    boolean deleteById(Integer id);
}
