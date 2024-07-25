
import java.util.InputMismatchException;
import java.util.Scanner;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = createArray(scanner);
        if (array != null) {
            int maxProduct = findMaxProductSubarray(array);
            System.out.println("Maximum product subarray: " + maxProduct);
        }
    }

    // Method to create an array with user input
    public static int[] createArray(Scanner scanner) {
        int size = 0;
        while (true) {
            try {
                System.out.print("Enter the number of elements in the array: ");
                size = scanner.nextInt();
                if (size <= 0) {
                    System.out.println("Array size must be positive. Please try again.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear the invalid input
            }
        }

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            while (true) {
                try {
                    System.out.print("Enter element " + (i + 1) + ": ");
                    array[i] = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next(); // Clear the invalid input
                }
            }
        }
        return array;
    }

    // Method to find the maximum product subarray
    public static int findMaxProductSubarray(int[] array) {
        if (array.length == 0) {
            System.out.println("Array is empty. No maximum product subarray.");
            return 0; // Or throw an exception if appropriate
        }

        int maxProduct = array[0];
        int minProduct = array[0];
        int result = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(array[i], maxProduct * array[i]);
            minProduct = Math.min(array[i], minProduct * array[i]);

            result = Math.max(result, maxProduct);
        }

        return result;
    }
}
