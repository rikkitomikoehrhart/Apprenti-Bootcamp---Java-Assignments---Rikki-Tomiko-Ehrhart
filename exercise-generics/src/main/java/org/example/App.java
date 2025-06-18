package org.example;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class App
{
    public static void main( String[] args ) {

        Box<Integer> number = new Box<>(13, "Number: ");
        Box<String> string = new Box<>("Our Lucky Number", "Message: ");



        ArrayList<Box<Integer>> boxIntegerList = new ArrayList<>();
        boxIntegerList.add(new Box<Integer>(1, "Month"));
        boxIntegerList.add(new Box<Integer>(13, "Day"));
        boxIntegerList.add(new Box<Integer>(2023, "Year"));

        for (Box<Integer> num : boxIntegerList) {
            System.out.println(num.getLabel() + ": " + num.getObject());
        }


        Queue<Box<String>> boxStringList = new LinkedList<>();
        boxStringList.add(new Box<String>("13 is our Lucky Number", "1."));
        boxStringList.add(new Box<String>("First Day, Friday the 13th", "2."));
        boxStringList.add(new Box<String>("Married on a Friday the 13th", "3."));

        while(!boxStringList.isEmpty()) {
            System.out.println("Processing: " + boxStringList.poll().getInfo());
        }
    }
}
