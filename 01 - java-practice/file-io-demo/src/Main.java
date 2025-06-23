import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Working Directory: " + System.getProperty("user.dir"));
//        File file = new File("data/input.txt");
//
//        System.out.println(file.exists());
//        System.out.println(file.isFile());
//        System.out.println(file.isDirectory());
//        System.out.println(file.length());
//
//        File file2 = new File("data/poem.txt");
//        try {
//            boolean created = file2.createNewFile();
//            System.out.println(file2.getAbsoluteFile());
//            scanner.nextLine();
//            boolean deleted = file2.delete();
//        } catch (IOException e) {
//            System.out.println("Couldn't create file!");
//        }


//        try {
//            FileWriter writer = new FileWriter("data/output.txt");
//            writer.write("Hello, World!\n");
//            writer.write("Today is a good day for Java!\n");
//            writer.write("Happy June!\n");
//            writer.close();
//        } catch (IOException e) {
//            System.out.println(e);
//        }

//        try {
//            PrintWriter writer = new PrintWriter("data/output.txt");
//            writer.println("Hello, World!");
//            writer.println("Today is a good day for Java!");
//            writer.println("Happy June!");
//            writer.print("Here is a ");
//            writer.printf("Number: %d", 15);
//
//            writer.close();
//        } catch (IOException e) {
//            System.out.println(e);
//        }


//        try {
//            FileReader reader = new FileReader("data/output.txt");
//            int charCode;
//
//            while((charCode = reader.read()) != -1) {
//                char c = (char) charCode;
//                System.out.print(c);
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println(e);
//        } catch (IOException e) {
//            System.out.println(e);
//        }

//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("data/output.txt"));
//            String line;
//
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            System.out.println(e);
//        }


        // Putting it in the try () parenthesis will automatically close files when it is done
        try (BufferedReader reader = new BufferedReader(new FileReader("data/output.txt"))){
            String line;

            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println(e);
        }




    }
}