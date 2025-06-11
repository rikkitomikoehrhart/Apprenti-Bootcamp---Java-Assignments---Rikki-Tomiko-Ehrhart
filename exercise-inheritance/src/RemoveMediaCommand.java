public class RemoveMediaCommand {

    public void execute(TerminalUtils utils) {
        utils.displayMessage("\n=====  REMOVE MEDIA =====");
        if (MediaService.isEmpty()) {
            utils.displayMessage("There isn't any Media in the Media Library right now.");
            utils.displayMessage("Try adding some Media first!");
            return;
        }

        String mediaName = utils.getString("Enter the name of the media you want to remove: ");

        if (MediaService.findMediaByName(mediaName) == null) {
            utils.displayMessage("Sorry, that media isn't in the Media Library.");
        } else {
            MediaService.removeMedia(mediaName);
            utils.displayMessage("Media '" + mediaName + "' Successfully Removed.");
        }

    }
}
