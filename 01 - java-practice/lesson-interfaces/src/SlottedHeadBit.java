public class SlottedHeadBit implements DriverBit {
    private static final int SIZE = 1;
    private int numberOfRotation = 0;

    @Override
    public void rotate(){
        numberOfRotation += 2;
    }
}
