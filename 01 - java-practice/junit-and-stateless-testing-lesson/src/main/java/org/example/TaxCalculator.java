package org.example;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxCalculator {
    public enum STATE_TYPE {
        NO_TAX_FOR_FOOD,
        TAX_FOR_FOOD
    }

    public BigDecimal calculateTax(BigDecimal subtotal, double taxRate, STATE_TYPE stateType) {
        if (stateType == STATE_TYPE.TAX_FOR_FOOD) {
            return subtotal.multiply(new BigDecimal(taxRate)).setScale(2, RoundingMode.HALF_UP);
        } else {
            return new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
        }
    }
}
