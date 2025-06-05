


public class Main {
    static Locker locker = null;
    static AppUtils u = new AppUtils();
    static LockerService ls = new LockerService(10);
    static int lockerNumber;
    static String[] yeses = {"y", "Y"};



    public static void main(String[] args) {
        String[] mainMenuLockersLeft = {"\n","What would you like to do next?", "\t\t1. Rent a Locker", "\t\t2. Access a Locker", "\t\t3. Release a Locker", "\t\t---", "\t\tAny other key to exit."};
        String[] mainMenuNoLockersLeft = {"\n","What would you like to do next?", "\t\t1. **NO LOCKERS LEFT**", "\t\t2. Access a Locker", "\t\t3. Release a Locker", "\t\t---", "\t\tAny other key to exit."};


        // Welcome/Start Menu
        u.displayMessage("Welcome to the Locker App!");

        // While True
        while (true) {
            Result canRent = canRentLocker();
            if (canRent.success) {
                u.displayMessages(mainMenuLockersLeft);
            } else {
                u.displayMessages(mainMenuNoLockersLeft);
            }


            int choice = u.promptUserForInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    rentALocker();
                    continue;
                case 2:
                    accessALocker();
                    continue;
                case 3:
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
        Result result = canRentLocker();
        if (result.success) {
            locker = ls.assignLocker();
            u.displayMessages(new String[]{"\n", String.format("Thank you. \nYou're locker number is \t\t%d \nand your pin is: \t\t\t\t%s", locker.getLockerNumber() + 1, locker.getPinNumber())});

            // Clear locker variable
            clearLockerVariable();
        } else {
            u.displayMessage(result.message);
        }
    }

    private static void accessALocker() {
        locker = promptUserAndReturnLocker("access");

        if (unlockLocker(locker)) {
            u.displayMessage(locker.getIsOpen() ? "Locker is open. Please enter the phone." : "Locker is now open. Please grab the phone.");
            pressEnterToConfirmCloseLocker();
            locker.setIsOpen();
        } else {
            return;
        }

        // Clear locker variable
        clearLockerVariable();
    }

    private static void releaseALocker() {
        locker = promptUserAndReturnLocker("release");

        if (!locker.getIsOpen()) {
            if (unlockLocker(locker)) {
                locker.setIsOpen();
                Result result = isCorrectResponse(u.promptUserForString("Are you sure? (y for yes, anything else for no): "), yeses);

                if (result.success) {
                    u.displayMessage("Locker is now open. Remove phone.");
                    pressEnterToConfirmCloseLocker();
                } else {
                    return;
                }
            } else {
                return;
            }
        }

        ls.releaseLocker(locker);
        u.displayMessage("Thank you. Locker " + locker.getLockerNumber() + " has been released and is available for use.");

        // Clear locker variable
        clearLockerVariable();

    }


    // Helper Functions
    private static void clearLockerVariable() {
        locker = null;
    }

    private static Locker promptUserAndReturnLocker(String prompt) {
        while (true) {
            u.displayMessage("\n");
            lockerNumber = u.promptUserForInt("Enter the locker number you want to " + prompt + ": ");
            locker = ls.getLocker(lockerNumber);

            Result result = isLockerInUse(locker);

            if (result.success) {
                return locker;
            } else {
                u.displayMessage(result.message);
                continue;
            }
        }


    }

    private static boolean unlockLocker(Locker locker) {
        while (true) {
            Result result = isCorrectResponse(u.promptUserForString("Please enter the pin to access locker " + (locker.getLockerNumber() + 1) + ": "), new String[] {locker.getPinNumber()});
            if (result.success){
                locker.setIsOpen();
                return true;
            } else {
                u.displayMessage("Sorry, that's not correct.");
                Result contResult = isCorrectResponse(u.promptUserForString("Try again? (y for yes anything else for no): "), yeses);
                if(contResult.success) {
                    continue;
                } else {
                    break;
                }
            }
        }
        return false;
    }

    private static void pressEnterToConfirmCloseLocker() {
        u.displayMessage("And press enter to close locker.");
        u.promptUserForString(">>  ");
    }



    // Error Handling
    private static Result isCorrectResponse(String response, String[] possibleResponses) {
        for (String possible: possibleResponses) {
            if (response.equals(possible)) {
                return new Result(true, response);
            }
        }

        return new Result(false, response);
    }

    private static Result canRentLocker() {
        if (ls.getNextAvailableLockerIndex() == -1) {
            return new Result(false, "Sorry, we are out of lockers.");
        } else {
            return new Result(true, "There are still lockers left.");
        }
    }

    private static Result isLockerInUse(Locker locker) {
        if (locker != null) {
            return new Result(true, "That locker is in use.");
        } else {
            return new Result(false, "That locker hasn't been rented yet.");
        }
    }
}
