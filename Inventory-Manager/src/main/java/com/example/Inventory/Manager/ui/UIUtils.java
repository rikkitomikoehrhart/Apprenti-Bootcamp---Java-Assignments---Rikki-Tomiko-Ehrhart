package com.example.Inventory.Manager.ui;



import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class UIUtils {
    Scanner scanner = new Scanner(System.in);

    public void println(Object value) {
        System.out.println(value);
    }

    public void print(Object value) {
        System.out.print(value);
    }

    public void printf(String format, Object... values) {
        System.out.printf(format, values);
    }

    public void printError(String message) {
        println("  ✗   ERROR: " + message);
    }

    public String readString(String prompt) {
        print(prompt);
        return scanner.nextLine();
    }

    public int readInt(String prompt) {
        while (true) {
            String value = readString(prompt);
            try {
                int result = Integer.parseInt(value);
                return result;
            } catch (NumberFormatException e) {
                printError(value + " is not a valid number");
            }
        }
    }

    public Object convertToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public BigDecimal readBigDecimal(String prompt) {
        while (true) {
            String value = readString(prompt);

            try {
                return BigDecimal.valueOf(Double.parseDouble(value));
            } catch (NumberFormatException e) {
                printError(value + " is not a valid number");
            }
        }
    }

    public BigDecimal convertToBigDecimal(String number) {
        try {
            return BigDecimal.valueOf(Long.parseLong(number));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public boolean readBoolean(String prompt) {
        return readString(prompt).trim().equalsIgnoreCase("y");
    }

    public LocalDate readLocalDate(String prompt) {
        while (true) {
            try {
                return LocalDate.parse(readString(prompt));
            } catch (DateTimeParseException ex) {
                printError("Invalid Format. Must be formatted [yyyy-mm-dd].");
            }
        }
    }

    public LocalDate convertToLocalDate(String date) {
        try {
            return LocalDate.parse(date);
        } catch (DateTimeParseException ex) {
            return null;
        }
    }
}
