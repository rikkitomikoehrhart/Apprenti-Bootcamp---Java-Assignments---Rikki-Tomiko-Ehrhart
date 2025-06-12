public class DoorLocks implements SmartDevice {
    private boolean isLocked;

    public DoorLocks() {
        this.isLocked = false;
    }


    @Override
    public void turnOn() {
        this.isLocked = true;
    }

    @Override
    public void turnOff() {
        this.isLocked = false;
    }

    @Override
    public String getStatus() {
        return "The doors are " + (isLocked ? "locked" : "unlocked") + ".";
    }
}
