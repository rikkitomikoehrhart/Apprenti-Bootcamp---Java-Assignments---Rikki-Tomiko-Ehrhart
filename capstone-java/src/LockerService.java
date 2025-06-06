public class LockerService {
    private Locker[] lockers;


    public LockerService(int numberOfLockers) {
        this.lockers = new Locker[numberOfLockers];
    }



    // GETS
    public Locker getLocker(int lockerNumber) {
        return lockers[lockerNumber - 1];
    }




    // OTHER
    public int getNextAvailableLockerIndex() {
        /*
        *  Get Next Available Locker Index loops through the list of lockers
        *  and finds the first null locker and returns it's index or -1 if
        *  there are no null locker spots left
        *
        *  ARGS: none
        *  RETURNS:
        *       - index (or -1) depending on the null locker
        * */
        for (int i = 0; i < lockers.length; i++) {
            if (lockers[i] == null) {
                return i;
            }
        }
        return -1;
    }


    public Locker assignLocker() {
        /*
        *  Assign Locker grabs the next available locker spot and
        *  Creates a new locker in that spot with that index number
        *
        *  ARGS: none
        *  RETURNS:
        *       - Locker locker[index] : returns the newly created locker
        * */
        int index = getNextAvailableLockerIndex();

        lockers[index] = new Locker(index);

        return lockers[index];
    }


    public void releaseLocker(Locker locker) {
        /*
        *  Release Locker sets the locker to null
        *
        *  ARGS:
        *       - Locker locker : the locker that user wants to release
        *  RETURNS: none
        * */
        lockers[locker.getLockerNumber()] = null;
    }

}
