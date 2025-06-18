package org.example;


import java.util.HashMap;
import java.util.Map;

public class App
{
    public static void main( String[] args )
    {
        // MONTHS
        Map<Integer, String> monthMap = new HashMap<>();

        monthMap.put(1, "January");
        monthMap.put(2, "February");
        monthMap.put(3, "March");
        monthMap.put(4, "April");
        monthMap.put(5, "May");
        monthMap.put(6, "June");
        monthMap.put(7, "July");
        monthMap.put(8, "August");
        monthMap.put(9, "September");
        monthMap.put(10, "October");
        monthMap.put(11, "November");
        monthMap.put(12, "December");


        for (Integer key : monthMap.keySet()) {
            System.out.println("Month #" + key + " is " + monthMap.get(key));
        }

        // CARDS
        Map<String, String[]> cards = new HashMap<>();

        cards.put("Hearts", new String[]{"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"});
        cards.put("Diamonds", new String[]{"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"});
        cards.put("Clubs", new String[]{"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"});
        cards.put("Spades", new String[]{"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"});

        for (String suit : cards.keySet()) {
            for (String num : cards.get(suit)) {
                System.out.printf("%s of %s%n", num, suit);
            }
        }

    }
}
