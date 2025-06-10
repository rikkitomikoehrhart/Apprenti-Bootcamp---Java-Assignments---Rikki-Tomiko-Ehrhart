public class Book {
    private String title;
    private String author;
    private String ISBN;
    private String checkedOutBy;


    // CONSTRUCTORS
    public Book() {
        this.checkedOutBy = null;
    }

    public Book(String title, String author, String ISBN, String checkedOutBy) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.checkedOutBy = checkedOutBy;
    }


    // GETTERS
    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public String getCheckedOutBy() {
        return this.checkedOutBy;
    }


    // SETTERS
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setCheckedOutBy(String checkedOutBy) {
        this.checkedOutBy = checkedOutBy;
    }


    // CHECKERS
    public boolean isCheckedOut() {
        return checkedOutBy != null;
    }

}
