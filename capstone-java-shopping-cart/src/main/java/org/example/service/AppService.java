package org.example.service;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class AppService {
    Scanner scanner = new Scanner(System.in);


    public void println(String message) {
        System.out.println(message);
    }

    public void print(String message) {
        System.out.print(message);
    }


    public String getStringFromUser(String prompt) {
        while (true) {
            print(prompt);
            String entry = scanner.nextLine();

            if (isValidString(entry)) {
                return entry.trim();
            }
        }
    }


    public int getIntFromUser(String prompt) {
        while (true) {
            String entry = getStringFromUser(prompt);

            if (isValidInt(entry)) {
                return Integer.parseInt(entry);
            }
        }
    }

    private BigDecimal getBigDecimalFromUser(String prompt) {
        while (true) {
            String entry = getStringFromUser(prompt);

            if(isValidBigDecimal(entry)) {
                return new BigDecimal(entry);
            }
        }
    }

    private boolean isValidString(String input) {
        return input != null && !input.trim().isEmpty();
    }

    private boolean isValidInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidBigDecimal(String input) {
        try {
            new BigDecimal(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void displayListOfStrings(String[] stringsForDisplay) {
        for (String string : stringsForDisplay) {
            println(string);
        }
    }

    public void displayArrayListOfStrings(ArrayList<String> stringsForDisplay) {
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
    public int getItemQuantityFromUser()  {
        return getIntFromUser("Enter the quantity: ");
    }


}
