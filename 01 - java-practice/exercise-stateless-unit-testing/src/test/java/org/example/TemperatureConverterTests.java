package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class TemperatureConverterTests {
    private TemperatureConverter temperatureConverter;

    @BeforeEach
    void setUp() {
        temperatureConverter = new TemperatureConverter();
    }

    @Test
    @DisplayName("Celsius to Fahrenheit formula converts correctly")
    void celsiusToFahrenheitFormulaIsCorrect() {
        assertEquals(32, temperatureConverter.celsiusToFahrenheit(0.0));
    }

    @Test
    @DisplayName("Fahrenheit to Celsius formula converts correctly")
    void fahrenheitToCelsiusFormulaIsCorrect() {
        assertEquals(0.0, temperatureConverter.fahrenheitToCelsius(32));
    }

    @Test
    @DisplayName("Celsius to Kelvin formula converts correctly")
    void celsiusToKelvinFormulaIsCorrect() {
        assertEquals(373.15, temperatureConverter.celsiusToKelvin(100));
    }

    @Test
    @DisplayName("Kelvin to Celsius formula converts correctly")
    void kelvinToCelsiusFormulaIsCorrect() {
        assertEquals(-273.15, temperatureConverter.kelvinToCelsius(0));
    }

    @Test
    @DisplayName("Fahrenheit to Kelvin formula converts correctly")
    void fahrenheitToKelvinFormulaIsCorrect() {
        assertEquals(373.15, temperatureConverter.fahrenheitToKelvin(212.0));
    }

    @Test
    @DisplayName("Kelvin to Fahrenheit formula converts correctly")
    void kelvinToFahrenheitFormulaIsCorrect() {
        assertEquals(32, temperatureConverter.kelvinToFahrenheit(273.15));
    }



}
