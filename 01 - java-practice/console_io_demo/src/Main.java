import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ////////////////////
        //     STRINGS    //
        /// ////////////////

        String iceCream = "Mint chocolate chip";

        String s1 = "house";
        String s2 = "mouse";
        String s3 = "house";
        String s4 = new String("house");


        // Always use .equals() for comparisons because sometimes you
        // are pointing to a different memory location
        System.out.println(s1.equals(s3));
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
        System.out.println(s1.equals(s4));


        s1 = "Sprocket";
        int length = s1.length();
        System.out.printf("The string %s has a length of %d.%n", s1, length);

        int o = s1.indexOf('o');
        System.out.printf("We found an 'o' at %d.%n", o);

        String name = "Joe Somebody";
        int space = name.indexOf(' ');
        String firstName = name.substring(0, space);

        String csv = "red,green,blue";
        String[] colors = csv.split(",");

        for (int start = 0; start < colors.length; start++){
            System.out.println(colors[start]);
        }

        Dog myDog = new Dog("Durzo", 4, "Corgi");





        ////////////////////
        //       IO       //
        /// ////////////////


 //        // Type name    initialize / assign
////        Scanner io = new Scanner(System.in);
////
////
////        System.out.print("Enter your name: ");
////        String name = io.nextLine();
////
////
////        System.out.print("Enter your favorite movie: ");
////        String movie = io.nextLine();
////
////
////        System.out.print("Enter your age: ");
////        int age = Integer.parseInt(io.nextLine());
////
////
////        System.out.print("Enter the price: $");
////        double price = Double.parseDouble(io.nextLine());
//
//        // Formatted Printing
//        // %s = String
//        // %d = digit (integers, whole numbers)
//        // %f = floating point (double, float)
//        // %c = character
//        // %b = boolean
//        // %x = hexadecimal
//        // %e = scientific
//        // %n = adds a newline
////        System.out.printf("%s, you are %d years old. Your favorite movie is %s.", name, age, movie);
////        System.out.printf("The total price is $%.2f");
//
//
//        // Alignment
//        System.out.printf("|%10s|%n", "Hello"); // right aligned, padded 10 spaces
//        System.out.printf("|%-10s|%n", "Hello"); // left aligned, padded 10 spaces
//
//        int upc = 1284;
//        System.out.printf("Bar code: %010d%n", upc);


    }
}