package org.example;

import org.example.model.MenuOption;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;


public class MenuOptionsTest {

    @Test
    @DisplayName("Correct Menu Option is Returned.")
    void correctMenuOptionIsReturned() {
        MenuOption expected = MenuOption.ADD_ITEM;
        MenuOption actual = MenuOption.getMenuOptionFromValue(3);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("String Array of Menu is returned")
    void stringArrayOfMenuItemsIsReturned() {
        String[] expected = new String[] {
                "Main Menu",
                "1. Display Cart",
                "2. Remove an Item",
                "3. Add an Item",
                "4. Checkout",
                "5. Exit"
        };
        String[] actual = MenuOption.getMenuForDisplay();

        assertArrayEquals(expected, actual);
    }


}
