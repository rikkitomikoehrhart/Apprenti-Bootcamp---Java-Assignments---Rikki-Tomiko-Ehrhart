public class ListAllMediaCommand {

    public void execute() {
        Main.utils.displayMessage("\n\n=====  LIST ALL MEDIA =====");
        if (MediaService.isEmpty()) {
            Main.utils.displayMessage("There isn't any Media in the Media Library right now.");
            Main.utils.displayMessage("Try adding some Media first!");
            return;
        }


        Main.utils.displayMediaList(MediaService.mediaList);
    }
}
