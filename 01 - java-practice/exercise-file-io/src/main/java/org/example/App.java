package org.example;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        // Part 1: Create a new File
        File file = new File("student_data.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("student_data.txt was created");
            } else {
                System.out.println("student_data.txt already exists");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        // Part 2: Write Data to the File
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
            writer.println("Alice, A");
            writer.println("Bob, B");
            writer.println("Charlie, A+");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }


        // Part 3: Append Data to the File
        try (FileWriter fileWriter = new FileWriter("student_data.txt", true);
             PrintWriter appender = new PrintWriter(fileWriter)) {
            appender.println("David, B+");
            appender.println("Eva, A");
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        // Part 4: Read Data from the File
        try (FileReader fileReader = new FileReader(file);
             BufferedReader reader = new BufferedReader(fileReader)) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        // Part 5: Path Exploration
        Path path = Paths.get("student_data.txt");
        System.out.println(path);
        System.out.println(path.toAbsolutePath());


        // Part 6: Delete the File
        boolean success = file.delete();
        if (success) {
            System.out.println("student_data.txt was deleted.");
        } else {
            System.out.println("student_data.txt was NOT deleted.");
        }
    }
}
