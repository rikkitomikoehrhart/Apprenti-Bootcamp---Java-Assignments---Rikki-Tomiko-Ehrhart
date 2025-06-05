public class LockerService {
    private Locker[] lockers;


    public LockerService(int numberOfLockers) {
        this.lockers = new Locker[numberOfLockers];
    }



    // GETS
    public Locker[] getLockersList() {
        return this.lockers;
    }

    public Locker getLocker(int lockerNumber) {
        return lockers[lockerNumber - 1];
    }

    public int getNextAvailableLockerIndex() {
        for (int i = 0; i < lockers.length; i++) {
            if (lockers[i] == null) {
                return i;
            }
        }
        return -1;
    }


    // OTHER
    public Locker assignLocker() {
        int index = getNextAvailableLockerIndex();

        lockers[index] = new Locker(index);

        return lockers[index];
    }


    public void accessLocker(Locker locker) {
        locker.setIsOpen();
    }

    public void releaseLocker(Locker locker) {
        lockers[locker.getLockerNumber()] = null;
    }

}
