public class Main {
    public static TerminalUtils utils = new TerminalUtils();


    public static void main(String[] args) {
        AddMediaCommand addMedia = new AddMediaCommand();
        RemoveMediaCommand removeMedia = new RemoveMediaCommand();
        PlayMediaCommand playMedia = new PlayMediaCommand();
        ListAllMediaCommand listMedia = new ListAllMediaCommand();


        utils.displayMessage("Welcome to the Media App.");

        while (true) {
            utils.displayMenu();

            int choice = utils.getMenuChoice();

            switch (choice) {
                case 1:
                    addMedia.execute();
                    continue;
                case 2:
                    removeMedia.execute();
                    continue;
                case 3:
                    playMedia.execute();
                    continue;
                case 4:
                    listMedia.execute();
                    continue;
                default:
                    utils.displayMessage("Thank you. Have a nice day.");
                    break;
            }
            break;
        }
    }
}