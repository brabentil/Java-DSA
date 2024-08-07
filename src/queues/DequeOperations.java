package queues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DequeOperations {
    private Deque<Integer> deque;

    // Constructor to initialize the deque
    public DequeOperations() {
        deque = new LinkedList<>();
    }

    // Method to add an element to the front of the deque
    public void addFirst(int value) {
        deque.addFirst(value);
        System.out.println("Added " + value + " to the front of the deque.");
    }

    // Method to add an element to the rear of the deque
    public void addLast(int value) {
        deque.addLast(value);
        System.out.println("Added " + value + " to the rear of the deque.");
    }

    // Method to remove an element from the front of the deque
    public int removeFirst() {
        if (deque.isEmpty()) {
            System.out.println("Deque is empty. Cannot remove an element from the front.");
            return -1;
        } else {
            return deque.removeFirst();
        }
    }

    // Method to remove an element from the rear of the deque
    public int removeLast() {
        if (deque.isEmpty()) {
            System.out.println("Deque is empty. Cannot remove an element from the rear.");
            return -1;
        } else {
            return deque.removeLast();
        }
    }

    // Method to peek the first element of the deque
    public int peekFirst() {
        if (deque.isEmpty()) {
            System.out.println("Deque is empty. Cannot peek the first element.");
            return -1;
        } else {
            return deque.peekFirst();
        }
    }

    // Method to peek the last element of the deque
    public int peekLast() {
        if (deque.isEmpty()) {
            System.out.println("Deque is empty. Cannot peek the last element.");
            return -1;
        } else {
            return deque.peekLast();
        }
    }

    // Method to check if the deque is empty
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    // Method to display the deque elements
    public void display() {
        if (deque.isEmpty()) {
            System.out.println("Deque is empty.");
        } else {
            System.out.println("Deque elements: " + deque);
        }
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            DequeOperations deque = new DequeOperations();

            // Menu for deque operations
            while (true) {
                System.out.println("\nDeque Operations Menu:");
                System.out.println("1. Add to front");
                System.out.println("2. Add to rear");
                System.out.println("3. Remove from front");
                System.out.println("4. Remove from rear");
                System.out.println("5. Peek front");
                System.out.println("6. Peek rear");
                System.out.println("7. Display");
                System.out.println("8. Exit");
                System.out.print("Choose an operation: ");

                int choice = -1;
                try {
                    choice = input.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 8.");
                    input.next(); // Clear the invalid input
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.print("Enter value to add to front: ");
                        try {
                            int value = input.nextInt();
                            deque.addFirst(value);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter an integer.");
                            input.next(); // Clear the invalid input
                        }
                        break;
                    case 2:
                        System.out.print("Enter value to add to rear: ");
                        try {
                            int value = input.nextInt();
                            deque.addLast(value);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter an integer.");
                            input.next(); // Clear the invalid input
                        }
                        break;
                    case 3:
                        int removedFirst = deque.removeFirst();
                        if (removedFirst != -1) {
                            System.out.println("Removed from front: " + removedFirst);
                        }
                        break;
                    case 4:
                        int removedLast = deque.removeLast();
                        if (removedLast != -1) {
                            System.out.println("Removed from rear: " + removedLast);
                        }
                        break;
                    case 5:
                        int peekedFirst = deque.peekFirst();
                        if (peekedFirst != -1) {
                            System.out.println("Front element: " + peekedFirst);
                        }
                        break;
                    case 6:
                        int peekedLast = deque.peekLast();
                        if (peekedLast != -1) {
                            System.out.println("Rear element: " + peekedLast);
                        }
                        break;
                    case 7:
                        deque.display();
                        break;
                    case 8:
                        System.out.println("Exiting.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please choose a number between 1 and 8.");
                }
            }
        }
    }
}
