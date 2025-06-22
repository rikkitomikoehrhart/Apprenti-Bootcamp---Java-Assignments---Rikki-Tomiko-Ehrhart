package org.example.service;

import org.example.exception.EmptyInputException;
import org.example.exception.NullInputException;

import java.math.BigDecimal;
import java.util.Scanner;

public class AppService {
    Scanner scanner = new Scanner(System.in);

    public void print(String message) {
        System.out.println(message);
    }

    public String getStringFromUser(String prompt) throws EmptyInputException, NullInputException {
        while (true) {
            print(prompt);
            String entry = scanner.nextLine();

            if (entry == processString(entry)) {
                return entry;
            } else {
                continue;
            }
        }
    }

    public String processString(String string) throws NullInputException, EmptyInputException {
        try {
            if (string == null) {
                throw new NullInputException("You cannot enter nothing");
            } else if (string == "" || string == " ") {
                throw new EmptyInputException("You must enter something.");
            }
        } catch (NullInputException | EmptyInputException e) {
            print(e.getMessage());
            return null;
        }

        return string;
    }


    public int getIntFromUser(String prompt) throws EmptyInputException, NullInputException, NumberFormatException {
        while (true) {
            String entry = getStringFromUser(prompt);

            int number = processInt(entry);

            if (number != -1) {
                return number;
            }
        }
    }

    public int processInt(String string) throws NumberFormatException {
        int number = -1;


        try {
            number = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }

        return number;
    }


    public BigDecimal getBigDecimalFromUser(String prompt) throws EmptyInputException, NullInputException {
        while (true) {
            String string = getStringFromUser(prompt);

            BigDecimal number = processBigDecimal(string);

            if (number != BigDecimal.valueOf(-1.00)) {
                return number;
            }
        }
    }

    public BigDecimal processBigDecimal(String string) throws NumberFormatException {
        BigDecimal number = BigDecimal.valueOf(-1.00);

        try {
            number = BigDecimal.valueOf(Long.parseLong(string));
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }

        return number;
    }

    public void displayCart(String[] stringsForDisplay) {
        for (String string : stringsForDisplay) {
            print(string);
        }
    }


    

}
