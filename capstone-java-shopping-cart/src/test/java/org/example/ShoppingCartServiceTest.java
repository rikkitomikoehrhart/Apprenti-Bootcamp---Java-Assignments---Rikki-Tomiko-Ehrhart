package org.example;

import org.example.model.Item;
import org.example.model.ShoppingCart;
import org.example.service.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;


public class ShoppingCartServiceTest {
    private CartService cartService;
    private Item testItem1, testItem2;
    private ShoppingCart shoppingCart;
    private HashMap<Item, Integer> cart;

    @BeforeEach
    void setUp() {
        cartService = new CartService();
        shoppingCart = cartService.getShoppingCart();
        cart = shoppingCart.getCart();

        testItem1 = new Item();
        testItem1.setAll("Computer", BigDecimal.valueOf(1000.00), "MACBOOK");

        testItem2 = new Item();
        testItem2.setAll("Tablet", BigDecimal.valueOf(600.00), "IPAD");

        cartService.addOrUpdateItem(testItem1, 1);
        cartService.processTotal();
    }

    // Item.java Tests
    @Test
    @DisplayName("Item Gets all return the correct information")
    void itemGetsReturnsCorrectInfo() {
        assertEquals("Computer", testItem1.getName());
        assertEquals(BigDecimal.valueOf(1000.00).setScale(2, RoundingMode.HALF_EVEN), testItem1.getPrice());
        assertEquals("MACBOOK", testItem1.getSKU());
    }


    @Test
    @DisplayName("Item Sets All correctly sets")
    void itemSetsAllCorrectlySetsAllInfo() {
        testItem1.setAll("Desktop", BigDecimal.valueOf(999.99), "DELL");
        assertEquals("Desktop", testItem1.getName());
        assertEquals(BigDecimal.valueOf(999.99).setScale(2, RoundingMode.HALF_EVEN), testItem1.getPrice());
        assertEquals("DELL", testItem1.getSKU());
    }


    // ShoppingCart.java Tests
    @Test
    @DisplayName("Displays BigDecimal as Currency")
    public void displaysBigDecimalAsCurrency() {
        String actual = cartService.getTotalForDisplay();

        assertEquals("$1000.00", actual);
    }

    @Test
    @DisplayName("Processing Total updates the total variable and display total displays it as a dollar string")
    void processingTotalCorrectlyUpdatesTheTotalCostAndDisplayTotalDisplaysAsADollarString() {
        cartService.processTotal();
        assertEquals("$1000.00", cartService.getTotalForDisplay());

    }


    // CartService.java Tests
    @Test
    @DisplayName("Add Item to Cart")
    public void addingItemsToCartWithAddOrUpdateItem() {
        cartService.addOrUpdateItem(testItem2, 1);

        int expected = 2;
        int actual = cart.size();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Update item quantity")
    public void updateItemQuantityWithAddOrUpdateItem() {
        int expected = 10;
        cartService.addOrUpdateItem(testItem1, expected);

        int actual = cart.get(testItem1);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Remove Items")
    public void removeItems() {
        cartService.removeItem(testItem1);
        int expected = 0;
        int actual = cart.size();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Empty Cart")
    public void emptyCart() {
        cartService.addOrUpdateItem(testItem2, 2);

        cartService.emptyCart();

        int expected = 0;
        int actual = cart.size();

        assertEquals(expected, actual);
    }



}
