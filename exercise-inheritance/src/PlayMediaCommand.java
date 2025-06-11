public class PlayMediaCommand {

    public void execute() {
        Main.utils.displayMessage("\n\n=====  PLAY MEDIA =====");
        if (MediaService.isEmpty()) {
            Main.utils.displayMessage("There isn't any Media in the Media Library right now.");
            Main.utils.displayMessage("Try adding some Media first!");
            return;
        }

        Main.utils.displayMessage("Select media to play: ");
        for (int i = 0; i < MediaService.getMediaCount(); i++) {
            System.out.printf("%d. %s, %s%n", (i+1), MediaService.mediaList.get(i).getName(), MediaService.mediaList.get(i).getClass().getName());
        }

        Main.utils.displayMessage("\n");

        int mediaIndex = Main.utils.getInt("Enter the number of the media you want to play: ");

        if (mediaIndex < 0) {
            Main.utils.displayMessage("Sorry, that media isn't in the Media Library.");
        } else {
            MediaService.mediaList.get(mediaIndex - 1).play();
        }
    }

}
