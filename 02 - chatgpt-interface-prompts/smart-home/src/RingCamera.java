public class RingCamera implements SmartDevice {
    private boolean isTurnedOn;
    private int recordings;

    public RingCamera() {
        isTurnedOn = false;
    }

    @Override
    public void turnOn() {
        if (recordings < 100) {
            isTurnedOn = true;
        } else {
            isTurnedOn = false;
            System.out.println("Error: recordings are full.");
        }
    }

    @Override
    public void turnOff() {
        isTurnedOn = false;
    }

    @Override
    public String getStatus() {
        return "There are currently " + (100 - recordings) + " recording slots left.";
    }
}
