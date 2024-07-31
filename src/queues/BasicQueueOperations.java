package queues;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BasicQueueOperations {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int maxSize;

    // Constructor to initialize the queue
    public BasicQueueOperations(int maxSize) {
        this.maxSize = maxSize;
        queue = new int[maxSize];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Method to add an element to the queue
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + value);
        } else {
            rear = (rear + 1) % maxSize;
            queue[rear] = value;
            size++;
            System.out.println("Enqueued " + value + " to the queue.");
        }
    }

    // Method to remove an element from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        } else {
            int value = queue[front];
            front = (front + 1) % maxSize;
            size--;
            return value;
        }
    }

    // Method to peek the front element of the queue
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1;
        } else {
            return queue[front];
        }
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return size == maxSize;
    }

    // Method to display the queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue elements: ");
            for (int i = 0; i < size; i++) {
                System.out.print(queue[(front + i) % maxSize] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int size = 0;

            // Input the size of the queue
            while (true) {
                try {
                    System.out.print("Enter the size of the queue: ");
                    size = input.nextInt();
                    if (size <= 0) {
                        System.out.println("Size must be positive. Please try again.");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                    input.next(); // Clear the invalid input
                }
            }

            BasicQueueOperations queue = new BasicQueueOperations(size);

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
                            System.out.println("Front value: " + peekedValue);
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
