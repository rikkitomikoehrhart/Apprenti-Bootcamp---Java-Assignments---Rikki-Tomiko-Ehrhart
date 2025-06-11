public class AddMediaCommand {

    public void execute(TerminalUtils utils) {
        utils.displayMessage("\n=====  ADD NEW MEDIA =====");
        utils.displayAddMenu();

        int choice = utils.getMenuChoice();

        switch (choice) {
            case 1:
                MediaService.addMedia(addVideo(utils));
                utils.displayMessage("Video added successfully!\n\n");
                break;
            case 2:
                MediaService.addMedia(addAudio(utils));
                utils.displayMessage("Audio added successfully!\n\n");
                break;
            case 3:
                MediaService.addMedia(addImage(utils));
                utils.displayMessage("Image added successfully!\n\n");
                break;
            case 4:
                MediaService.addMedia(addBook(utils));
                utils.displayMessage("Book added successfully!\n\n");
                break;
            default:
                break;
        }
    }


    public Video addVideo(TerminalUtils utils) {
        Video video = new Video();

        video.setName(utils.getString("Enter Video Name: "));
        video.setDuration(utils.getInt("Enter Video Duration (minutes): "));
        video.setResolution(utils.getString("Enter Video Resolution: "));

        return video;
    }

    public Audio addAudio(TerminalUtils utils) {
        Audio audio = new Audio();

        audio.setName(utils.getString("Enter Audio Name: "));
        audio.setDuration(utils.getInt("Enter Audio Duration (minutes): "));
        audio.setArtist(utils.getString("Enter Audio Artist Name: "));

        return audio;
    }

    public Image addImage(TerminalUtils utils) {
        Image image = new Image();

        image.setName(utils.getString("Enter Image Name: "));
        image.setDimensions(utils.getString("Enter Image Dimensions: "));
        image.setFileFormat(utils.getString("Enter Image FileFormat: "));

        return image;
    }

    public Book addBook(TerminalUtils utils) {
        Book book = new Book();

        book.setName(utils.getString("Enter Book Name: "));
        book.setAuthor(utils.getString("Enter Book Author Name: "));
        book.setPageCount(utils.getInt("Enter Book Page Count: "));

        return book;
    }





}
