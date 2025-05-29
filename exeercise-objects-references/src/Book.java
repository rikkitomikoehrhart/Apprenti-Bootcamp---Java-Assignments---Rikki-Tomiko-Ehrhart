public class Book {
    String title;
    String author;
    boolean isAvailable = true;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void displayStatus() {
        System.out.printf("%s by %s available: %b%n", this.title, this.author, this.isAvailable);
    }

    public void borrowBook() {
        this.isAvailable = false;
    }
}
