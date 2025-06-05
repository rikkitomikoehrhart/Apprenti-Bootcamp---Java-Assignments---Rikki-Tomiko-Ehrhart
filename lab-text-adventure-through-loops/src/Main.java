import javax.xml.transform.Source;
import java.util.Scanner;
import java.util.Random;

public class Main {
    private static Scanner io = new Scanner(System.in);
    public static void main(String[] args) {
        boolean keyA = false;
        boolean keyB = false;
        Random random = new Random();
        boolean playing = true;



        String[] welcomeMessage = {"You are in a grand foyer. In front of you is a Conservatory,", "to the left is a closed door, and to the right is a library,"};
        String[] wayFinding = {"Where would you like to go?", "1. The Conservatory (forward)", "2. The closed door (left)", "3. The Library (right)"};
        String[] conservatory = {"\n\nYou entered the Conservatory!", "You are in a sun-drenched room filled with towering tropical", "plants and delicate orchids. The scent of damp earth lingers", "in the air. The glass walls stretch from floor to ceiling, ", "revealing the storm brewing just beyond the garden. \n\n"};
        String[] lockedStudy = {"\n\nThe door is locked", "Maybe you should explore more...\n\n"};
        String[] unLockedStudy = {"\n\nYou entered the Study!", "The room stands in still perfection, untouched by time. Rich mahogany", "walls cradle shelves of rare books, which a single beam of moonlight", "falls upon the grand desk -- and the evidence that solves it all. It's", "quiet now... almost too quiet"};
        String[] wonGameMessage = {"\n\nYou did it! CONGRATULATIONS!"};
        String[] library = {"\n\nYou entered the Library!", "The room is dim and wood-paneled lined. It has towering shelves", "of dusty, leather-bound books. A fireplace crackles softly beneath", "a stern portrait, casting dancing shadows across the velvet armchairs.", "The air smells of old paper and secrets best left unread.\n\n"};

        String[] explored = {"You've found everything you can here. Going back to the hallway... "};
        String wouldExplore = "Would you like to explore? (y for yes or anything else for no): ";
        String keepExploring = "You didn't find anything. Keep exploring? (y for yes or anything else for no): ";
        String[] yesOrNo = {"y", "Y", "n", "N"};



        while (playing) {
            displayMessage(welcomeMessage);
            displayMessage(wayFinding);

            int choice = promptUserForIntSelection("Enter your selection: ", 3);

            switch (choice) {
                case 1:
                    // Conservatory
                    displayMessage(conservatory);

                    if (keyA) {
                        displayMessage(explored);
                        break;
                    } else {
                        String explore = promptUserForStringSelection(wouldExplore, yesOrNo);

                        while (explore.equals("y")) {
                            int randomInt = random.nextInt(10);
                            if (randomInt > 8) {
                                keyA = true;
                                System.out.println("You found one half of a key! \n\n");
                                break;
                            } else {
                                explore = promptUserForStringSelection(keepExploring, yesOrNo);
                            }
                        }
                        System.out.println("Going back to the hallway...");
                    }
                    break;
                case 2:
                    // The closed door
                    if (!keyA || !keyB) {
                        displayMessage(lockedStudy);
                        break;
                    } else if (keyA && keyB) {
                        displayMessage(unLockedStudy);
                        displayMessage(wonGameMessage);

                        playing = false;
                        break;
                    }
                    break;
                case 3:
                    // The library
                    displayMessage(library);

                    if (keyB) {
                        displayMessage(explored);
                        break;
                    } else {
                        String explore = promptUserForStringSelection(wouldExplore, yesOrNo);

                        while (explore.equals("y")) {
                            int randomInt = random.nextInt(10);
                            if (randomInt > 8) {
                                keyB = true;
                                System.out.println("You found one half of a key! \n\n");
                                break;
                            } else {
                                explore = promptUserForStringSelection(keepExploring, yesOrNo);
                            }
                        }
                        System.out.println("Going back to the hallway...");
                    }
                    break;

            }


        }

    }

    private static void displayMessage(String[] messages){
        for (String message : messages) {
            System.out.println(message);
        }
    }

    private static String promptUserForStringSelection(String prompt, String[] validResponses) {
        String response;

        while (true) {
            try {
                System.out.print(prompt);
                response = io.nextLine();
                if (response == null || response.trim().isEmpty()) {
                    throw new IllegalArgumentException("Invalid Response");
                }

                boolean validResponse = false;
                for (String valid : validResponses) if (response.equals(valid)) {validResponse = true;}

                if (!validResponse) {
                    throw new InvalidResponse("Invalid response");
                }

                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid response");
                continue;
            } catch (InvalidResponse e) {
                System.out.println("Invalid response.");
                continue;
            }
        }

        return response;
    }

    private static int promptUserForIntSelection(String prompt, int validResponses) {
        int response;

        while (true) {
            try {
                System.out.print(prompt);
                response = Integer.parseInt(io.nextLine());

                if (response <= 0 || response > validResponses) {
                    throw new InvalidResponse("Invalid Response.");
                }
                break;
            } catch (InvalidResponse e) {
                System.out.println("Invalid choice");
                continue;
            } catch (NumberFormatException e) {
                System.out.println("Please enter the number of your selection.");
                continue;
            }
        }

        return response;
    }
}