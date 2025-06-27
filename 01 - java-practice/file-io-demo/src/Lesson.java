// Required imports
import java.io.*;


public class Lesson {
    public static void main(String[] args) {

        // "colors.txt" is a relative path.
        // The file will be created in the project root
        File file = new File("colors.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("colors.txt created");
            } else {
                System.out.println("colors.txt already exists");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }



        // Writing to a file
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("colors.txt");
            writer.println("red");
            writer.println("blue");
            writer.println("yellow");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            // ALWAYS CLEAN UP!
            if (writer != null) {
                writer.close();
            }
        }


        // try-with-resources
        try (PrintWriter writer2 = new PrintWriter("colors.txt")) {
            writer2.println("red");
            writer2.println("blue");
            writer2.println("yellow");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }


        // Appending to an Existing File
        // The second FileWriter constructor argument, true,
        // indicates this is an appending write
        try (FileWriter fileWriter = new FileWriter("colors.txt", true);
             PrintWriter writer3 = new PrintWriter(fileWriter)) {
            writer3.println("green");
            writer3.println("orange");
            writer3.println("purple");
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        // Reading from a File
        System.out.println("\n-------\nFile contents: ");
        try (FileReader fileReader = new FileReader("colors.txt");
             BufferedReader reader = new BufferedReader(fileReader)) {

            // When there are no lines, readLine() returns null.
            for (String line =  reader.readLine(); line != null; line = reader.readLine()) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        // Delete a File
        File file2 = new File("colors.txt");
        boolean success = file2.delete();

        if (success) {
            System.out.println("colors.txt was deleted");
        } else {
            System.out.println("colors.txt was NOT deleted.");
        }


    }
}