package stacks;

import java.util.Scanner;
import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    // Constructor to initialize the stacks
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Method to push an element onto the stack
    public void push(int value) {
        stack.push(value);
        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
        System.out.println("Pushed " + value + " onto the stack.");
    }

    // Method to pop an element from the stack
    public int pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty. Cannot pop an element.");
            return -1;
        }
        int poppedValue = stack.pop();
        if (poppedValue == minStack.peek()) {
            minStack.pop();
        }
        return poppedValue;
    }

    // Method to get the top element of the stack
    public int top() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1;
        }
        return stack.peek();
    }

    // Method to get the minimum element in the stack
    public int getMin() {
        if (minStack.isEmpty()) {
            System.out.println("Stack is empty. No minimum element.");
            return -1;
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMinStack Operations Menu:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Top");
            System.out.println("4. Get Minimum");
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
                    int minValue = stack.getMin();
                    if (minValue != -1) {
                        System.out.println("Minimum value: " + minValue);
                    }
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
