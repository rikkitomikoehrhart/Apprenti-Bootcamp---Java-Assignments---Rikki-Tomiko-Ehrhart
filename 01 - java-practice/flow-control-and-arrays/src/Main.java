import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        int alarm = 1;
        int x = 10;
        int y = 20;

        if (alarm == 1 || getValue()) {
            // do things
            if (x > 5) {
                // and do this
                if (y < 30) {
                    // and many this?
                }
            } else {
                // or do this
            }
        } else if (alarm == 2) {
            // do other things
        } else {
            // do this
        }

        Scanner io = new Scanner(System.in);
        int dayNum = Integer.parseInt(io.nextLine());

        switch (dayNum) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("That's not a valid day");
                break;
        }

        switch (dayNum) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("Weekday");
                break;
            case 6:
            case 7:
                System.out.println("Weekend");
                break;
            default:
                System.out.println("That's not a valid day");

        }

        String message = switch (dayNum) {
            case 1, 2, 3, 4, 5 -> "It's a week day";
            case 6, 7 -> "It's a weekend!";
            default -> "That's not a valid day.";
        };


        ///  Decisions
        System.out.println("Welcome to the dungeon!");
        System.out.print("Do you want to enter the cave? (y/n): ");

        String enterCave = io.nextLine();

        if (enterCave.equals('y')) {
            System.out.print("Do you want ot go (l)eft or (r)ight?: ");
            String direction = io.nextLine();
        }





    }

    public static boolean getValue() {
        return true;
    }
}