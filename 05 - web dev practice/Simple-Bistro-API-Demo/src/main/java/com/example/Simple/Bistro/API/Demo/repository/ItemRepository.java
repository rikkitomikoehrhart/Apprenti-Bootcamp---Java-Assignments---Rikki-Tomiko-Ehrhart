package com.example.Simple.Bistro.API.Demo.repository;


import com.example.Simple.Bistro.API.Demo.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    List<Item> findAll();
    Optional<Item> findById(Integer id);
    Item save(Item item);
    Item update(Item item);
    boolean deleteById(Integer id);
}
