import java.util.Scanner;

public class AppUtils {
    private static final Scanner io = new Scanner(System.in);

    private static final String wasOpenInstruction = "Locker is open. Please place the phone in the locker.";
    private static final String isOpenNowInstruction = "Locker is now open. Please remove the phone.";
    private static final String[] yeses = {"y", "Y"};
    private static final String areYouSure = "Are you sure? (y for yes, anything else for no): ";


    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayMessages(String[] messages) {
        for (String message : messages) {
            displayMessage(message);
        }
    }


    public String promptUserForString(String prompt) {
        System.out.print(prompt);

        return io.nextLine();
    }

    private int promptUserForInt(String prompt) {
        int response;

        while (true) {
            try {
                System.out.print(prompt);
                response = Integer.parseInt(io.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        return response;
    }

    public void displayLockerAndPin(Locker locker) {
        displayMessages(
                new String[]{
                        String.format(
                                "\nThank you. \nYou're locker number is \t\t%d \nand your pin is: \t\t\t\t%s",
                                locker.getNumber() + 1,
                                locker.getPin()
                        )
                });
    }

    public void displayInstructionsMessageForOpenLocker(boolean isOpen) {
        displayMessage(isOpen ? wasOpenInstruction : isOpenNowInstruction);
    }

    public void displayReleasedLockerNotification(int lockerNumber) {
        displayMessage("\nThank you. Locker " + lockerNumber + " has been released and is available for use.");
    }

    // Specialty Prompt Functions
    public void pressEnterToConfirmCloseLocker() {
        displayMessage("And press enter to close locker.");
        promptUserForString(">>  ");
    }

    public Locker promptUserAndReturnLocker(String prompt, LockerService ls) {
        while (true) {
            try {
                int lockerNumber = promptUserForInt("\nEnter the locker number you want to " + prompt + ": ");
                Locker locker = ls.getLocker(lockerNumber);

                Result result = Result.isLockerInUse(locker);

                if (result.success) {
                    return locker;
                } else {
                    displayMessage(result.message);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("There isn't that many lockers. Please try again.");
            }
        }
    }

    public MenuOptions mainMenu(LockerService ls) {
        Result canRent = Result.canRentLocker(ls);
        String[] mainMenu = {
                "\nWhat would you like to do next?",
                String.format("\t\t1. %s", canRent.success ? MenuOptions.RENT.getDescription() : "**NO LOCKERS LEFT**"),
                String.format("\t\t2. %s", MenuOptions.ACCESS.getDescription()),
                String.format("\t\t3. %s", MenuOptions.RELEASE.getDescription()),
                "\t\t---",
                "\t\tAny other number to exit."
        };
        displayMessages(mainMenu);

        return MenuOptions.getMenuOptionFromValue(promptUserForInt("Enter your choice: "));
    }

    public String promptUserForPin(Locker locker) {
        return promptUserForString("Please enter the PIN to access locker " + (locker.getNumber() + 1) + ": ");
    }

    public Result errorPromptToContinue() {
        displayMessage("Sorry, that's not correct.");
        return Result.isCorrectResponse(promptUserForString("Try again? (y for yes anything else for no): "), yeses);
    }

    public Result areYouSurePromptToContinue() {
        return Result.isCorrectResponse(promptUserForString(areYouSure), yeses);
    }
}
