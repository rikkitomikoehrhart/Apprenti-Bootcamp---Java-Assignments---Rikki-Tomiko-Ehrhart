public class LockerService {
    private final Locker[] lockers;

    public LockerService(int numberOfLockers) {
        this.lockers = new Locker[numberOfLockers];
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

    public Locker assignLocker() {
        int index = getNextAvailableLockerIndex();

        if (index == -1 && getNumberOfInUseLockers() < 10) {
            index = 0;
        }

        lockers[index] = new Locker(index);

        return lockers[index];
    }

    public void releaseLocker(Locker locker) {
        lockers[locker.getNumber()] = null;
    }

    public int getNumberOfInUseLockers() {
        int counter = 0;

        for (Locker locker : lockers) {
            if (locker != null) {
                counter++;
            }
        }

        return counter;
    }
}
