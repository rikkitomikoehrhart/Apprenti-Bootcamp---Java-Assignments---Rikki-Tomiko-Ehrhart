import java.util.Scanner;

public class AppUtils {
    public Scanner io = new Scanner(System.in);


    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayMessages(String[] messages) {
        for (String message : messages) {
            displayMessage(message);
        }
    }

    public String promptUserForString(String prompt) {
        System.out.print(prompt);

        return io.nextLine();
    }

    public int promptUserForInt(String prompt) {
        int response;

        while (true) {
            try {
                System.out.println(prompt);
                response = Integer.parseInt(io.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }
        }
        return response;
    }
}
