//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Part 1: Basic String Operations
        String firstName = "Harry";
        String lastName = "Potter";
        String fullName = firstName + " " + lastName;


        System.out.println("Full name: " + fullName);
        System.out.println("Length: " + fullName.length());
        System.out.println("First character: " + fullName.charAt(0));
        System.out.println("Index of 'r': " + fullName.indexOf('r'));


        // Part 2: Extracting Parts of a String
        String sentence = "Learning Java is Fun!";

        System.out.println("First word: " + sentence.substring(0, 8));
        System.out.println("Second word: " + sentence.substring(9, 13));
        System.out.println("Last word: " + sentence.substring(17));


        // Part 3: Splitting Strings
        String csvData = "apple,banana,grape,orange";
        String[] fruits = csvData.split(",");

        for (int i = 0; i < fruits.length; i++) {
            System.out.printf("Fruit %d. %s%n", i, fruits[i]);
        }


        // Part 4: Replacing Characters
        String sentence2 = "The quick brown fox";
        String sentence3 = sentence2.replace("quick", "slow");
        String sentence4 = sentence3.replace(" ", "_");
        System.out.println("Modified sentence: " + sentence4);


        // Part 5: Handling Null and Empty Strings
        String nullString = null;

        if (nullString == null) {
            System.out.println("The string is null, cannot compute length.");
        } else {
            System.out.println("The length of the string is " + nullString.length());
        }

        String emptyString = "";
        System.out.println("Empty String Length: " + emptyString.length());



    }
}