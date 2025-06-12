
public class Main {
    public static void main(String[] args) {
        // Code to interfaces not to implementations

        DrillBit myDrill;
        DriverBit myBit = new PhillipsHeadBit();
        myBit.rotate();

        myBit = new SlottedHeadBit();
        myBit.rotate();

        // This uses two interfaces.
        QuarterIntchDriverDrillBit drillAndDriver = new QuarterIntchDriverDrillBit();

        myBit = drillAndDriver;
        myBit.rotate();

        myDrill = drillAndDriver;
        myDrill.drill();
    }
}