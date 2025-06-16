import java.util.Random;
import java.util.Scanner;

public class GameUtils {

    public void displayWelcome() {
        System.out.println("Welcome to Magic Girls Battle Cards!");
        System.out.println("====================================\n");
    }

    public void displayMainMenu(MagicalGirlCard player1, MagicalGirlCard player2) {
        System.out.println("");
        if (player1 == null) {
            System.out.println("1. Choose Player 1 Character");
        } else {
            System.out.printf("1. Change Player 1: %s%n", player1.getMagicalGirlName());
        }

        if (player2 == null) {
            System.out.println("2. Choose Player 2 Character");
        } else {
            System.out.printf("2. Change Player 2: %s%n", player2.getMagicalGirlName());
        }

        System.out.println("3. Start Game");
        System.out.println("Anything other number to quit.");
    }

    public int getIntFromUser(String prompt, Scanner scanner) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }
        }
    }

    public String getStringFromUser(String prompt, Scanner scanner) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public MagicalGirlCard chooseCharacter(Scanner scanner, Random random) {
        System.out.println("");
        displayCharacterChoiceMenu();

        int choice = getIntFromUser("Enter the number of the character you'd like to play: ", scanner);

        switch (choice) {
            case 1:
                MagicalGirlCard witch = new WitchGirlCard(getStringFromUser("Enter Character Name:  ", scanner), random);
                displayCharacterInfo(witch);
                return witch;
            case 2:
                MagicalGirlCard sorceress = new SorceressGirlCard(getStringFromUser("Enter Character Name: ", scanner), random);
                displayCharacterInfo(sorceress);
                return sorceress;
            default:
                MagicalGirlCard cleric = new ClericGirlCard(getStringFromUser("Enter Character Name: ", scanner), random);
                displayCharacterInfo(cleric);
                return cleric;
        }
    }

    public void displayCharacterChoiceMenu() {
        System.out.println("");
        System.out.println("Which Character would you like to play: ");
        System.out.println("1. Witch");
        System.out.println("2. Sorceress");
        System.out.println("3. Cleric");
    }

    public void displayCharacterInfo(MagicalGirlCard player) {
        System.out.println("");
        System.out.printf("------------- %s -------------%n", player.getMagicalGirlName());
        System.out.printf("Health: \t\t\t%d%n", player.getHealth());
        System.out.printf("Attack Power: \t\t%d%n", player.attackMove());
        System.out.printf("Defense Power: \t\t%d%n", player.defenseMove());
    }


    public void startGame(MagicalGirlCard player1, MagicalGirlCard player2, Scanner scanner, Random random) {
        int round = 1;
        boolean isWon = false;

        while (!isWon) {
            System.out.printf("\n-------%s (hp: %d) vs %s (hp: %d)-------", player1.getMagicalGirlName(), player1.getHealth(), player2.getMagicalGirlName(), player2.getHealth());

            System.out.printf("\nROUND %d!\n", round);

            combat(player1, player2, random);
            isWon = checkForWinner(player1, player2);

            round++;
        }
    }

    public void combat(MagicalGirlCard player1, MagicalGirlCard player2, Random random) {
        int player1AttackPoints = player1.processAttack(random);
        int player2AttackPoints = player2.processAttack(random);

        int player1DefensePoints = player1.processDefense(random);
        int player2DefensePoints = player2.processDefense(random);

        int player1AttackMinusDefense = player2AttackPoints - player1DefensePoints;
        int player2AttackMinusDefense = player1AttackPoints - player2DefensePoints;

        if (player1AttackMinusDefense < 0) player1AttackMinusDefense = 0;
        if (player2AttackMinusDefense < 0) player2AttackMinusDefense = 0;


        if ((random.nextInt(10) + 1) % 2 != 0) {
            turn(player1, player1AttackPoints, player2, player2DefensePoints);
            player2.setHealth(player2AttackMinusDefense);

            if (player2.getHealth() > 0) {
                turn(player2, player2AttackPoints, player1, player1DefensePoints);
                player1.setHealth(player1AttackMinusDefense);
            } else {
                System.out.println(player1.getMagicalGirlName() + " WINS!");
            }
        } else {
            turn(player2, player2AttackPoints, player1, player1DefensePoints);
            player1.setHealth(player1AttackMinusDefense);

            if (player1.getHealth() > 0) {
                turn(player1, player1AttackPoints, player2, player2DefensePoints);
                player2.setHealth(player2AttackMinusDefense);
            } else {
                System.out.println(player2.getMagicalGirlName() + " WINS!");
            }
        }
    }

    public void turn(MagicalGirlCard firstPlayer, int firstAttack, MagicalGirlCard secondPlayer, int secondDefense) {
        System.out.println(firstPlayer.getMagicalGirlName() + " ATTACKS!");
        System.out.println(firstPlayer.getMagicalGirlName() + " attacks for " + firstAttack + ".");
        System.out.println(secondPlayer.getMagicalGirlName() + " defends for " + secondDefense + ".");
    }

    public boolean checkForWinner(MagicalGirlCard player1, MagicalGirlCard player2) {
        if (player1.getHealth() < 1) {
            System.out.println("\n\n");
            System.out.println(player2.getQuip());
            return true;
        } else if (player2.getHealth() < 1) {
            System.out.println("\n\n");
            System.out.println(player1.getQuip());
            return true;
        } else {
            return false;
        }
    }



}
