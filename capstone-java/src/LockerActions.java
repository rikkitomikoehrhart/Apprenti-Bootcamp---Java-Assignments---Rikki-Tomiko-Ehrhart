public class LockerActions {

    // RENT
    public static void rentALocker() {
        Result result = Result.canRentLocker();
        if (result.success) {
            Main.locker = Main.ls.assignLocker();
            Main.appUtils.displayLockerAndPin(Main.locker);

            clearLockerVariable();
        } else {
            Main.appUtils.displayMessage(result.message);
        }
    }


    // ACCESS
    public static void accessALocker() {
        Main.locker = Main.appUtils.promptUserAndReturnLocker("access");

        if (unlockLocker(Main.locker)) {
            Main.appUtils.displayInstructionsMessageForOpenLocker(Main.locker.getIsOpen());
            Main.appUtils.pressEnterToConfirmCloseLocker();
            Main.locker.setIsOpen();
        } else {
            return;
        }

        clearLockerVariable();
    }



    // RELEASE
    public static void releaseALocker() {
        Main.locker = Main.appUtils.promptUserAndReturnLocker("release");

        if (!Main.locker.getIsOpen()) {
            if (unlockLocker(Main.locker)) {
                Main.locker.setIsOpen();
                Result result = Main.appUtils.areYouSurePromptToContinue();

                if (result.success) {
                    Main.appUtils.displayInstructionsMessageForOpenLocker(true);
                    Main.appUtils.pressEnterToConfirmCloseLocker();
                } else {
                    return;
                }
            } else {
                return;
            }
        } else {
            Result result = Main.appUtils.areYouSurePromptToContinue();
            if (!result.success) {
                return;
            }
        }

        Main.ls.releaseLocker(Main.locker);
        Main.appUtils.displayReleasedLockerNotification(Main.locker.getLockerNumber() + 1);

        clearLockerVariable();

    }



    // SETS
    private static boolean unlockLocker(Locker locker) {
        while (true) {
            Result result = Result.isCorrectResponse(Main.appUtils.promptUserForPin(locker), new String[] {locker.getPinNumber()});
            if (result.success){
                return true;
            } else {
                Result contResult = Main.appUtils.errorPromptToContinue();
                if(contResult.success) {
                    continue;
                } else {
                    return false;
                }
            }
        }
    }

    private static void clearLockerVariable() {
        Main.locker = null;
    }
}
