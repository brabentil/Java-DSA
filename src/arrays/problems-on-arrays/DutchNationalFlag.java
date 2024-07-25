package arrays;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DutchNationalFlag {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = createArray(scanner);
        if (array != null) {
            dutchNationalFlagSort(array);
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
                    if (array[i] < 0 || array[i] > 2) {
                        System.out.println("Invalid input. Please enter 0, 1, or 2.");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next(); // Clear the invalid input
                }
            }
        }
        return array;
    }

    // Method to sort the array using the Dutch National Flag algorithm
    public static void dutchNationalFlagSort(int[] array) {
        int low = 0, mid = 0, high = array.length - 1;

        while (mid <= high) {
            switch (array[mid]) {
                case 0:
                    swap(array, low++, mid++);
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(array, mid, high--);
                    break;
            }
        }
    }

    // Method to swap two elements in an array
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Method to print the array
    public static void printArray(int[] array) {
        System.out.println("Array elements:");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
