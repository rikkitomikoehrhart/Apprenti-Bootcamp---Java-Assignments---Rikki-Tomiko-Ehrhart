package org.example;
import java.util.Scanner;
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        SpellBook spellBook = new SpellBook();

        while (true) {
            System.out.print("Recite a spell: ");
            spellBook.tryIncantation(scanner.nextLine());
        }
    }
}
