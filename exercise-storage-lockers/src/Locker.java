import static java.lang.Integer.parseInt;

public class Locker {
    private String id;              // a unique identifier for the locker
    private boolean isOccupied;     // indicates whether the locker is currently in use
    private String contents;        // description of the contents in the locker (default is an empty string)


    // CONSTRUCTORS
    public Locker(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Locker ID cannot be null or empty");
        }
        this.id = id.trim();
        isOccupied = false;
        contents = "";
    }


    // GETTERS
    public String getId() {
        return id;
    }

    public boolean getIsOccupied() {
        return isOccupied;
    }

    public String getContents() {
        return contents;
    }


    // SETTERS
    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Locker ID cannot be null or empty");
        }
        this.id = id.trim();
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public void setContents(String contents) {
        this.contents = contents != null ? contents : "";
    }


    // OTHER METHODS
    public void storeItem(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (isOccupied) {
            throw new IllegalStateException("Locker is already occupied");
        }
        this.setOccupied(true);
        contents = item;
    }

    public void removeItem() {
        if (!isOccupied) {
            throw new IllegalStateException("Locker is already empty");
        }
        this.setOccupied(false);
        contents = "";
    }

    public String toString() {
        return String.format("%n=======%nLocker ID %s:%nOccupied: %b%nContents: %s%n=======%n",
            this.id, this.isOccupied, this.contents);
    }

}
