import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PairWithGivenSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = createArray(scanner);
        if (array != null) {
            System.out.print("Enter the target sum: ");
            int targetSum = scanner.nextInt();
            findPairWithSum(array, targetSum);
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

    // Method to find pairs with a given sum
    public static void findPairWithSum(int[] array, int targetSum) {
        Arrays.sort(array); // Sort the array to use two-pointer technique

        int left = 0, right = array.length - 1;
        boolean found = false;

        while (left < right) {
            int currentSum = array[left] + array[right];
            if (currentSum == targetSum) {
                System.out.println("Pair found: (" + array[left] + ", " + array[right] + ")");
                found = true;
                left++;
                right--;
            } else if (currentSum < targetSum) {
                left++;
            } else {
                right--;
            }
        }

        if (!found) {
            System.out.println("No pair found with the given sum.");
        }
    }
}
