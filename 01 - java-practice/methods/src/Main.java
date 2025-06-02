import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sum = add(5, 10);

        System.out.println(sum);

        Person p = new Person("Rikki", 38);
        p.printInfo();

        String userName = ConsoleUtils.getNonEmptyString("Enter your username: ");
        String favFood = ConsoleUtils.getNonEmptyString("What is your favorite food: ");
        System.out.println(userName);
        System.out.println(favFood);

    }


    // Accessor, static/not, type, name, (parameters)
    public static int add(int x, int y) {
        return x + y;
    }




}