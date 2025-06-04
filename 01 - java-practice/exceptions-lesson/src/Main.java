


public class Main {
    public static void main(String[] args) {
        String input = null;
        int value = 0;

        try {
            value = Integer.parseInt(input);
            System.out.println("Your value is: " + value); // doesn't execute
        } catch (NumberFormatException ex) {
            System.out.println("I acknowledge I may receive a NumberFormatException. ");
            System.out.println("It's okay. I have a plan. ");
            System.out.println(ex);
        }



        try {
            input = "this is definitely not a number";
            value = Integer.parseInt(input);
            System.out.println("Your value is: " + value); // doesn't execute
        } catch (NumberFormatException ex) {
            System.out.println("I acknowledge I may receive a NumberFromatException. ");
            System.out.println("I am not defeated. There's still hope.");
            System.out.println(ex);
        }


        try {
            input = "27";
            value = Integer.parseInt(input);
            System.out.println("Your value is: " + value); // executes
        } catch (NumberFormatException ex) {
            System.out.println("I acknowledge I may receive a NumberFormatException.");
            System.out.println("Hmmmm. Not sure what to do if this fails...");
            System.out.println(ex);
        }



//        // 1. java.lang.NullPointerException
//        int length = value.length();
//
//        // 2. java.lang.ArrayIndexOutOfBoundsException
//        int element = numbers[1];
//
//        // 3. java.lang.NumberFormatException
//        int n = Integer.parseInt(value);

    }
}