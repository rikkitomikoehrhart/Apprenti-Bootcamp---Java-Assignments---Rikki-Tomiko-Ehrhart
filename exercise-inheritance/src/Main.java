public class Main {
    public static void main(String[] args) {
        AddMediaCommand addMedia = new AddMediaCommand();
        RemoveMediaCommand removeMedia = new RemoveMediaCommand();
        PlayMediaCommand playMedia = new PlayMediaCommand();
        ListAllMediaCommand listMedia = new ListAllMediaCommand();
        TerminalUtils utils = new TerminalUtils();

        utils.displayMessage("Welcome to the Media App.");

        while (true) {
            utils.displayMenu();

            int choice = utils.getMenuChoice();

            switch (choice) {
                case 1:
                    addMedia.execute(utils);
                    continue;
                case 2:
                    removeMedia.execute(utils);
                    continue;
                case 3:
                    playMedia.execute(utils);
                    continue;
                case 4:
                    listMedia.execute(utils);
                    continue;
                default:
                    utils.displayMessage("Thank you. Have a nice day.");
                    break;
            }
            break;
        }
    }
}