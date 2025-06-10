import java.util.Scanner;

public class Main {
    public static LockerManager lm = new LockerManager();
    public static Utils u = new Utils();
    public static void main(String[] args) {



        u.print("Welcome to the Locker App");


        do {
            u.printMenu();

            int choice = u.intInput(">> ");

            switch (choice) {
                case 1:
                    u.addLocker();
                    continue;
                case 2:
                    u.removeLocker();
                    continue;
                case 3:
                    u.storeItem();
                    continue;
                case 4:
                    u.retrieveItem();
                    continue;
                case 5:
                    lm.displayAllLockers();
                    continue;
                default:
                    // Exit
                    u.print("Thank you. Have a nice day!");
                    break;
            }
            break;

        } while (true);

    }
}