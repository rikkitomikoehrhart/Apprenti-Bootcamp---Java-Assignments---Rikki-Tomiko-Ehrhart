package com.example.Inventory.Manager.service;

import com.example.Inventory.Manager.model.CartItem;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class ProductService {
    public boolean isExpired(LocalDate expirationDate) {
        return LocalDate.now().isAfter(expirationDate);
    }

    public void updateSubtotal(CartItem item) {
        item.setSubTotal(item.getItem().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
    }

}
