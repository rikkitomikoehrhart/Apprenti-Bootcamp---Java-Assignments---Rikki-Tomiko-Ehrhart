


public class Main {
    public static void main(String[] args) {


        // Task 1
        printWelcomeMessage();


        // Task 2
        System.out.println(sum(1,2));
        System.out.println(sum(3, 4));
        System.out.println(sum(5, 6));


        // Task 3
        System.out.println(convertToFahrenheit(40));
        System.out.println(convertToFahrenheit(30));
        System.out.println(convertToFahrenheit(20));


        // Task 4
        System.out.println(isEven(7));
        System.out.println(isEven(13));
        System.out.println(isEven(38));


        // Task 5
        printMultipleTimes("Rikki Tomiko Ehrhart", 13);
        printMultipleTimes("Hello, World", 7);


        // Task 6
        System.out.println(findMax(1, 2, 3));
        System.out.println(findMax(6, 5, 4));
        System.out.println(findMax(8, 9, 7));


        // Task 7
        System.out.println(factorial(5));
        System.out.println(factorial(7));
        System.out.println(factorial(10));


        // Task 8
        greet("Rikki");
        greet("Rikki", 38);


        // Task 9
        System.out.println(countVowels("hello world"));
        System.out.println(countVowels("java programming"));


        // Task 10
        System.out.println(calculator(1, 2, '+'));
        System.out.println(calculator(3, 4, '-'));
        System.out.println(calculator(5, 6, '*'));
        System.out.println(calculator(7, 8, '/'));


        // Bonus Challenge
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("hello"));


        // Extra Practice
        System.out.println(numberReversal(123456789));
        System.out.println(isPrime(25));
        System.out.println(findMin(1, 2, 3));
    }

    private static void printWelcomeMessage() {
        System.out.println("Welcome to the Java Method Exercise!");
    }

    private static int sum(int a, int b) {
        return a + b;
    }

    private static double convertToFahrenheit(double celsius) {
        return (celsius * (9/5) + 32);
    }

    private static boolean isEven(int number) {
        return (number % 2 == 0);
    }

    private static void printMultipleTimes(String text, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(text);
        }
    }

    private static int findMax(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        } else if (b > a && b > c) {
            return b;
        } else {
            return c;
        }
    }

    private static int factorial(int n) {
        if (n == 0) return 1;
        else return n * factorial(n-1);
    }

    private static void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }
    private static void greet(String name, int age) {
        System.out.println("Hello, " + name + "! You are " + age + " years old.");
    }

    private static int countVowels(String text) {
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'A' || text.charAt(i) == 'a' || text.charAt(i) == 'E' || text.charAt(i) == 'e' || text.charAt(i) == 'I' || text.charAt(i) == 'i' || text.charAt(i) == 'O' || text.charAt(i) == 'o' || text.charAt(i) == 'U' || text.charAt(i) == 'u') {
                count++;
            }
        }

        return count;
    }

    private static int calculator(int a, int b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    return 0;
                } else {
                    return a / b;
                }
        }
        return 0;
    }

    private static boolean isPalindrome(String text) {
        String backwards = "";

        for (int i = text.length()-1; i >= 0; i--) {
            backwards += text.charAt(i);
        }

        return backwards.equals(text);
    }

    private static int numberReversal(int number) {
        String numString = Integer.toString(number);
        String backwards = "";

        for (int i = numString.length()-1; i >= 0; i--) {
            backwards += numString.charAt(i);
        }

        return Integer.parseInt(backwards);
    }

    private static boolean isPrime(int number) {
        boolean prime = true;

        if (number == 1 || number == 2) {
            prime = true;
        } else {
            while (true) {
                for (int i = number - 1; i > 1; i--) {
                    if (number % i == 0) {
                        prime = false;
                        break;
                    }
                }
                break;
            }
        }

        return prime;
    }

    private static int findMin(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }



}