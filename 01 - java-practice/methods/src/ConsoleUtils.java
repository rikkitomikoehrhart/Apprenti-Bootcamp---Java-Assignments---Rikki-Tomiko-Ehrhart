import java.util.Scanner;

public class ConsoleUtils {
    public static String getNonEmptyString(String prompt) {
        Scanner io = new Scanner(System.in);

        String userName;

        do {
            System.out.print(prompt);
            userName = io.nextLine();
        } while (userName.length() == 0);

        return userName;
    }
}
