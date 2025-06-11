import java.util.Random;

public class Locker {
    Random random = new Random();

    private final int number;
    private String pin;
    private boolean isOpen;

    public Locker(int number) {
        this.number = number;
        this.isOpen = false;        // All lockers start off closed

        this.pin = "";
        generatePin();   // Generate a PIN
    }

    public int getNumber() {
        return this.number;
    }

    public String getPin() {
        return this.pin;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void toggleOpen() {
        this.isOpen = !this.isOpen;
    }

    private void generatePin() {
        for (int i = 0; i < 4; i++) {
            int number = random.nextInt(10);

            this.pin += String.format("%d", number);
        }
    }
}
