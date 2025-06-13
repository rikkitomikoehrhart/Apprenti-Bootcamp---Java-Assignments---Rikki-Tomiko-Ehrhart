public class FloodLights implements SmartDevice {
    private boolean isTurnedOn;
    private boolean replaceBulb;

    public FloodLights() {
        isTurnedOn = false;
        replaceBulb = false;
    }

    @Override
    public void turnOn() {
        isTurnedOn = true;
    }

    @Override
    public void turnOff() {
        isTurnedOn = false;
    }

    @Override
    public String getStatus() {
        return "Flood lights " + (replaceBulb ? "" : "don't ") + "need to be replaced.";
    }
}
