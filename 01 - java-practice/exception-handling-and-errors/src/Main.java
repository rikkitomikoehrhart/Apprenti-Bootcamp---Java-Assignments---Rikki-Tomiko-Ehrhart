import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Scanner;


public class Main {
    private static Scanner io = new Scanner(System.in);

    public static void main(String[] args) {
            // exceptions are objects, Exception Class


//        String s1 = null;
//        int length = s1.length();


    }

    public Number readNumber(String prompt) throws ParseException {
        NumberFormat formatter = NumberFormat.getInstance();

        System.out.println(prompt);
        return formatter.parse(io.nextLine());
    }


    public static int getPositiveNumber() {
        while (true) {
            System.out.print("Enter a positive number: ");
            try {
                int num = Integer.parseInt(io.nextLine());

                if (num > 0){
                    return num;
                } else {
                    System.out.println("That is not positive, try again!");
                }
            } catch (NumberFormatException ex) {
                System.out.println("That is not a number");
                System.out.println(ex.getMessage());
            } finally {
                // run code here to free up resources
            }



        }
    }
}