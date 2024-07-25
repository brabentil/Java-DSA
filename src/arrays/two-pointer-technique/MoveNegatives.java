import java.util.InputMismatchException;
import java.util.Scanner;

public class MoveNegatives {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = createArray(scanner);
        if (array != null) {
            moveNegativesToFront(array);
            printArray(array);
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

    // Method to move all negative numbers to the beginning of the array
    public static void moveNegativesToFront(int[] array) {
        int j = 0; // Pointer for the position of the next negative number

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                // Swap negative number to the front
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                j++;
            }
        }
    }

    // Method to print the array
    public static void printArray(int[] array) {
        System.out.println("Array after moving negatives to the front:");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
