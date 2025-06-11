public class Image extends Media {
    private String dimensions;
    private String fileFormat;

    public String getDimensions() {
        return dimensions;
    }

    public String getFileFormat() {
        return fileFormat;
    }


    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }


    @Override
    void play() {
        System.out.println("Displaying image '" + this.getName() + "' using image viewer software");
    }

    @Override
    String getDescription() {
        return "\tName:\t\t\t" + this.getName() + "\n\tDimensions:\t\t" + this.dimensions + "\n\tFile Format:\t\t" + this.fileFormat;
    }
}
