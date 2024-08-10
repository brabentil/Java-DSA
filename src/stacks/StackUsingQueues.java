package stacks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackUsingQueues {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private int currentSize;

    // Constructor to initialize the stack
    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        currentSize = 0;
    }

    // Method to push an element onto the stack
    public void push(int value) {
        currentSize++;

        // Push element into queue2
        queue2.add(value);

        // Move all elements from queue1 to queue2
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }

        // Swap the names of queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        System.out.println("Pushed " + value + " onto the stack.");
    }

    // Method to pop an element from the stack
    public int pop() {
        if (queue1.isEmpty()) {
            System.out.println("Stack is empty. Cannot pop an element.");
            return -1;
        }

        currentSize--;
        return queue1.remove();
    }

    // Method to peek the top element of the stack
    public int top() {
        if (queue1.isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1;
        }

        return queue1.peek();
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return currentSize == 0;
    }

    // Method to get the size of the stack
    public int size() {
        return currentSize;
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStack Operations Menu:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Top");
            System.out.println("4. Size");
            System.out.println("5. Exit");
            System.out.print("Choose an operation: ");

            int choice = -1;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.next(); // Clear the invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    try {
                        int value = scanner.nextInt();
                        stack.push(value);
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter an integer.");
                        scanner.next(); // Clear the invalid input
                    }
                    break;
                case 2:
                    int poppedValue = stack.pop();
                    if (poppedValue != -1) {
                        System.out.println("Popped value: " + poppedValue);
                    }
                    break;
                case 3:
                    int topValue = stack.top();
                    if (topValue != -1) {
                        System.out.println("Top value: " + topValue);
                    }
                    break;
                case 4:
                    System.out.println("Stack size: " + stack.size());
                    break;
                case 5:
                    System.out.println("Exiting.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a number between 1 and 5.");
            }
        }
    }
}
