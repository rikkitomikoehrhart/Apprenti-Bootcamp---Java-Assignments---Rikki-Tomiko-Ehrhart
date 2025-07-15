package com.example.Inventory.Manager.service;

import com.example.Inventory.Manager.model.CartItem;
import com.example.Inventory.Manager.model.InventoryItem;
import com.example.Inventory.Manager.model.PerishableProduct;
import com.example.Inventory.Manager.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CartServiceTests {
    CartService shoppingCart;
    InventoryItem item1, item2;


    @BeforeEach
    public void setUp() {
        shoppingCart = new CartService();
        item1 = new InventoryItem(new PerishableProduct(new Product("DONUT", "Donut"), LocalDate.of(2025, 7, 8)), 10, BigDecimal.TWO);
        item2 = new InventoryItem(new PerishableProduct(new Product("PASTA", "Pasta"), LocalDate.of(2025, 7, 8)), 10, BigDecimal.TEN);

    }

    @Test
    @DisplayName("New shopping cart is empty")
    public void newCartIsEmpty() {
        assertTrue(shoppingCart.getCart().isEmpty());
    }



    @Test
    @DisplayName("Can add item to cart")
    public void canAddItemsToCart() {
        shoppingCart.addToCart(item1, 1);

        assertTrue(!shoppingCart.getCart().isEmpty());
    }

    @Test
    @DisplayName("Can remove items from cart")
    public void canRemoveItemsFromCart() {
        CartItem cartItem = new CartItem(item1, 1);

        shoppingCart.addToCart(cartItem.getItem(), cartItem.getQuantity());

        assertTrue(!shoppingCart.getCart().isEmpty());

        cartItem = shoppingCart.getCart().get(0);
        shoppingCart.removeFromCart(cartItem);

        assertTrue(shoppingCart.getCart().isEmpty());

    }


    @Test
    @DisplayName("getTotal returns the cart total")
    public void returnTheSumTotalOfBothItemsPriceTimesQuantity() {
        shoppingCart.addToCart(item1, 5);
        shoppingCart.addToCart(item2, 1);

        assertEquals(BigDecimal.valueOf(20), shoppingCart.getTotal());
    }

    @Test
    @DisplayName("updateSubTotal updates the subtotal for the item in question")
    public void changingTheQuantityAndUpdatingTheSubTotal() {
        shoppingCart.addToCart(item1, 1);

        assertEquals(BigDecimal.TWO, shoppingCart.getCart().get(0).getSubTotal());

        shoppingCart.getCart().get(0).setQuantity(5);
        shoppingCart.updateSubTotal(shoppingCart.getCart().get(0));

        assertEquals(BigDecimal.TEN, shoppingCart.getCart().get(0).getSubTotal());
    }

}
