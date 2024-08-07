package queues;

import java.util.Stack;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QueueUsingStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    // Constructor to initialize the stacks
    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Method to enqueue an element to the queue
    public void enqueue(int value) {
        stack1.push(value);
        System.out.println("Enqueued " + value + " to the queue.");
    }

    // Method to dequeue an element from the queue
    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue an element.");
            return -1;
        } else {
            return stack2.pop();
        }
    }

    // Method to peek the front element of the queue
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1;
        } else {
            return stack2.peek();
        }
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Method to display the queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue elements: ");
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            for (int element : stack2) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            QueueUsingStacks queue = new QueueUsingStacks();

            // Menu for queue operations
            while (true) {
                System.out.println("\nQueue Operations Menu:");
                System.out.println("1. Enqueue");
                System.out.println("2. Dequeue");
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
                        System.out.print("Enter value to enqueue: ");
                        try {
                            int value = input.nextInt();
                            queue.enqueue(value);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter an integer.");
                            input.next(); // Clear the invalid input
                        }
                        break;
                    case 2:
                        int dequeuedValue = queue.dequeue();
                        if (dequeuedValue != -1) {
                            System.out.println("Dequeued value: " + dequeuedValue);
                        }
                        break;
                    case 3:
                        int peekedValue = queue.peek();
                        if (peekedValue != -1) {
                            System.out.println("Front element: " + peekedValue);
                        }
                        break;
                    case 4:
                        queue.display();
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
