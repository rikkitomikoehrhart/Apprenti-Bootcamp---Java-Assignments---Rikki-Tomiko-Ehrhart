package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxCalculatorTest {

    @Test
    public void testCalculateTaxForTaxableStateHappyPath() {
        // ARRANGE
        TaxCalculator tc = new TaxCalculator();
        BigDecimal subtotal = new BigDecimal(20.00);
        double taxRate = .1d;
        TaxCalculator.STATE_TYPE stateType = TaxCalculator.STATE_TYPE.TAX_FOR_FOOD;
        BigDecimal expected = new BigDecimal(2.00).setScale(2, RoundingMode.HALF_UP);

        // ACT
        BigDecimal actual = tc.calculateTax(subtotal, taxRate, stateType);

        // ASSERT
        assertEquals(expected, actual);
    }
}
