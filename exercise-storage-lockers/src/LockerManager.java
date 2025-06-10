import java.util.ArrayList;

public class LockerManager {
    public ArrayList<Locker> lockers = new ArrayList<>();          // A list to store multiple Locker Objects


    // CONSTRUCTORS
    public LockerManager(){

    }


    // GETTERS
    public int getLockerTotal() {
        return lockers.size();
    }


    // OTHER METHODS
    public void addLocker(String lockerID) {
        lockers.add(new Locker(lockerID));
    }

    public Locker getLocker(String lockerID) {
        if (lockerID == null) {
            return null;
        }
        for (Locker locker : lockers) {
            if (locker.getId() != null && locker.getId().equals(lockerID)) {
                return locker;
            }
        }
        return null;
    }

    public boolean removeLocker(String lockerID) {
        if (lockerID == null) {
            return false;
        }
        Locker locker = getLocker(lockerID);
        if (locker == null) {
            return false;
        }
        return lockers.remove(locker);
    }

    public void displayAllLockers() {
        for(int i = 0; i < lockers.size(); i++) {
            Main.u.print(lockers.get(i).toString());
        }
    }
}
