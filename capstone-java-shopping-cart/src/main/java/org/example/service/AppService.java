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


    public String getStringFromUser(String prompt) throws EmptyInputException, NullInputException {
        while (true) {
            print(prompt);
            String entry = scanner.nextLine();

            if (entry.equals(processString(entry))) {
                return entry;
            }
        }
    }


    public int getIntFromUser(String prompt) throws NumberFormatException, EmptyInputException, NullInputException {
        while (true) {
            String entry = getStringFromUser(prompt);

            int number = processInt(entry);

            if (number != -1) {
                return number;
            }
        }
    }

    private BigDecimal getBigDecimalFromUser(String prompt) throws EmptyInputException, NullInputException {
        while (true) {
            String string = getStringFromUser(prompt);

            BigDecimal number = processBigDecimal(string);

            if (!number.equals(BigDecimal.valueOf(-1.00))) {
                return number;
            }
        }
    }


    private String processString(String string) throws EmptyInputException, NullInputException {
        try {
            if (string == null) {
                throw new NullInputException("You cannot enter nothing");
            } else if (string.trim().isEmpty()) {
                throw new EmptyInputException("You must enter something.");
            }
        } catch (NullInputException | EmptyInputException e) {
            println(e.getMessage());
            throw e;
        }

        return string;
    }

    private int processInt(String string) throws NumberFormatException {
        int number = -1;


        try {
            number = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            print("That is not a number. ");
        }

        return number;

    }


    private BigDecimal processBigDecimal(String string) throws NumberFormatException {
        BigDecimal number = BigDecimal.valueOf(-1.00);

        try {
            number = BigDecimal.valueOf(Double.parseDouble(string));
        } catch (NumberFormatException e) {
            print("That is not a number. ");
        }

        return number;
    }

    public void displayListOfStrings(String[] stringsForDisplay) {
        for (String string : stringsForDisplay) {
            println(string);
        }
    }



    public String getItemNameFromUser() throws EmptyInputException, NullInputException {
        return getStringFromUser("Enter the name of the product: ");
    }
    public BigDecimal getItemPriceFromUser(String itemName) throws EmptyInputException, NullInputException {
        return getBigDecimalFromUser("Enter the price for 1 " + itemName + ": $");
    }
    public String getItemSKUFromUser() throws EmptyInputException, NullInputException {
        return getStringFromUser("Enter the item's SKU: ");
    }
    public int getItemQuantityFromUser() throws EmptyInputException, NullInputException {
        return getIntFromUser("Enter the quantity: ");
    }


}
