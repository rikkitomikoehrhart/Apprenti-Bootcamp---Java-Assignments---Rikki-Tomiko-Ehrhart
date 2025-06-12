public class QuarterIntchDriverDrillBit implements DriverBit, DrillBit {
    private static final double SIZE = 0.25;
    private static final double MAX_DEPTH = 1.25;
    private static final double DEPTH_PER_ROTATION = 0.1;
    private int numberOfRotations = 0;
    private double currentDepth = 0;

    @Override
    public void rotate() {
        numberOfRotations++;
    }

    @Override
    public void drill() {
        numberOfRotations++;
        if (currentDepth < MAX_DEPTH) {
            currentDepth = DEPTH_PER_ROTATION * numberOfRotations;
        } else {
            currentDepth = MAX_DEPTH;
        }
    }
}
