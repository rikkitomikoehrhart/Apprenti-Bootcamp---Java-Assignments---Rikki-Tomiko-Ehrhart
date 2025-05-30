import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);

        int count = 0;

        while (count < 5) {
            System.out.println(count);
            count ++;
        }

        int dayNum;

        do {
            System.out.println("Enter a day number: ");
            dayNum = Integer.parseInt(io.nextLine());
        } while (dayNum < 0 || dayNum > 7);


        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }

        String word = "Hello";
        for (int i = 0; i < word.length(); i++) {
            // can use break to break the loop and continue to skip
            // a round
        }

    }
}
