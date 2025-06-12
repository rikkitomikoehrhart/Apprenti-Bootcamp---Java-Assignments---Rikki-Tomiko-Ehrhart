public class PhillipsHeadBit implements DriverBit {
    // keyword "implements" instead of "extends"

    private static final int SIZE = 2;
    private int numberOfRotations = 0;

    @Override
    public void rotate() {
        numberOfRotations++;
    }
}
