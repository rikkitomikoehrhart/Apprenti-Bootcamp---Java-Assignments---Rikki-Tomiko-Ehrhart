import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);

        // arrays []
        int[] nums = new int[3];

        nums[0] = 42;
        nums[1] = 13;
        nums[2] = 7;

        // An array is fixed, there is no append or add function


        int[] nums2 = {1, 2, 3, 4, 5};
        for (int i = 0; i < nums2.length; i++) {
            System.out.println(nums2[i]);
        }

        String[] colors = new String[2];
        int totalColors = 0;

        while (true) {
            System.out.print("Enter a color (Q to quit): ");
            String color = io.nextLine();

            if (color.equals("Q")){
                break;
            } else {
                totalColors++;
            }

            if (totalColors > colors.length) {
                String[] temp = new String[colors.length * 2];

                for (int i = 0; i < colors.length; i++) {
                    temp[i] = colors[i];
                }

                colors = temp;
                colors[totalColors - 1] = color;
            } else {
                colors[totalColors - 1] = color;
            }
        }

        for (int i = 0; i < colors.length; i++){
            if (colors[i] != null) {
                System.out.println(colors[i]);
            }
        }
    }
}
