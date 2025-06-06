import java.util.Scanner;

public class AppUtils {
    public Scanner io = new Scanner(System.in);


    public void displayMessage(String message) {
        /*
        *  Display Message displays a singular String provided
        *
        *  ARGS:
        *       - String message : a provided string to display to the user
        *  RETURNS: none
        * */
        System.out.println(message);
    }

    public void displayMessages(String[] messages) {
        /*
        *  Display Messages takes a list of strings and loops
        *  through them displaying one at a time
        *
        *  ARGS:
        *       - String[] messages : a list of string to display to the user
        *  RETURNS: none
        * */
        for (String message : messages) {
            displayMessage(message);
        }
    }

    public String promptUserForString(String prompt) {
        /*
        *  Prompt User For String prompts the user for a string response
        *
        *  ARGS:
        *       - String prompt : a prompt to display to the user when asking
        *               for a string result
        *  RETURNS:
        *       - a string from the user
        * */
        System.out.print(prompt);

        return io.nextLine();
    }

    public int promptUserForInt(String prompt) {
        /*
        *  Prompt User For Int prompts the user for an integer response
        *
        *  ARGS:
        *       - String prompt : a prompt to display to the user when asking
        *               for an integer response
        *  RETURNS:
        *       - int Response : a verified integer response
        * */
        int response;

        while (true) {
            try {
                System.out.print(prompt);
                response = Integer.parseInt(io.nextLine());
                break;
            } catch (NumberFormatException e) {
                // User didn't enter a number, restart loop
                System.out.println("Please enter a valid number.");
                continue;
            }
        }
        return response;
    }
}
