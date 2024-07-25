import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TripletWithGivenSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = createArray(scanner);
        if (array != null) {
            System.out.print("Enter the target sum: ");
            int targetSum = scanner.nextInt();
            findTripletsWithSum(array, targetSum);
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

    // Method to find triplets with a given sum
    public static void findTripletsWithSum(int[] array, int targetSum) {
        Arrays.sort(array); // Sort the array to use two-pointer technique

        boolean found = false;

        for (int i = 0; i < array.length - 2; i++) {
            int left = i + 1;
            int right = array.length - 1;

            while (left < right) {
                int currentSum = array[i] + array[left] + array[right];
                if (currentSum == targetSum) {
                    System.out.println("Triplet found: (" + array[i] + ", " + array[left] + ", " + array[right] + ")");
                    found = true;
                    left++;
                    right--;
                } else if (currentSum < targetSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        if (!found) {
            System.out.println("No triplet found with the given sum.");
        }
    }
}
