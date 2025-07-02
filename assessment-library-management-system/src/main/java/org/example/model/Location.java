package org.example.model;

public class Location {
    private int shelf;
    private int position;

    public int getShelf() {
        return shelf;
    }

    public void setShelf(int shelf) {
        this.shelf = shelf;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Location setAll(int shelf, int position) {
        this.shelf = shelf;
        this.position = position;
    }

}
