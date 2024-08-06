package queues;

import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueOperations {
    private PriorityQueue<Integer> priorityQueue;

    // Constructor to initialize the priority queue
    public PriorityQueueOperations() {
        priorityQueue = new PriorityQueue<>();
    }

    // Method to add an element to the priority queue
    public void add(int value) {
        priorityQueue.add(value);
        System.out.println("Added " + value + " to the priority queue.");
    }

    // Method to remove the highest priority element from the priority queue
    public int poll() {
        if (priorityQueue.isEmpty()) {
            System.out.println("Priority queue is empty. Cannot poll an element.");
            return -1;
        } else {
            return priorityQueue.poll();
        }
    }

    // Method to peek the highest priority element of the priority queue
    public int peek() {
        if (priorityQueue.isEmpty()) {
            System.out.println("Priority queue is empty. Cannot peek.");
            return -1;
        } else {
            return priorityQueue.peek();
        }
    }

    // Method to check if the priority queue is empty
    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    // Method to display the priority queue elements
    public void display() {
        if (priorityQueue.isEmpty()) {
            System.out.println("Priority queue is empty.");
        } else {
            System.out.println("Priority queue elements: " + priorityQueue);
        }
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            PriorityQueueOperations priorityQueue = new PriorityQueueOperations();

            // Menu for priority queue operations
            while (true) {
                System.out.println("\nPriority Queue Operations Menu:");
                System.out.println("1. Add");
                System.out.println("2. Poll");
                System.out.println("3. Peek");
                System.out.println("4. Display");
                System.out.println("5. Exit");
                System.out.print("Choose an operation: ");

                int choice = -1;
                try {
                    choice = input.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 5.");
                    input.next(); // Clear the invalid input
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.print("Enter value to add: ");
                        try {
                            int value = input.nextInt();
                            priorityQueue.add(value);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter an integer.");
                            input.next(); // Clear the invalid input
                        }
                        break;
                    case 2:
                        int polledValue = priorityQueue.poll();
                        if (polledValue != -1) {
                            System.out.println("Polled value: " + polledValue);
                        }
                        break;
                    case 3:
                        int peekedValue = priorityQueue.peek();
                        if (peekedValue != -1) {
                            System.out.println("Highest priority value: " + peekedValue);
                        }
                        break;
                    case 4:
                        priorityQueue.display();
                        break;
                    case 5:
                        System.out.println("Exiting.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please choose a number between 1 and 5.");
                }
            }
        }
    }
}
