package org.example.airport.view;

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
}

