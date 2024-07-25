
package arrays;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SearchSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = null;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create Array");
            System.out.println("2. Linear Search");
            System.out.println("3. Binary Search (requires sorted array)");
            System.out.println("4. Bubble Sort");
            System.out.println("5. Quick Sort");
            System.out.println("6. Display Array");
            System.out.println("7. Quit");

            System.out.print("Enter your choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 7.");
                scanner.next(); // Clear invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    array = createArray(scanner);
                    break;
                case 2:
                    if (array == null) {
                        System.out.println("Create the array first!");
                    } else {
                        linearSearch(scanner, array);
                    }
                    break;
                case 3:
                    if (array == null) {
                        System.out.println("Create the array first!");
                    } else {
                        binarySearch(scanner, array);
                    }
                    break;
                case 4:
                    if (array == null) {
                        System.out.println("Create the array first!");
                    } else {
                        bubbleSort(array);
                        System.out.println("Array sorted using Bubble Sort.");
                    }
                    break;
                case 5:
                    if (array == null) {
                        System.out.println("Create the array first!");
                    } else {
                        quickSort(array, 0, array.length - 1);
                        System.out.println("Array sorted using Quick Sort.");
                    }
                    break;
                case 6:
                    if (array == null) {
                        System.out.println("Create the array first!");
                    } else {
                        printArray(array);
                    }
                    break;
                case 7:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 7.");
            }
        }
    }

    // Method to create an array with user input
    public static int[] createArray(Scanner scanner) {
        int size;
        while (true) {
            try {
                System.out.print("Enter the number of elements in the array: ");
                size = scanner.nextInt();
                if (size <= 0) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a positive integer.");
                scanner.next(); // Clear invalid input
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
                    System.out.println("Invalid input! Please enter an integer.");
                    scanner.next(); // Clear invalid input
                }
            }
        }

        return array;
    }

    // Method for linear search
    public static void linearSearch(Scanner scanner, int[] array) {
        int target;
        while (true) {
            try {
                System.out.print("Enter the element to search: ");
                target = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scanner.next(); // Clear invalid input
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                System.out.println("Element found at index " + i);
                return;
            }
        }
        System.out.println("Element not found.");
    }

    // Method for binary search
    public static void binarySearch(Scanner scanner, int[] array) {
        bubbleSort(array); // Ensuring array is sorted for binary search

        int target;
        while (true) {
            try {
                System.out.print("Enter the element to search: ");
                target = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scanner.next(); // Clear invalid input
            }
        }

        int result = binarySearch(array, target);
        if (result == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("Element found at index " + result);
        }
    }

    // Binary search algorithm
    public static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (array[mid] == target) {
                return mid;
            }

            // If target greater, ignore left half
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                // If target is smaller, ignore right half
                right = mid - 1;
            }
        }
        // Target not found
        return -1;
    }

    // Bubble sort algorithm
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Quick sort algorithm
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            // Recursively sort elements before partition and after partition
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1); // Index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (array[j] <= pivot) {
                i++;

                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap array[i + 1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
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
