import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);

        System.out.println("Welcome to the Order Form");
        System.out.printf("What is your name?%n>> ");

        String name = io.nextLine();

        System.out.printf("%nHello, %s! Let's get started with your order.%n", name);


        System.out.printf("%nWhat product would you like to purchase?%n>> ");
        String item = io.nextLine();


        System.out.printf("%nHow many would you like?%n>> ");
        int quantity = Integer.parseInt(io.nextLine());

        System.out.printf("%nWhat is the unit price?%n>> ");
        float price = Float.parseFloat(io.nextLine());


        float subtotal = quantity * price;
        float tax = subtotal * 0.07f;
        float total = subtotal + tax;


        System.out.printf("%n%nOrder Summary%n");
        System.out.println("---------------------------------------");
        System.out.printf("%-15s%-15s%n", "Item: ", item);
        System.out.printf("%-15s%-15s%n", "Quantity: ", quantity);
        System.out.printf("%-15s$%-15.2f%n", "Unit Price: ", price);
        System.out.println("---------------------------------------");
        System.out.printf("%-15s$%-15.2f%n", "Subtotal: ", subtotal);
        System.out.printf("%-15s$%-15.2f%n", "Tax: ", tax);
        System.out.printf("%-15s$%-15.2f%n", "Grand Total: ", total);
        System.out.println("---------------------------------------");
        System.out.println("Thank you for your order, " + name + "!");



    }
}