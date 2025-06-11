public class PlayMediaCommand {

    public void execute(TerminalUtils utils) {
        utils.displayMessage("\n=====  PLAY MEDIA =====");
        if (MediaService.isEmpty()) {
            utils.displayMessage("There isn't any Media in the Media Library right now.");
            utils.displayMessage("Try adding some Media first!");
            return;
        }

        utils.displayMessage("Select media to play: ");
        for (int i = 0; i < MediaService.getMediaCount(); i++) {
            System.out.printf("%d. %s, %s%n", (i+1), MediaService.mediaList.get(i).getName(), MediaService.mediaList.get(i).getClass().getName());
        }

        utils.displayMessage("\n");

        int mediaIndex = utils.getInt("Enter the number of the media you want to play: ");

        if (mediaIndex < 0) {
            utils.displayMessage("Sorry, that media isn't in the Media Library.");
        } else {
            MediaService.mediaList.get(mediaIndex - 1).play();
        }
    }

}
