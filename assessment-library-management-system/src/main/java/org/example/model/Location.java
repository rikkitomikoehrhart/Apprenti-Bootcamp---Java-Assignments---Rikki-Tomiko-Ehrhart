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

//    private boolean isSpotAvailable(Location[] locations) {
//        for (Location location : locations) {
//            if (location.getShelf() == this.shelf) {
//                if (location.getPosition() == this.position) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
}
