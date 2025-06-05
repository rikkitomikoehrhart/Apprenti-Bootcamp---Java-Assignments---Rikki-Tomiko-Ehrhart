import java.util.Random;

public class Locker {
    Random random = new Random();

    private int number;
    private String pin;
    private boolean isOpen;

    public Locker(int number) {
        this.number = number;
        this.isOpen = false;

        this.pin = generatePin();
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
    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setIsOpen() {
        this.isOpen = !this.isOpen;
    }


    // OTHER
    private String generatePin() {
        String newPin = "";
        for (int i = 0; i < 4; i++) {
            int number = random.nextInt(10);

            newPin += String.format("%d", number);
        }
        return newPin;
    }


}
