package arrays;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BasicOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = null;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create Array");
            System.out.println("2. Insert Element");
            System.out.println("3. Delete Element");
            System.out.println("4. Display Array");
            System.out.println("5. Quit");

            System.out.print("Enter your choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 5.");
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
                        array = insertElement(scanner, array);
                    }
                    break;
                case 3:
                    if (array == null) {
                        System.out.println("Create the array first!");
                    } else {
                        array = deleteElement(scanner, array);
                    }
                    break;
                case 4:
                    if (array == null) {
                        System.out.println("Create the array first!");
                    } else {
                        printArray(array);
                    }
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 5.");
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

    // Method to insert an element at a specific position
    public static int[] insertElement(Scanner scanner, int[] array) {
        int element, position;
        while (true) {
            try {
                System.out.print("Enter the element to insert: ");
                element = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scanner.next(); // Clear invalid input
            }
        }

        while (true) {
            try {
                System.out.print("Enter the position to insert the element (0 to " + array.length + "): ");
                position = scanner.nextInt();
                if (position < 0 || position > array.length) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid position.");
                scanner.next(); // Clear invalid input
            }
        }

        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < newArray.length; i++) {
            if (i < position) {
                newArray[i] = array[i];
            } else if (i == position) {
                newArray[i] = element;
            } else {
                newArray[i] = array[i - 1];
            }
        }
        return newArray;
    }

    // Method to delete an element from a specific position
    public static int[] deleteElement(Scanner scanner, int[] array) {
        int position;
        while (true) {
            try {
                System.out.print("Enter the position to delete the element (0 to " + (array.length - 1) + "): ");
                position = scanner.nextInt();
                if (position < 0 || position >= array.length) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid position.");
                scanner.next(); // Clear invalid input
            }
        }

        int[] newArray = new int[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != position) {
                newArray[j++] = array[i];
            }
        }
        return newArray;
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
