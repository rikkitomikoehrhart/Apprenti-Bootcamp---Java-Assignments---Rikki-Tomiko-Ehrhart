package org.example;

import org.example.model.Item;
import org.example.service.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


public class ShoppingCartServiceTest {
    private CartService cartService;
    private Item testItem1, testItem2;

    @BeforeEach
    void setUp() {
        cartService = new CartService();

        testItem1 = new Item();
        testItem1.setName("Computer");
        testItem1.setPrice(BigDecimal.valueOf(1000.00));
        testItem1.setSKU("MACBOOK");

        testItem2 = new Item();
        testItem2.setName("Tablet");
        testItem2.setPrice(BigDecimal.valueOf(600.00));
        testItem2.setSKU("IPAD");

        cartService.addOrUpdateItem(testItem1, 1);
        cartService.shoppingCart.processTotal();
    }



    @Test
    @DisplayName("Displays BigDecimal as Currency")
    public void displaysBigDecimalAsCurrency() {
        String expected = "$1000.00";
        String actual = cartService.shoppingCart.getTotalForDisplay();

        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("Add Item to Cart")
    public void addingItemsToCart() {


        cartService.addOrUpdateItem(testItem2, 1);

        int expected = 2;
        int actual = cartService.shoppingCart.cart.size();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Update item quantity")
    public void updateItemQuantity() {
        int expected = 10;
        cartService.addOrUpdateItem(testItem1, expected);

        int actual = cartService.shoppingCart.cart.get(testItem1);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Remove Items")
    public void removeItems() {
        cartService.removeItem(testItem1);
        int expected = 0;
        int actual = cartService.shoppingCart.cart.size();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Empty Cart")
    public void emptyCart() {
        cartService.addOrUpdateItem(testItem2, 2);

        cartService.emptyCart();

        int expected = 0;
        int actual = cartService.shoppingCart.cart.size();

        assertEquals(expected, actual);
    }



}
