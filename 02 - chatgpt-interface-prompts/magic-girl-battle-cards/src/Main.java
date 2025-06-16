// 🎀 MAGIC GIRLS BATTLE CARDS
//
// 📝 Prompt:
//      Each magical girl card has:
//              👉 An attack move
//	            👉 A defense move
//	            👉 A magical name
//
// 🎯 Goal:
//      Interface: MagicalGirlCard.
//          Create 2–3 classes. Write a
//          little battleRound() method
//          to call attacks/defense.


import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        GameUtils gameUtils = new GameUtils();
        MagicalGirlCard player1 = null;
        MagicalGirlCard player2 = null;


        gameUtils.displayWelcome();

        while (true) {
            gameUtils.displayMainMenu(player1, player2);

            int choice = gameUtils.getIntFromUser("Enter your choice: ", scanner);


            switch (choice) {
                case 1:
                    // Choose Character 1
                    player1 = gameUtils.chooseCharacter(scanner, random);
                    continue;
                case 2:
                    // Choose Character 2
                    player2 = gameUtils.chooseCharacter(scanner, random);
                    continue;
                case 3:
                    // Start Game
                    if (player1 == null || player2 == null) {
                        System.out.println("Missing a character, please make both characters before starting the game");
                        continue;
                    } else {
                        gameUtils.startGame(player1, player2, scanner, random);
                    }
                    continue;
                default:
                    // EXIT
                    System.out.println("Thank you! Have a nice day!");
                    break;
            }
            break;
        }


    }
}