public class Locker {
    private final int lockerNumber; // write once in the constructor

    public Locker(int lockerNumber) {
        this.lockerNumber = lockerNumber;

        // This is now a constant and cannot be rewritten.
    }

    public void someMethod(final Foo object) {
        // object is a constant
//        object = new Foo("data");

        // and protects it from breaking the reference chain in memory
    }
}


