public class AddMediaCommand {

    public void execute() {
        Main.utils.displayMessage("\n\n=====  ADD NEW MEDIA =====");
        Main.utils.displayAddMenu();

        int choice = Main.utils.getMenuChoice();

        switch (choice) {
            case 1:
                MediaService.addMedia(addVideo());
                Main.utils.displayMessage("Video added successfully!\n\n");
                break;
            case 2:
                MediaService.addMedia(addAudio());
                Main.utils.displayMessage("Audio added successfully!\n\n");
                break;
            case 3:
                MediaService.addMedia(addImage());
                Main.utils.displayMessage("Image added successfully!\n\n");
                break;
            case 4:
                MediaService.addMedia(addBook());
                Main.utils.displayMessage("Book added successfully!\n\n");
                break;
            default:
                break;
        }
    }


    public Video addVideo() {
        Video video = new Video();

        video.setName(Main.utils.getString("Enter Video Name: "));
        video.setDuration(Main.utils.getInt("Enter Video Duration (minutes): "));
        video.setResolution(Main.utils.getString("Enter Video Resolution: "));

        return video;
    }

    public Audio addAudio() {
        Audio audio = new Audio();

        audio.setName(Main.utils.getString("Enter Audio Name: "));
        audio.setDuration(Main.utils.getInt("Enter Audio Duration (minutes): "));
        audio.setArtist(Main.utils.getString("Enter Audio Artist Name: "));

        return audio;
    }

    public Image addImage() {
        Image image = new Image();

        image.setName(Main.utils.getString("Enter Image Name: "));
        image.setDimensions(Main.utils.getString("Enter Image Dimensions: "));
        image.setFileFormat(Main.utils.getString("Enter Image FileFormat: "));

        return image;
    }

    public Book addBook() {
        Book book = new Book();

        book.setName(Main.utils.getString("Enter Book Name: "));
        book.setAuthor(Main.utils.getString("Enter Book Author Name: "));
        book.setPageCount(Main.utils.getInt("Enter Book Page Count: "));

        return book;
    }





}
