public class DebuggingExercise {

    public static void main(String[] args) {
        System.out.println("Starting Debugging Exercise...");

        int[] numbers = {5, 10, 15, 20, 25};

        System.out.println("Calculating Sum...");
        int total = calculateSum(numbers);
        System.out.println("Sum: " + total);

        System.out.println("Calculating Factorial...");
        int factorialResult = factorial(5);
        System.out.println("Factoiral of 5: " + factorialResult);

        System.out.println("Debugging Exercise Complete!");
    }

    // Method to calculate sum of an array (contains a bug)
    public static int calculateSum(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return sum;
    }


    // Recursive Method to Calculate Factorial
    public static int factorial(int num) {
        if (num == 0) return 1;
        else return num * (factorial(num - 1));
    }




}
