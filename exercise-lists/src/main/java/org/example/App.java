package org.example;


import java.util.ArrayList;

public class App
{
    public static void main( String[] args ) {
        ArrayList<String> students = new ArrayList<>();

        students.add("Rikki");
        students.add("Sam");
        students.add("Nicole");
        students.add("Kellen");
        students.add("Cher");
        students.add("Cat");
        students.add("Laura");
        students.add("Anya");

        System.out.println("The second student is: " + students.get(2));

        System.out.println("Removing " + students.get(1) + "... ");
        students.remove(1);

        System.out.println("The students size is now: " + students.size());

        System.out.println("Is the student list empty? " + students.isEmpty());

        java.util.Collections.sort(students);
        System.out.println("Sorted Students: ");
        for (String s : students) {
            System.out.println(s);
        }

        ArrayList<String> pets = new ArrayList<>();
        pets.add("Joe");
        pets.add("Becket");
        pets.add("Zeus");
        pets.add("Hades");
        pets.add("Sebastian");
        pets.add("Sophie");


        ArrayList<String> studentsAndPets = new ArrayList<>();
        studentsAndPets.addAll(students);
        studentsAndPets.addAll(pets);

        studentsAndPets.add("Sam");

        java.util.Collections.sort(studentsAndPets);

        System.out.println("\n\n\nSorted Students and Pets: ");

        for (String s : studentsAndPets) {
            System.out.println(s);
        }
    }
}
