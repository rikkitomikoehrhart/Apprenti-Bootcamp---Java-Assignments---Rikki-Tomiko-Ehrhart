public class LockerActions {
    public static void rentALocker(AppUtils appUtils, LockerService ls) {
        Result result = Result.canRentLocker(ls);
        if (result.success) {
            Locker locker = ls.assignLocker();
            appUtils.displayLockerAndPin(locker);

        } else {
            appUtils.displayMessage(result.message);
        }
    }

    public static void accessALocker(AppUtils appUtils, LockerService ls) {
        Locker locker = appUtils.promptUserAndReturnLocker("access", ls);

        if (unlockLocker(locker, appUtils)) {
            appUtils.displayInstructionsMessageForOpenLocker(locker.isOpen());
            appUtils.pressEnterToConfirmCloseLocker();
            locker.toggleOpen();
        }
    }

    public static void releaseALocker(AppUtils appUtils, LockerService ls) {
        Locker locker = appUtils.promptUserAndReturnLocker("release", ls);

        if (!locker.isOpen()) {
            if (unlockLocker(locker, appUtils)) {
                locker.toggleOpen();
                Result result = appUtils.areYouSurePromptToContinue();

                if (result.success) {
                    appUtils.displayInstructionsMessageForOpenLocker(true);
                    appUtils.pressEnterToConfirmCloseLocker();
                } else {
                    return;
                }
            } else {
                return;
            }
        } else {
            Result result = appUtils.areYouSurePromptToContinue();
            if (!result.success) {
                return;
            }
        }

        ls.releaseLocker(locker);
        appUtils.displayReleasedLockerNotification(locker.getNumber() + 1);

    }

    private static boolean unlockLocker(Locker locker, AppUtils appUtils) {
        while (true) {
            Result result = Result.isCorrectResponse(appUtils.promptUserForPin(locker), new String[] {locker.getPin()});
            if (result.success){
                return true;
            } else {
                Result contResult = appUtils.errorPromptToContinue();
                if(!contResult.success) {
                    return false;
                }
            }
        }
    }

}
