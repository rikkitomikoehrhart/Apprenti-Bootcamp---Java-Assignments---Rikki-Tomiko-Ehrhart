import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        String[] menuItems = {"water", "soda", "juice"};
        String[] inputs = {"WATER", "Tea", " "};
        String[] outputs = {"You selected Water", "You selected Tea", "You selected  "};

        runTests(inputs, outputs);

        boolean match = false;

        while (!match) {
            displayMenu(menuItems);

            String item = io.nextLine();

            for (int i = 0; i < menuItems.length; i++){
                if (item.equals(menuItems[i])){
                    match = true;
                    System.out.println(selectDrink(item));
                }
            }


        }


    }

    private static void displayMenu(String[] choices) {
        for (int i = 0; i < choices.length; i++) {
            System.out.println(i + 1 + ". " + choices[i].substring(0, 1).toUpperCase() + choices[i].substring(1));
        }
    }

    private static String selectDrink(String item) {
        System.out.println("Recieved input: " + item);
        System.out.println("Lowercased input: " + item.toLowerCase());
        return "You selected " + item.substring(0, 1).toUpperCase() + item.substring(1).toLowerCase();
    }



    // RUN TESTS
    private static void runTests(String[] inputs, String[] outputs) {
        for (int i = 0; i < inputs.length; i++) {
            String input = inputs[i];
            String output = outputs[i];

            String actual = selectDrink(input);
            if (input.equals(" ")) {
                input = "Empty Input";
            }
            System.out.print("Testing with " + input + "...\t");


            if (output.equals(actual)) {
                System.out.println("PASSED!");
            } else {
                System.out.println("FAIL: \nExpected '" + output + "', got '" + actual + "'");
            }
        }

    }
}
