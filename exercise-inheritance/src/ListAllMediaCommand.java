public class ListAllMediaCommand {

    public void execute(TerminalUtils utils) {
        utils.displayMessage("\n\n=====  LIST ALL MEDIA =====");
        if (MediaService.isEmpty()) {
            utils.displayMessage("There isn't any Media in the Media Library right now.");
            utils.displayMessage("Try adding some Media first!");
            return;
        }


        utils.displayMediaList(MediaService.mediaList);
    }
}
