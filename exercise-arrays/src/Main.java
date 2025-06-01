import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        Random random = new Random();

//        // Part 1: Basic Array Operations
//        String[] cities = new String[5];
//
//        cities[0] = "Austin";
//        cities[1] = "Bee Caves";
//        cities[2] = "Pflugerville";
//        cities[3] = "Cedar Park";
//        cities[4] = "Round Rock";
//
//        System.out.println("Cities:");
//        System.out.println(cities[0]);
//        System.out.println(cities[1]);
//        System.out.println(cities[2]);
//        System.out.println(cities[3]);
//        System.out.println(cities[4]);
//
//
//        System.out.println("\n");
//
//
//        cities[2] = "Hutto";
//        System.out.println("Cities again (this time with Hutto): ");
//        for (int i = 0; i < cities.length; i++) {
//            System.out.println(cities[i]);
//        }
//
//
//        System.out.println("\n");
//
//        System.out.println("Cities length:");
//        System.out.println(cities.length);
//
//
//        System.out.println("\n");


//        // Part 2: Iterating Over Arrays
//        System.out.println("Cities in order: ");
//        for (int i = 0; i < cities.length; i++) {
//            System.out.println(cities[i]);
//        }
//
//        System.out.println("\n");
//
//        System.out.println("Citites in reverse order:");
//        for (int i = cities.length-1; i <= 0; i--) {
//            System.out.println(cities[i]);
//        }
//
//        System.out.println("\n");
//
//        System.out.print("Enter a city: ");
//        String city = io.nextLine();
//
//        for (int i = 0; i < cities.length; i++) {
//            if (cities[i].equals(city)) {
//                System.out.println(city + " is in cities!");
//            }
//        }
//
//
//        System.out.println("\n");


//        // Part 3: Numeric Array & Calculations
//        int[] scores = {75, 85, 95, 100, 65};
//
//        int total = 0;
//        for (int i = 0; i < scores.length; i++) {
//            total += scores[i];
//        }
//
//        System.out.println("The total of the scores is: " + total);
//
//        System.out.println("\n");
//
//        int min_score = 100;
//        int max_score = 0;
//
//        for (int i = 0; i < scores.length; i++) {
//            if (scores[i] > max_score) {
//                max_score = scores[i];
//            }
//
//            if (scores[i] < min_score) {
//                min_score = scores[i];
//            }
//        }
//
//        System.out.println("The min score: " + min_score);
//        System.out.println("The max score: " + max_score);
//
//
//        System.out.println("\n");
//
//        double average = (total / 5);
//
//        System.out.printf("The average is %.2f", average);
//
//
//        System.out.println("\n");


//        // Part 4: Advanced Challenges
//        int[] randNums = new int[10];
//
//        System.out.println("Random numbers: ");
//        for (int i = 0; i < 10; i++) {
//            randNums[i] = random.nextInt(5) + 1;
//            System.out.print(randNums[i] + "   ");
//        }
//
//
//        int threeCount = 0;
//
//        for (int i = 0; i < 10; i++) {
//            if (randNums[i] == 3) {
//                threeCount++;
//            }
//        }
//
//        System.out.println("\n\nThere are " + threeCount + " threes in the random number array");
//
//        System.out.println("\n");
//
//
//        int firstElement = randNums[0];
//
//        for (int s = 1; s < randNums.length; s++) {
//            randNums[s-1] = randNums[s];
//        }
//
//        randNums[randNums.length-1] = firstElement;
//
//        for (int i = 0; i < 10; i++) {
//            System.out.print(randNums[i] + "   ");
//        }
//
//
//        String[] studentNames = {"Rikki", "Nicole", "Kellen", "Cat", "Laura", "Cat"};
//
//        for (int i = 0; i < studentNames.length; i++) {
//            for (int j = i+1; j < studentNames.length; j++) {
//                if (studentNames[i].equals(studentNames[j])){
//                    System.out.println("\n\nDuplicates found! " + studentNames[i]);
//                }
//            }
//        }


//        // Bonus Challenge: Mini Address Book
//        String[] names = {"Sam", "Nicole", "Kellen"};
//        String[] phoneNumbers = {"423-367-6793", "512-545-1776", "713-858-6943"};
//        String[] emailAddresses = {"sam.ehrhart@gmail.com", "n.morhmann@apple.com", "kellen@cityofaustin.gov"};
//
//
//        System.out.print("Enter name: ");
//        String name = io.nextLine();
//
//        System.out.println("\n");
//        for (int i = 0; i < names.length; i++) {
//            if (name.equals(names[i])) {
//                System.out.printf("%s: %s | %s", names[i], phoneNumbers[i], emailAddresses[i]);
//            }
//        }


//        // Final Challenge
//        String[] fruits = {"cherry", "grapes", "orange", "apple", "peach"};
//
//        for(int i = 0; i < fruits.length; i++) {
//            System.out.println(fruits[i]);
//        }
//
//        System.out.println("\nSorted: ");
//        for (int i = 0; i < fruits.length; i++) {
//            for (int j = 0; j < fruits.length - i - 1; j++) {
//                if (fruits[j].compareTo(fruits[j+1]) > 0) {
//                    String temp = fruits[j];
//                    fruits[j] = fruits[j+1];
//                    fruits[j+1] = temp;
//                }
//            }
//        }
//
//        for (int i = 0; i < fruits.length; i++) {
//            System.out.print(fruits[i] + "   ");
//        }
//
//
//        System.out.println("\n\n");
//        int[] randNums = new int[10];
//
//        System.out.println("Random numbers: ");
//        for (int i = 0; i < 10; i++) {
//            randNums[i] = random.nextInt(10) + 1;
//            System.out.print(randNums[i] + "   ");
//        }
//
//        System.out.println("\n");
//
//        for (int i = 0; i < randNums.length; i++) {
//            for (int j = 0; j < randNums.length - i - 1; j++) {
//                if (randNums[j] > randNums[j+1]) {
//                    int temp = randNums[j];
//                    randNums[j] = randNums[j + 1];
//                    randNums[j + 1] = temp;
//                }
//            }
//        }
//
//        System.out.println("Sorted random numbers: ");
//        for (int i = 0; i < randNums.length; i++) {
//            System.out.print(randNums[i] + "   ");
//        }


        // Bonus: Interactive Menu (Extra Practice
        String[] cities = new String[0];


        while (true){
            System.out.println("Interactive Menu: ");
            System.out.println("1. Add a new city");
            System.out.println("2. Remove a city");
            System.out.println("3. Search for a city");
            System.out.println("4. View all cities");
            System.out.println("5. Exit");

            System.out.println("Enter your selection: ");
            int choice = Integer.parseInt(io.nextLine());

            switch (choice){
                case 1:
                    System.out.print("\nWhat city would you like to add to the list?: ");
                    String city = io.nextLine();
                    cities = addToList(cities, city);

                    System.out.println("\n" + city + " was added to the list");
                    
                    System.out.println("\n\n");
                    continue;
                case 2:
                    System.out.print("\nWhat city would you like to remove from the list?: ");
                    city = io.nextLine();
                    cities = removeFromList(cities, city);

                    System.out.println("\nIf " + city + " was on the list, it no longer is.");

                    System.out.println("\n\n");
                    continue;
                case 3:
                    System.out.print("\nWhat city would you like to search for?: ");
                    city = io.nextLine();

                    boolean found = false;

                    for (int i = 0; i < cities.length; i++) {
                        if (cities[i].equals(city)) {
                            found = true;
                        }
                    }

                    if (found) {
                        System.out.println("\n" + city + " was found!");
                    } else {
                        System.out.println("\n" + city + " wasn't found!");
                    }

                    System.out.println("\n\n");
                    continue;
                case 4:
                    System.out.println("\nThe Cities: ");
                    for (int i = 0; i < cities.length; i++) {
                        System.out.println(cities[i]);
                    }

                    System.out.println("\n\n");
                    continue;
                case 5:
                    System.out.println("Thank you. Have a nice day!");
                    break;
            }




            break;
        }








    }

    public static String[] makeNewList(int defaultSize) {
        String[] newList = new String[defaultSize];

        return newList;
    }

    public static String[] addToList(String[] citiesList, String cityToAdd) {
        String[] newList = makeNewList(citiesList.length + 1);

        for (int i = 0; i < citiesList.length; i++){
            newList[i] = citiesList[i];
        }

        newList[citiesList.length] = cityToAdd;

        return newList;
    }

    public static String[] removeFromList(String[] citiesList, String cityToRemove) {
        boolean notInList = true;

        for (int i = 0; i < citiesList.length; i ++) {
            if (citiesList[i].equals(cityToRemove)) {
                notInList = false;
            }
        }

        if (notInList) {
            return citiesList;
        } else {
            String[] newList = makeNewList(citiesList.length - 1);

            int index = 0;

            for (int i = 0; i < citiesList.length; i++) {
                if (!citiesList[i].equals(cityToRemove)) {
                    newList[index] = citiesList[i];
                    index++;
                }
            }

            return newList;
        }

    }
}