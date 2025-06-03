public class Program {
    public static void main(String[] args) {
        System.out.println("Program Start");    // added print statement

        countdownMethod(3);

        System.out.println("Another test example");

        countdownMethod(10);

        System.out.println("Program End");      // added print statement
    }

    public static void countdownMethod(int number) {
        System.out.println("Start of method");  // added print statement

        for (int i = number; i > 0; i--) {
            System.out.println(i);
        }

        System.out.println("Blast off!");

        System.out.println("End of method");    // added print statement
    }
}
