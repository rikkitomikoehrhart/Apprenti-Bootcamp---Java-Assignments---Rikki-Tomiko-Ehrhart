package org.example;

import java.util.ArrayList;


public class App 
{
    public static void main( String[] args ) {
        ArrayList<String> names = new ArrayList<String>();

        names.add("Rikki");
        names.add("Sam");
        names.add("Nicole");
        names.add("Kellen");
        names.add("Cher");
        names.add("Cat");
        names.add("Laura");
        names.add("Anya");


        String aName = names.get(1);
        names.remove(1);

        java.util.Collections.sort(names);
        System.out.println(names);
    }
}
