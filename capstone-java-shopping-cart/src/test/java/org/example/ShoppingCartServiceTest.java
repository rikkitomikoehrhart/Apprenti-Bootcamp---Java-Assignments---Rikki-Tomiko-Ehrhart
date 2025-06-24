package org.example;

import org.example.model.Item;
import org.example.model.ShoppingCart;
import org.example.service.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;


public class ShoppingCartServiceTest {
    private CartService cartService;
    private Item testItem1, testItem2;
    private ShoppingCart shoppingCart;

    @BeforeEach
    void setUp() {
        cartService = new CartService();
        shoppingCart = cartService.getShoppingCart();

        testItem1 = new Item();
        testItem1.setAll("Computer", BigDecimal.valueOf(1000.00), "MACBOOK");

        testItem2 = new Item();
        testItem2.setAll("Tablet", BigDecimal.valueOf(600.00), "IPAD");

        cartService.addOrUpdateItem(testItem1, 1);
    }

    // Item.java Tests
    @Test
    @DisplayName("Item gets() all return the correct information")
    void itemGetsReturnsCorrectInfo() {
        assertEquals("Computer", testItem1.getName());
        assertEquals(BigDecimal.valueOf(1000.00).setScale(2, RoundingMode.HALF_EVEN), testItem1.getPrice());
        assertEquals("MACBOOK", testItem1.getSKU());
    }


    @Test
    @DisplayName("Item setsAll() correctly sets")
    void itemSetsAllCorrectlySetsAllInfo() {
        testItem1.setAll("Desktop", BigDecimal.valueOf(999.99), "DELL");
        assertEquals("Desktop", testItem1.getName());
        assertEquals(BigDecimal.valueOf(999.99).setScale(2, RoundingMode.HALF_EVEN), testItem1.getPrice());
        assertEquals("DELL", testItem1.getSKU());
    }


    // ShoppingCart.java Tests
    @Test
    @DisplayName("Item addItem() adds an item to the cart")
    void addItemsToTheCartFromShoppingCart() {
        shoppingCart.addItem(testItem2, 1);

        assertEquals(2, shoppingCart.getItems().size());
    }


    @Test
    @DisplayName("Item removeItem() removes item from the cart")
    void removeItemsFromShoppingCart() {
        shoppingCart.removeItem(testItem1);

        assertEquals(0, shoppingCart.getItems().size());
    }


    @Test
    @DisplayName("empty() clears the cart hashmap")
    void emptyClearsTheCartFromTheShoppingCart() {
        shoppingCart.empty();

        assertEquals(0, shoppingCart.getItems().size());
    }


    @Test
    @DisplayName("getQuantity() returns the quantity of the item from ShoppingCart")
    void getQuantityReturnsQuantityFromShoppingCart() {
        assertEquals(1, shoppingCart.getQuantity(testItem1));
    }


    @Test
    @DisplayName("isEmpty returns false for cart with items in it")
    void isEmptyReturnsFalse() {
        assertEquals(false, shoppingCart.isEmpty());
    }

    @Test
    @DisplayName("isEmpty returns true for cart with no items in it")
    void isEmptyReturnsTrue() {
        shoppingCart.removeItem(testItem1);

        assertEquals(true, shoppingCart.isEmpty());
    }


    @Test
    @DisplayName("getTotal() returns total rounded to 2 places after the decimal place")
    void getTotalReturnsTotalRoundedToTwoPlacesAfterTheDecimal() {
        assertEquals(BigDecimal.valueOf(1000.00).setScale(2, RoundingMode.HALF_EVEN), shoppingCart.getTotal());
    }

    @Test
    @DisplayName("calculateTotal() adds the cost of each item times its quantity to the total")
    void calculateTotalAddsUpAllTheItemsTimesItsQuantity(){
        BigDecimal expected = new BigDecimal(2200.00).setScale(2, RoundingMode.HALF_EVEN);

        shoppingCart.addItem(testItem2, 2);

        BigDecimal actual = shoppingCart.getTotal();

        assertEquals(expected, actual);
    }



    // CartService.java Tests
    @Test
    @DisplayName("addOrUpdateItem() Add Item to Cart")
    public void addOrUpdateItemAddItems() {
        cartService.addOrUpdateItem(testItem2, 1);

        int expected = 2;
        int actual = shoppingCart.getItems().size();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("addOrUpdateItem() Update item quantity")
    public void addOrUpdateItemUpdateItem() {
        int expected = 10;
        cartService.addOrUpdateItem(testItem1, expected);

        int actual = shoppingCart.getQuantity(testItem1);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("addOrUpdateItem() remove item if quantity is zero")
    void addOrUpdateItemRemoveItemIfQuantityIsZero() {
        cartService.addOrUpdateItem(testItem1, 0);

        assertEquals(0, shoppingCart.getItems().size());
    }


    @Test
    @DisplayName("getItemQuantity() returns the item quantity from CartServices")
    void getItemQuantityFromCartServices() {
        assertEquals(1, cartService.getItemQuantity(testItem1));
    }


    @Test
    @DisplayName("getItemFromCart() returns an item based on the name")
    void getItemFromCartReturnsAnItem() {
        assertEquals(testItem1, cartService.getItemFromCart("Computer"));
    }


    @Test
    @DisplayName("getTotalForDisplay() displays the total in a string with a dollar sign and as money")
    void getTotalForDisplayDisplaysTheTotalAsAMoneyString() {
        assertEquals("$1000.00", cartService.getTotalForDisplay());
    }



}
