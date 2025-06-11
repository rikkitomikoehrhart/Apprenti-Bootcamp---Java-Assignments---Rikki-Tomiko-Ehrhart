import java.util.Random;

public class Locker {
    Random random = new Random();

    private int number;
    private String pin;
    private boolean isOpen;

    public Locker(int number) {
        this.number = number;
        this.isOpen = false;        // All lockers start off closed

        this.pin = "";
        generatePin();   // Generate a PIN
    }



    // GETS
    public int getLockerNumber() {
        return this.number;
    }

    public String getPinNumber() {
        return this.pin;
    }

    public boolean getIsOpen() {
        return this.isOpen;
    }



    // SETS
    public void setIsOpen() {
        this.isOpen = !this.isOpen;
    }


    // OTHER
    private void generatePin() {
        for (int i = 0; i < 4; i++) {
            int number = random.nextInt(10);

            this.pin += String.format("%d", number);
        }
    }


}
