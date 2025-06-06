public class Main {
    static Locker locker = null;
    static AppUtils appUtils = new AppUtils();
    static LockerService ls = new LockerService(10);


    public static void main(String[] args) {
        appUtils.displayMessage("Welcome to the Locker App!");


        while (true) {
            MenuOptions option = appUtils.mainMenu();

            switch (option) {
                case RENT:
                    LockerActions.rentALocker();
                    continue;
                case ACCESS:
                    LockerActions.accessALocker();
                    continue;
                case RELEASE:
                    LockerActions.releaseALocker();
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
