public class Main {
    public static void main(String[] args) {
        AppUtils appUtils = new AppUtils();
        LockerService ls = new LockerService(10);

        appUtils.displayMessage("Welcome to the Locker App!");

        while (true) {
            MenuOptions option = appUtils.mainMenu(ls);

            switch (option) {
                case RENT:
                    LockerActions.rentALocker(appUtils, ls);
                    continue;
                case ACCESS:
                    LockerActions.accessALocker(appUtils, ls);
                    continue;
                case RELEASE:
                    LockerActions.releaseALocker(appUtils, ls);
                    continue;
                default:
                    // EXIT
                    appUtils.displayMessage("Thank you! Have a great day!");
                    break;
            }
            break;
        }
    }
}
