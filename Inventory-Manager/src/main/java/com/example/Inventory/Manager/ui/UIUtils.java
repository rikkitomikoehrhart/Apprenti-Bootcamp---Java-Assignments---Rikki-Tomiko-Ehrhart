package com.example.Inventory.Manager.ui;

import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;
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
                printf("`%s` is not a valid number", value);
            }
        }
    }

    public BigDecimal readBigDecimal(String prompt) {
        while (true) {
            String value = readString(prompt);

            try {
                return BigDecimal.valueOf(Long.parseLong(value));
            } catch (NumberFormatException e) {
                printError("Must be a valid number");
            }
        }
    }

    public boolean readBoolean(String prompt) {
        return readString(prompt).trim().equalsIgnoreCase("y");
    }

    public LocalDate readLocalDate(String prompt) {
        return LocalDate.parse(readString(prompt));
    }
}
