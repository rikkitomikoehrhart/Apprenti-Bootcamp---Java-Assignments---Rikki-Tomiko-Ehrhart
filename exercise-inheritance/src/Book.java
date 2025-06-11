public class Book extends Media {
    private String author;
    private int pageCount;


    // GETS
    public String getAuthor() {
        return author;
    }

    public int getPageCount() {
        return pageCount;
    }


    // SETS
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }


    // ABSTRACTS
    @Override
    void play() {
        System.out.println("Opening book '" + this.getName() + "' using e-reader software");
    }

    @Override
    String getDescription() {
        return "\tName:\t\t\t" + this.getName() + "\n\tAuthor:\t\t" + this.author + "\n\tPage Count:\t\t" + this.pageCount;
    }
}
