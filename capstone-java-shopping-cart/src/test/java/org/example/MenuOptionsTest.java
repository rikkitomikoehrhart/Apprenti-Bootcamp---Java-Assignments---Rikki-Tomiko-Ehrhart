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




}
