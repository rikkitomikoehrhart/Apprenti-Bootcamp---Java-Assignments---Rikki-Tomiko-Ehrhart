import javax.xml.transform.Source;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        boolean keyA = false;
        boolean keyB = false;
        Scanner io = new Scanner(System.in);
        Random random = new Random();
        boolean playing = true;

        while (playing) {
            System.out.println("You are in a grand foyer. In front of you is a Conservatory,");
            System.out.println("to the left is a closed door, and to the right is a library.");

            System.out.println("\nWhere would you like to go?");
            System.out.println("1. The Conservatory (forward)");
            System.out.println("2. The closed door (left)");
            System.out.println("3. The Library (right)");
            System.out.print(">>  ");
            int choice = Integer.parseInt(io.nextLine());


            switch (choice) {
                case 1:
                    // Conservatory
                    System.out.println("\n\nYou entered the Conservatory!");
                    System.out.println("The room is a sun-drenched room filled with towering tropical");
                    System.out.println("plants and delicate orchids. The scent of damp earth lingers in");
                    System.out.println("the air. The glass walls stretch from floor to ceiling, revealing");
                    System.out.println("the storm brewing just beyond the garden.\n\n");

                    if (keyA) {
                        System.out.print("You've found everything you can here. Going back to the hallway.");
                        break;
                    } else {
                        System.out.println("Would you like to explore? (y for yes or anything else for no): ");
                        String explore;
                        System.out.print(">>  ");
                        explore = io.nextLine();

                        while (explore.equals("y")) {
                            int randomInt = random.nextInt(10);
                            if (randomInt > 8) {
                                keyA = true;
                                System.out.println("You found one half of a key! ");
                                break;
                            } else {
                                System.out.println("You didn't find anything. Keep exploring? (y for yes or anything else for no): ");
                                System.out.print(">>  ");
                                explore = io.nextLine();
                            }
                        }
                        System.out.println("Going back to the hallway...");
                    }
                    break;
                case 2:
                    // The closed door
                    if (!keyA || !keyB) {
                        System.out.println("\n\nThe door is locked.");
                        System.out.println("Maybe you should explore more...");
                        break;
                    } else if (keyA && keyB) {
                        System.out.println("\n\nYou entered the Study!");
                        System.out.println("The room stands in still perfection, untouched by time. Rich mahogany");
                        System.out.println("walls cradle shelves of rare books, which a single beam of moonlight ");
                        System.out.println("falls upon the grand desk -- and the evidence that solves it all. It's");
                        System.out.println("quiet now... almost too quiet.\n\n");

                        System.out.print("You did it! CONGRATULATIONS!");
                        playing = false;
                        break;
                    }
                    break;
                case 3:
                    // The library
                    System.out.println("\n\nYou entered the Library!");
                    System.out.println("The room is dim and wood-paneled lined. It has towering shelves");
                    System.out.println("of dusty, leather-bound books. A fireplace crackles softly beneath");
                    System.out.println("a stern portrait, casting dancing shadows across the velvet armchairs.");
                    System.out.println("The air smells of old paper and secrets best left unread.\n\n");

                    if (keyB) {
                        System.out.print("You've found everything you can here. Going back to the hallway.");
                        break;
                    } else {
                        System.out.println("Would you like to explore? (y for yes or anything else for no): ");
                        String explore;
                        System.out.print(">>  ");
                        explore = io.nextLine();

                        while (explore.equals("y")) {
                            int randomInt = random.nextInt(10);
                            if (randomInt > 8) {
                                keyB = true;
                                System.out.println("You found one half of a key! ");
                                break;
                            } else {
                                System.out.println("You didn't find anything. Keep exploring? (y for yes or anything else for no): ");
                                System.out.print(">>  ");
                                explore = io.nextLine();
                            }
                        }
                        System.out.println("Going back to the hallway...");
                    }
                    break;

            }


        }

    }
}