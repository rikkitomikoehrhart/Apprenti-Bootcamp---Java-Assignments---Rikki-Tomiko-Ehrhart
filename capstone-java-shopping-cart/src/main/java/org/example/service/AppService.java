package org.example.service;

import org.example.exception.*;
import java.math.BigDecimal;
import java.util.Scanner;

public class AppService {
    Scanner scanner = new Scanner(System.in);

    public void println(String message) {
        System.out.println(message);
    }

    public void print(String message) {
        System.out.print(message);
    }

    public String getStringFromUser(String prompt)  {
        while (true) {
            print(prompt);
            String entry = scanner.nextLine();

            if (entry.equals(processString(entry))) {
                return entry;
            }
        }
    }

    public String processString(String string) {
        try {
            if (string == null) {
                throw new NullInputException("You cannot enter nothing");
            } else if (string.isEmpty() || string.equals(" ")) {
                throw new EmptyInputException("You must enter something.");
            }
        } catch (NullInputException | EmptyInputException e) {
            println(e.getMessage());
            return null;
        }

        return string;
    }


    public int getIntFromUser(String prompt) throws NumberFormatException {
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


    public BigDecimal getBigDecimalFromUser(String prompt) {
        while (true) {
            String string = getStringFromUser(prompt);

            BigDecimal number = processBigDecimal(string);

            if (!number.equals(BigDecimal.valueOf(-1.00))) {
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

    public void displayListOfStrings(String[] stringsForDisplay) {
        for (String string : stringsForDisplay) {
            println(string);
        }
    }



    public String getItemNameFromUser() {
        return getStringFromUser("Enter the name of the product: ");
    }
    public BigDecimal getItemPriceFromUser(String itemName) {
        return getBigDecimalFromUser("Enter the price for 1 " + itemName + ": $");
    }
    public String getItemSKUFromUser() {
        return getStringFromUser("Enter the item's SKU: ");
    }
    public int getItemQuantityFromUser() {
        return getIntFromUser("Enter the quantity: ");
    }


}
