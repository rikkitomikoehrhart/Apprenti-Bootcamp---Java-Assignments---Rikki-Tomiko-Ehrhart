import java.util.Random;

public class Locker {
    Random random = new Random();

    private int number;
    private String pin;
    private boolean isOpen;

    public Locker(int number) {
        this.number = number;
        this.isOpen = false;        // All lockers start off closed


        this.pin = generatePin();   // Generate a PIN
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
    private String generatePin() {
        /*
        *  Generate Pin creates a random 4 digit pin
        *
        *  ARGS: none
        *  RETURNS:
        *       - String newPin : a random 4 digit pin in String form
        * */
        String newPin = "";
        for (int i = 0; i < 4; i++) {
            int number = random.nextInt(10);

            newPin += String.format("%d", number);
        }
        return newPin;
    }


}
