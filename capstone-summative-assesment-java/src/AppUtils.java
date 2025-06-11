import java.util.Scanner;

public class AppUtils {
    private static Scanner io = new Scanner(System.in);

    private static String wasOpenInstruction = "Locker is open. Please place the phone in the locker.";
    private static String isOpenNowInstruction = "Locker is now open. Please remove the phone.";
    private static String[] yeses = {"y", "Y"};
    private static String areYouSure = "Are you sure? (y for yes, anything else for no): ";




    // Main Basic Display Functions
    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public static void displayMessages(String[] messages) {
        for (String message : messages) {
            displayMessage(message);
        }
    }


    // Main Basic Prompt Functions
    public static String promptUserForString(String prompt) {
        System.out.print(prompt);

        return io.nextLine();
    }

    private static int promptUserForInt(String prompt) {
        int response;

        while (true) {
            try {
                System.out.print(prompt);
                response = Integer.parseInt(io.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }
        }
        return response;
    }


    // Specialty Display Functions
    public static void displayLockerAndPin(Locker locker) {
        displayMessages(
                new String[]{
                        "\n",
                        String.format(
                                "Thank you. \nYou're locker number is \t\t%d \nand your pin is: \t\t\t\t%s",
                                Main.locker.getLockerNumber() + 1,
                                Main.locker.getPinNumber()
                        )
                });
    }

    public static void displayInstructionsMessageForOpenLocker(boolean isOpen) {
        displayMessage(isOpen ? wasOpenInstruction : isOpenNowInstruction);
    }


    public static void displayReleasedLockerNotification(int lockerNumber) {
        displayMessage("Thank you. Locker " + lockerNumber + " has been released and is available for use.");
    }



    // Specialty Prompt Functions
    public static void pressEnterToConfirmCloseLocker() {
        displayMessage("And press enter to close locker.");
        promptUserForString(">>  ");
    }

    public static Locker promptUserAndReturnLocker(String prompt) {
        while (true) {
            try {
                displayMessage("\n");
                int lockerNumber = promptUserForInt("Enter the locker number you want to " + prompt + ": ");
                Main.locker = Main.ls.getLocker(lockerNumber);

                Result result = Result.isLockerInUse(Main.locker);

                if (result.success) {
                    return Main.locker;
                } else {
                    displayMessage(result.message);
                    continue;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("There isn't that many lockers. Please try again.");
                continue;
            }
        }
    }

    public MenuOptions mainMenu() {
        Result canRent = Result.canRentLocker();
        String[] mainMenu = {
                "\n",
                "What would you like to do next?",
                String.format("\t\t1. %s", canRent.success ? MenuOptions.RENT.getDescription() : "**NO LOCKERS LEFT**"),
                String.format("\t\t2. %s", MenuOptions.ACCESS.getDescription()),
                String.format("\t\t3. %s", MenuOptions.RELEASE.getDescription()),
                "\t\t---",
                "\t\tAny other number to exit."
        };
        displayMessages(mainMenu);

        MenuOptions option = MenuOptions.getMenuOptionFromValue(promptUserForInt("Enter your choice: "));

        return option;
    }

    public String promptUserForPin(Locker locker) {
        return promptUserForString("Please enter the PIN to access locker " + (Main.locker.getLockerNumber() + 1) + ": ");
    }

    public Result errorPromptToContinue() {
        displayMessage("Sorry, that's not correct.");
        return Result.isCorrectResponse(promptUserForString("Try again? (y for yes anything else for no): "), yeses);
    }

    public Result areYouSurePromptToContinue() {
        return Result.isCorrectResponse(promptUserForString(areYouSure), yeses);
    }
}
