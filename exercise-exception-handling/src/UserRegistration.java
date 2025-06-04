import java.util.Scanner;

public class UserRegistration {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age;
        String email;
        int pin;

        while (true) {
            try {
                System.out.print("Enter your age: ");
                age = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("There was a Number Format Error");
                continue;
            }
        }


        while (true) {
            try {
                System.out.print("Enter your email: ");
                email = scanner.nextLine();

                if (email == null || email.trim().isEmpty()) {
                    throw new IllegalArgumentException("Email cannot be empty");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid email. Please try again.");
                continue;
            }
        }

        while (true) {
            try {
                System.out.print("Enter your 4-digit PIN: ");
                pin = Integer.parseInt(scanner.nextLine());
                if (pin < 1000 || pin > 9999) {
                    throw new PinLength("Your pin should only be 4 numbers");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("There was a Number Format Error");
                continue;
            } catch (PinLength e) {
                System.out.println("Your pin should only be 4 numbers");
                continue;
            }
        }



        System.out.println("\nRegistration Successful!");
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("PIN: " + pin);
    }

}
