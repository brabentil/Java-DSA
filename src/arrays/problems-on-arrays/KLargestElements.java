
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class KLargestElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = createArray(scanner);

        int k = 0;
        while (true) {
            try {
                System.out.print("Enter the value of k: ");
                k = scanner.nextInt();
                if (k <= 0 || k > array.length) {
                    System.out.println("Invalid input. Please enter a value between 1 and " + array.length + ".");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear the invalid input
            }
        }

        findKLargestElements(array, k);
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

    // Method to find the k largest elements in an array
    public static void findKLargestElements(int[] array, int k) {
        Arrays.sort(array);
        System.out.println("The " + k + " largest elements are:");
        for (int i = array.length - k; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
