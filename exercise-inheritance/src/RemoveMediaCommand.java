public class RemoveMediaCommand {

    public void execute() {
        Main.utils.displayMessage("\n\n=====  REMOVE MEDIA =====");
        if (MediaService.isEmpty()) {
            Main.utils.displayMessage("There isn't any Media in the Media Library right now.");
            Main.utils.displayMessage("Try adding some Media first!");
            return;
        }

        String mediaName = Main.utils.getString("Enter the name of the media you want to remove: ");

        if (MediaService.findMediaByName(mediaName) == null) {
            Main.utils.displayMessage("Sorry, that media isn't in the Media Library.");
        } else {
            MediaService.removeMedia(mediaName);
            Main.utils.displayMessage("Media '" + mediaName + "' Successfully Removed.");
        }

    }
}
