package org.example;

public class GenericsDemo {
    public static void main(String[] args) {
        // Creating a Container specifically for Integers
        Container<Integer> wholeNumberContainer = new Container<>();

        // Placing the number 42 inside our magic box
        wholeNumberContainer.set(42);

        // Opening the box and printing what's inside
        System.out.println("Stored in container: " + wholeNumberContainer.get());
    }
}
