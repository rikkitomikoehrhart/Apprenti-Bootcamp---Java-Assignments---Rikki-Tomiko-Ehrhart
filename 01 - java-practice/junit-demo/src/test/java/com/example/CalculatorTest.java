package com.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @Test
    @DisplayName("Test adding two numbers")
    void testAdd() {
        // Arrange, Act, Assert
        // Arrange: Set up the data for the test
        // Act: Invoke the test code (method)
        // Assert: Check that the value we get back is expected

        // When running a test you will have an expected value
        // vs an actual value
        int actual = calc.add(2, 2);
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test of subtracting two numbers")
    void testSubtract() {
        assertEquals(2, calc.subtract(5, 3));
    }

    @Test
    @DisplayName("Test of divide by zero error")
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> calc.divide(10, 0));
    }

    @Test
    @DisplayName("Check array values")
    void arraySample() {
        List<Integer> nums = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> results = Arrays.asList(1, 9, 25, 49, 81);

        App.square(nums);
        assertIterableEquals(results, nums);
    }
}
