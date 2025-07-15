package com.example.Inventory.Manager.service;


import com.example.Inventory.Manager.model.CartItem;
import com.example.Inventory.Manager.model.InventoryItem;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    List<CartItem> cart;
    private ProductService productService;

    public CartService() {
        cart = new ArrayList<>();
        this.productService = new ProductService();
    }

    public void addToCart(InventoryItem item, int quantity) {
        cart.add(new CartItem(item, quantity));
    }

    public void removeFromCart(CartItem item) {
        cart.remove(item);
    }

    public List<CartItem> getCart() {
        return cart;
    }


    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;

        if (!cart.isEmpty()) {
            for (CartItem item : cart) {
                total = total.add(item.getSubTotal());
            }
        }

        return total;
    }

    public void updateSubTotal(CartItem item) {
        productService.updateSubtotal(item);
    }

}
