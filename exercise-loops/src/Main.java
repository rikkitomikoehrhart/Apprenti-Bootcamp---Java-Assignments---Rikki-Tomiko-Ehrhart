import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        Random random = new Random();

//        // Count Up
//        for (int i = 0; i <= 100; i+=2) {
//            System.out.println(i);
//        }

//        // Countdown Timer
//        System.out.print("Enter a starting number: ");
//        int startingNumber = Integer.parseInt(io.nextLine());
//
//        while (startingNumber >= 0) {
//            System.out.println(startingNumber);
//            startingNumber--;
//        }
//        System.out.println("Blast off!");


//        // Guess the Number
//        int randomNumber = random.nextInt(51);
//        int guess;
//        do {
//            System.out.print("Guess the number: ");
//            guess = Integer.parseInt(io.nextLine());
//        } while (guess != randomNumber);
//
//        System.out.println("The random number was: " + randomNumber);

//        // Multiplication Tables
//        System.out.print("Enter a number: ");
//        int number = Integer.parseInt(io.nextLine());
//
//        for (int i = 1; i <= 10; i++) {
//            System.out.printf("%d x %d = %d%n", number, i, (number*i));
//        }

//        // Password Validator
//        String password = "letmein";
//        System.out.print("Enter the password: ");
//        String userPassword = io.nextLine();
//
//        while (!userPassword.equals(password)) {
//            System.out.print("\nThat is incorrect. Enter the password: ");
//            userPassword = io.nextLine();
//        }

//        // First vowel
//        System.out.print("Enter a word: ");
//        String word = io.nextLine();
//
//        loop :for (int i = 0; i < word.length(); i++) {
//            switch (word.charAt(i)) {
//                case 'a':
//                case 'e':
//                case 'i':
//                case 'o':
//                case 'u':
//                case 'A':
//                case 'E':
//                case 'I':
//                case 'O':
//                case 'U':
//                    System.out.println("\n\nThe vowel " + word.charAt(i) + " is in place " + i );
//                    break loop;
//            }


//        // Simple ATM System (Do-While Loop)
//        double accountBalance = 500.0f;
//        int choice;
//
//        do {
//            System.out.println("1. Withdraw");
//            System.out.println("2. Deposit");
//            System.out.println("3. Check Balance");
//            System.out.println("4. Exit");
//            System.out.print("Please make a selection: ");
//
//            choice = Integer.parseInt(io.nextLine());
//        } while (choice > 0 && choice < 5);


//        // Fizz Buzz:
//        for (int i = 1; i <= 100; i++) {
//            if (i % 3 == 0 && i % 5 == 0) {
//                System.out.println("FizzBuzz");
//            } else if (i % 3 == 0) {
//                System.out.println("Fizz");
//            } else if (i % 5 == 0) {
//                System.out.println("Buzz");
//            } else {
//                System.out.println(i);
//            }
//        }


//            // Reverse a String
//        System.out.print("Enter a word: ");
//        String word = io.nextLine();
//
//        for (int i = word.length()-1; i >=0; i--) {
//            System.out.println(word.charAt(i));
//        }

//            // Prime Number Checker
//        System.out.print("Enter a number: ");
//        int number = Integer.parseInt(io.nextLine());
//        boolean isPrime = true;
//
//
//
//        if (number == 1 || number == 2) {
//            isPrime = true;
//        } else {
//            while (true) {
//                for (int i = number - 1; i > 1; i--) {
//                    if (number % i == 0) {
//                        isPrime = false;
//                        break;
//                    }
//                }
//                break;
//            }
//        }
//
//
//        if (isPrime) {
//            System.out.printf("%n%d is Prime!", number);
//        } else {
//            System.out.printf("%n%d is not Prime!", number);
//        }


//            // Word Counter
//        System.out.print("Enter a sentence: ");
//        String sentence = io.nextLine();
//        int counter = 1;
//
//        for (int i = 0; i < sentence.length(); i++) {
//            if (sentence.charAt(i) == ' ') {
//                counter++;
//            }
//        }
//
//        System.out.println("There are " + counter + " words in your sentence");


//        // Skip Negative Numbers
//        int number = 0;
//        do {
//            System.out.print("Enter a number or 0 to quit: ");
//            number = Integer.parseInt(io.nextLine());
//
//            if (number < 0) {
//                continue;
//            } else {
//                System.out.println("The number you entered was: " + number);
//            }
//        } while (number != 0);


//        // Find First Prime Number
//        System.out.print("Enter the first number in the range: ");
//        int first = Integer.parseInt(io.nextLine());
//        System.out.print("\n\nEnter the last number in the range: ");
//        int last = Integer.parseInt(io.nextLine());
//
//        System.out.print("\n\n");
//        int prime = 0;
//
//        for (int i = first; i <= last; i++) {
//            int num = isPrime(i);
//
//            if (num != 0) {
//                prime = num;
//                break;
//            }
//        }
//
//        if (prime != 0) {
//            System.out.printf("%n%nThe first prime number is %d", prime);
//        } else {
//            System.out.println("\n\nThere wasn't a prime number in that range.");
//        }


//        // Fix the Infinite Loop
//        int i = 0;
//        while (i <= 10) {
//            System.out.println(i);
//            i++;
//        }

//        // Even Number Checker
//        int num = 0;
//        do {
//            System.out.print("\nEnter an even number: ");
//            num = Integer.parseInt(io.nextLine());
//
//        } while(num % 2 != 0);


//        // Bank Withdrawal System
//        double balance = 1000.00f;
//        System.out.println("Your current balance is: $" + balance);
//
//        while (balance > 0.0f) {
//            System.out.print("\n\nHow much would you like to withdrawal?: $");
//            double withdrawal = Double.parseDouble(io.nextLine());
//
//            if (withdrawal <= balance) {
//                balance -= withdrawal;
//                System.out.println("\nYou're current balance is: $" + balance);
//            } else {
//                System.out.println("\nInsufficient Funds.");
//            }
//
//            if (balance == 0) {
//                break;
//            }
//        }

//            // Longest word in a sentence
//        int index = 0;
//        System.out.print("Please enter a sentence: ");
//        String sentence = io.nextLine();
//
//        String[] words = sentence.split(" ");
//
//        for (int i = 0; i < words.length; i++) {
//            if (words[i].length() > words[index].length()) {
//                index = i;
//            }
//        }
//
//        System.out.println("The longest word in the sentence is: " + words[index] + ".");


//        // Number Reversal
//        System.out.print("Enter a number: ");
//        String number = io.nextLine();
//        String rebmun = "";
//
//        for (int i = number.length()-1; i >=0; i--) {
//            rebmun += number.charAt(i);
//        }
//
//        System.out.println("\n\nThe new number is: " + rebmun);


        // Guess the word game
        String[] words = {"apple", "banana", "cherry"};

        int randIndex = random.nextInt(words.length);

        String randomWord = words[randIndex];
        String userGuess;
        int guess = 0;



        do {
            if (guess >= 2) {
                System.out.println("\nShh... here is a hint... it starts with a: " + randomWord.charAt(0));
            }

            System.out.print("\nEnter your guess:  ");
            userGuess = io.nextLine();
            guess += 1;

        } while (!userGuess.equals(randomWord));

        System.out.println("Yes! The answer was: " + randomWord + "!");        do {
            if (guess >= 2) {
                System.out.println("\nShh... here is a hint... it starts with a: " + randomWord.charAt(0));
            }

            System.out.print("\nEnter your guess:  ");
            userGuess = io.nextLine();
            guess += 1;
            

        } while (!userGuess.equals(randomWord));

        System.out.println("Yes! The answer was: " + randomWord + "!");


    }



    public static int isPrime(int num) {
        boolean isPrime = true;

        if (num == 1 || num == 2) {
            isPrime = true;
        } else {
            while (true) {
                for (int i = num - 1; i > 1; i--) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                break;
            }
        }


        if (isPrime) {
            return num;
        } else {
            return 0;
        }
    }
}