public class Main {
    static Locker locker = null;
    static AppUtils u = new AppUtils();
    static LockerService ls = new LockerService(10);
    static int lockerNumber;
    static String[] yeses = {"y", "Y"};
    static String areYouSure = "Are you sure? (y for yes, anything else for no): ";


    public static void main(String[] args) {
        /*
        *  Main runs the logic of the application.
        *
        *  ARGS: none
        *  RETURNS: none
        * */


        // Welcome/Start Menu
        u.displayMessage("Welcome to the Locker App!");


        while (true) {
            // Main Menu List, checks if user can rent lock and changes options based
            // on that result
            Result canRent = canRentLocker();
            String[] mainMenu = {
                    "\n",
                    "What would you like to do next?",
                    String.format("\t\t1. %s", canRent.success ? MenuOptions.RENT.getDescription() : "**NO LOCKERS LEFT**"),
                    String.format("\t\t2. %s", MenuOptions.ACCESS.getDescription()),
                    String.format("\t\t3. %s", MenuOptions.RELEASE.getDescription()),
                    "\t\t---",
                    "\t\tAny other number to exit."
            };
            u.displayMessages(mainMenu);


            // Grab user's choice
            int choice = u.promptUserForInt("Enter your choice: ");
            MenuOptions option = MenuOptions.getMenuOptionFromValue(choice);

            switch (option) {
                case RENT:
                    rentALocker();
                    continue;
                case ACCESS:
                    accessALocker();
                    continue;
                case RELEASE:
                    releaseALocker();
                    continue;
                default:
                    // EXIT
                    u.displayMessage("Thank you! Have a great day!");
                    break;
            }
            break;
        }
    }



    // Application Functionality Functions
    private static void rentALocker() {
        /*
        *  Rent A Locker calls on canRentLocker to check if
        *  there are lockers left to rent and calls on
        *  LockerService to create a new locker and
        *  displays the locker number and PIN to the user
        *
        *  ARGS: none
        *  RETURNS: none
        * */
        Result result = canRentLocker();
        if (result.success) {
            // There are lockers left, so rent the locker
            locker = ls.assignLocker();
            u.displayMessages(new String[]{"\n", String.format("Thank you. \nYou're locker number is \t\t%d \nand your pin is: \t\t\t\t%s", locker.getLockerNumber() + 1, locker.getPinNumber())});

            // Clear locker variable
            clearLockerVariable();
        } else {
            // There aren't lockers left. Display error message
            u.displayMessage(result.message);
        }
    }

    private static void accessALocker() {
        /*
        *  Access a Locker allows the user to access their locker
        *  and remove their phone. It will leave the locker unlocked
        *  until the user decides to access it again to put their
        *  phone back or release their locker.
        *
        *  ARGS: none
        *  RETURNS: none
        * */
        locker = promptUserAndReturnLocker("access");

        // Checks if user can unlock their locker.
        if (unlockLocker(locker)) {
            // If they can, checks if the locker is already opened, if so, displays direction to place phone in the locker,
            // if it wasn't already open, instructs user to remove the phone.
            u.displayMessage(locker.getIsOpen() ? "Locker is open. Please place the phone in the locker." : "Locker is now open. Please grab the phone.");
            pressEnterToConfirmCloseLocker();
            locker.setIsOpen();
        } else {
            // If they cannot unlock their locker, and they choose not to keep trying, return to main menu
            return;
        }

        // Clear locker variable
        clearLockerVariable();
    }

    private static void releaseALocker() {
        /*
        *  Release a Locker checks to see if the locker is currently in
        *  use, prompts the user to remove the phone if so or not and
        *  verifies if the user really wants to release the locker.
        *  Then it calls on LockerService to release the locker.
        *
        *  ARGS: none
        *  RETURNS: none
        * */
        locker = promptUserAndReturnLocker("release");

        // Checks if locker is not already open (meaning the phone is still in the locker)
        if (!locker.getIsOpen()) {
            // if so, verifies if the user can unlock the locker or not.
            if (unlockLocker(locker)) {
                // if the user can unlock the locker then verifies that they want to release the locker
                locker.setIsOpen();
                Result result = isCorrectResponse(u.promptUserForString(areYouSure), yeses);

                if (result.success) {
                    // If verifies successfully prompts to remove phone
                    u.displayMessage("Locker is now open. Remove phone.");
                    pressEnterToConfirmCloseLocker();
                } else {
                    // if they choose not to continue, return to main menu
                    return;
                }
            } else {
                // if they cannot unlock their locker and they chose not to continue, return to main menu
                return;
            }
        } else {
            // If locker was already opened (and the phone removed) verify they want to release the locker
            Result result = isCorrectResponse(u.promptUserForString(areYouSure), yeses);
            if (!result.success) {
                // If they chose not to, return to main menu, else proceed to code below
                return;
            }
        }

        // Use the LockerService to release locker
        ls.releaseLocker(locker);
        u.displayMessage("Thank you. Locker " + (locker.getLockerNumber() + 1) + " has been released and is available for use.");

        // Clear locker variable
        clearLockerVariable();

    }



    // Helper Functions
    private static void clearLockerVariable() {
        /*
        *  Clear Locker Variable reset the locker variable to null
        *  between uses so that we never edit a previous used locker
        *  by accident.
        *
        *  ARGS: none
        *  RETURNS: none
        * */
        locker = null;
    }

    private static Locker promptUserAndReturnLocker(String prompt) {
        /*
        *  Prompt User and Return Locker verifies that the locker the
        *  user wants to access or release is an actual locker in use
        *  and not outside the Array index.
        *
        *  ARGS:
        *       - String prompt : a prompt for the user that is either "access"
        *                   or "release" depending on which function is calling it
        *  RETURNS:
        *       - Locker locker : the locker the user chose to either access or
        *                   release.
        * */

        while (true) {
            try {
                // Prompt user for the locker number and grab that locker
                u.displayMessage("\n");
                lockerNumber = u.promptUserForInt("Enter the locker number you want to " + prompt + ": ");
                locker = ls.getLocker(lockerNumber);

                // Verify that it is actually a locker in use.
                Result result = isLockerInUse(locker);


                if (result.success) {
                    // If it is a locker in user, return locker
                    return locker;
                } else {
                    // Else display message and try again
                    u.displayMessage(result.message);
                    continue;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                // Catch an Array indexing error and continue to try again.
                System.out.println("There isn't that many lockers. Please try again.");
                continue;
            }
        }


    }

    private static boolean unlockLocker(Locker locker) {
        /*
        *  Unlock Locker verifies a correct locker number and pin combination
        *  and returns a successful or unsuccessfull result based on user
        *  input.
        *
        *  ARGS:
        *       - Locker locker : a locker to unlock, user enters the pin
        *               and function verifies if it is correct or not
        *  RETURNS:
        *       - boolean : a true or false depending on the user's success.
        * */
        while (true) {
            // Returns a result if the user enters the correct pin for the locker they chose
            Result result = isCorrectResponse(u.promptUserForString("Please enter the pin to access locker " + (locker.getLockerNumber() + 1) + ": "), new String[] {locker.getPinNumber()});
            if (result.success){
                // if they entered a good pin, return true
                return true;
            } else {
                // if they didn't enter a good pin, tell them it was not correct and prompt
                // them if they would like to try again.
                u.displayMessage("Sorry, that's not correct.");
                Result contResult = isCorrectResponse(u.promptUserForString("Try again? (y for yes anything else for no): "), yeses);
                if(contResult.success) {
                    // if they would like to try again, start the loop over
                    continue;
                } else {
                    // if not, return to main menu
                    return false;
                }
            }
        }
    }

    private static void pressEnterToConfirmCloseLocker() {
        /*
        *  Press Enter To Confirm Close Locker just prompts the user
        *  and accepts any key to move on.
        *
        *  ARGS: none
        *  RETURNS: none
        * */
        u.displayMessage("And press enter to close locker.");
        u.promptUserForString(">>  ");
    }



    // Error Handling
    private static Result isCorrectResponse(String response, String[] possibleResponses) {
        /*
        *  Is Correct Response takes a response and a list of possible answers
        *  and checks to make sure the response given by the user is an
        *  acceptable one
        *
        *  ARGS:
        *       - String response : the user entered response
        *       - String[] possibleResponses : a list of acceptable answers
        *
        *  RETURNS:
        *       - Result : a result with a success/failure and message
        * */
        for (String possible: possibleResponses) {
            // Looping through the possibleResponses and if one matchs return a true result
            if (response.equals(possible)) {
                return new Result(true, response);
            }
        }

        // if it never returns a true, return a false
        return new Result(false, response);
    }

    private static Result canRentLocker() {
        /*
        *  Can Rent Locker checks if there are lockers left to rent
        *  and if so returns a true result otherwise will return a
        *  false result.
        *
        *  ARGS: none
        *  RETURNS:
        *       - Result: a success/failure and message
        * */
        if (ls.getNextAvailableLockerIndex() == -1) {
            // if LockerService returns a -1 for the index of the next available
            // locker, then that means there are no more lockers available
            return new Result(false, "Sorry, we are out of lockers.");
        } else {
            // if it doesn't return -1, then there are lockers left
            return new Result(true, "There are still lockers left.");
        }
    }

    private static Result isLockerInUse(Locker locker) {
        /*
        *  Is Locker In Use checks if a locker chosen by a user is not null.
        *  If a locker is null then it is not in use.
        *
        *  ARGS:
        *       - Locker locker : chosen by the user
        *  RETURNS:
        *       - Result : of a success/failure and a message
        * */
        if (locker != null) {
            return new Result(true, "That locker is in use.");
        } else {
            return new Result(false, "That locker hasn't been rented yet.");
        }
    }
}
