import java.util.Scanner;
import java.util.List;

public class TerminalUtils {
    Scanner io = new Scanner(System.in);


    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void print(String message) {
        System.out.print(message);
    }

    public void displayMediaList(List<Media> mediaList) {
        for (int i = 0; i < mediaList.size(); i++) {
            System.out.printf("%d. %s:%n", (i+1), mediaList.get(i).getClass().getName());
            System.out.println(mediaList.get(i).getDescription());
        }
    }



    public String getString(String prompt) {
        String answer = "";
        while (true) {
            print(prompt);
            answer = io.nextLine();

            if (answer == "" || answer == null) {
                displayMessage("Error: entry blank. Please enter something.");
                continue;
            } else {
                break;
            }
        }
        return answer;
    }

    public int getInt(String prompt) {
        int answer = -1;
        while (true) {
            try {
                print(prompt);
                answer = Integer.parseInt(io.nextLine());
            } catch (NumberFormatException e) {
                displayMessage("Error: not a number. Please enter a number.");
                continue;
            }
            break;
        }
        return answer;
    }



    public void displayMenu() {
        displayMessage("=====================");
        displayMessage("1. Add Media");
        displayMessage("2. Remove Media");
        displayMessage("3. Play Media");
        displayMessage("4. List All Media");
        displayMessage("Or any other number to Exit.");
    }

    public void displayAddMenu() {
        displayMessage("=====================");
        displayMessage("1. Video");
        displayMessage("2. Audio");
        displayMessage("3. Image");
        displayMessage("4. Book");
        displayMessage("Or any other number to Exit.");
    }

    public int getMenuChoice() {
        int answer = 0;
        while (true) {
            try {
                print(">> ");
                answer = Integer.parseInt(io.nextLine());

                if (answer < 0 || answer > 4) {
                    return 0;
                }
            } catch (NumberFormatException e) {
                displayMessage("Error: not a number. Please enter a number.");
                continue;
            }
            break;
        }
        return answer;
    }

}
