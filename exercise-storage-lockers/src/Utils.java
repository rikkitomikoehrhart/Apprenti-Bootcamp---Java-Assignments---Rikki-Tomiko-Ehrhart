import java.util.Scanner;
import static java.lang.Integer.parseInt;



public class Utils {
    Scanner io = new Scanner(System.in);


    // OUTPUTS
    public void print(String message) {
        System.out.println(message);
    }


    // INPUTS
    public String stringInput(String prompt) {
        System.out.printf("%s: ", prompt);
        String answer;

        while (true) {
            answer = io.nextLine();

            if (answer == "" || answer == null) {
                print("Please enter something.");
            } else {
                return answer;
            }
        }
    }

    public int intInput(String prompt) {
        System.out.printf("%s: ", prompt);
        int answer;
        while (true) {
            try {
                answer = parseInt(io.nextLine());
            } catch (NumberFormatException e) {
                print("Please enter a valid number");
                continue;
            }
            return answer;
        }
    }



    // PRINT MENU
    public void printMenu(){
        print("\n\nMenu:");
        print("1. Add a locker");
        print("2. Remove a locker");
        print("3. Store an item in a locker");
        print("4. Retrieve an item from a locker");
        print("5. Display all lockers");
        print("Or anything else to exit." );
    }





    // MENU OPTIONS
    public void addLocker() {
        Main.lm.addLocker(String.format("%d", Main.lm.getLockerTotal() + 1));
        System.out.printf("\nLocker ID: %d created.", Main.lm.getLockerTotal());
    }

    public void removeLocker() {
        print("\nEnter the id of the locker to remove: ");
        String id = stringInput(">> ");

        if (Main.lm.getLocker(id) != null) {
            if (Main.lm.removeLocker(id)) {
                System.out.printf("Locker ID: %s has been removed.", id);
            } else {
                print("Sorry, we weren't able to remove that locker");
            }
        } else {
            print("Sorry, that id didn't exist.");
        }
    }

    public void storeItem() {
        while (true) {
            Locker locker = getLockerFromUser();
            String items;
            if (locker != null) {
                while (true) {
                    print("\nEnter items to place in locker: ");
                    System.out.print(">> ");
                    items = io.nextLine();
                    if (items == "" || items == null) {
                        print("Please enter something. ");
                        continue;
                    }
                    break;
                }
                locker.setContents(items);
                locker.setOccupied(true);
                break;
            } else {
                break;
            }
        }
    }

    public void retrieveItem() {
        Locker locker = getLockerFromUser();
        if (locker != null) {
            String items = locker.getContents();
            locker.setContents("");
            locker.setOccupied(false);
            System.out.printf("%s successfully removed. Locker is empty.", items);
        }
    }



    // UTILS FUNCTIONS
    public Locker getLockerFromUser() {
        while (true) {
            print("\nEnter the locker: ");
            int idInt = intInput(">> ");
            String idString = String.format("%d", idInt);
            if (idString == "" || idString == null) {
                print("Please enter something.");
                continue;
            }

            Locker locker = null;

            if (idInt > 0 && idInt <= Main.lm.getLockerTotal()) {
                if (Main.lm.lockers.get(idInt - 1) != null) {
                    locker = Main.lm.lockers.get(idInt - 1);
                } else {
                    print("That locker is not in use.");
                    continue;
                }
            } else {
                print("Sorry, that locker isn't in use");
                return locker;
            }

            return locker;
        }
    }


}
