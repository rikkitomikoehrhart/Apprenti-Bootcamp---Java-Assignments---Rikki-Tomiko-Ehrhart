package org.example;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal price = new BigDecimal("0.1");
        BigDecimal val1 = BigDecimal.ZERO;
        BigDecimal val2 = BigDecimal.ZERO;
        // Returns an error - number format exception
 //        BigDecimal bad = new BigDecimal("banana");


        try {
            System.out.print("Enter a value: ");
            // preferred way: pass string to constructor
            val1 = new BigDecimal(scanner.nextLine());

            System.out.print("Enter a second value: ");
            val2 = new BigDecimal(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("That is not a valid number");
        }

        // static constructor methods
        BigDecimal zero = BigDecimal.ZERO;

        // Arithmetic
        BigDecimal val3 = val1.add(val2);
        BigDecimal val4 = val1.subtract(val2);
        BigDecimal val5 = val1.multiply(val2);
        BigDecimal val6 = val1.divide(val2, 2, RoundingMode.HALF_UP);

        MathContext mc = new MathContext(2, RoundingMode.HALF_UP);
        BigDecimal val7 = val1. divide(val2, mc);
    }

    public static BigDecimal safeParse(String input) {
        try {
            return new BigDecimal(input);
        } catch (NumberFormatException e) {
            return BigDecimal.ZERO;
        } catch (ArithmeticException e) {
            System.out.println("Divide by zero error");
            return BigDecimal.ZERO;
        }
    }
}
