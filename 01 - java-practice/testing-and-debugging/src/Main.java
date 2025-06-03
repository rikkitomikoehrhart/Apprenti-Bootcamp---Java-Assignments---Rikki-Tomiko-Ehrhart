

public class Main {
    public static void main(String[] args) {
//        System.out.println(reactToLight("red"));
//        System.out.println(reactToLight("yellow"));
//        System.out.println(reactToLight("green"));

        runTests();

    }

    private static String reactToLight(String color) {
        color = color.toLowerCase();

        if (color.equals("red")) {
            return "stop";
        } else if (color.equals("yellow")) {
            return "slow down";
        } else if (color.equals("green")) {
            return "continue";
        } else {
            return "stop";
        }
    }


    private static void runTests() {
        String[] inputs = {"red", "yellow", "green", "RED", "aldjfakjd"};
        String[] outputs = {"stop", "slow down", "continue", "stop", "stop"};

        for (int i = 0; i < inputs.length; i++) {
            String input = inputs[i];
            String output = outputs[i];
            System.out.println("Testing with " + input + "... ");
            String actual = reactToLight(input);

            if (output.equals(actual)) {
                System.out.println("Passed!");
            } else {
                System.out.println("FAIL: Expected '" + output + "', got '" + actual + "'");
            }
        }
    }
}