package stacks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BasicStackOperations {
    private int[] stack;
    private int top;
    private int maxSize;

    // Constructor to initialize the stack
    public BasicStackOperations(int size) {
        maxSize = size;
        stack = new int[maxSize];
        top = -1;
    }

    // Method to push an element onto the stack
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + value);
        } else {
            stack[++top] = value;
            System.out.println("Pushed " + value + " onto the stack.");
        }
    }

    // Method to pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop an element.");
            return -1;
        } else {
            return stack[top--];
        }
    }

    // Method to peek the top element of the stack
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1;
        } else {
            return stack[top];
        }
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // Method to display the stack elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int size = 0;

            // Input the size of the stack
            while (true) {
                try {
                    System.out.print("Enter the size of the stack: ");
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

            BasicStackOperations stack = new BasicStackOperations(size);

            // Menu for stack operations
            while (true) {
                System.out.println("\nStack Operations Menu:");
                System.out.println("1. Push");
                System.out.println("2. Pop");
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
                        System.out.print("Enter value to push: ");
                        try {
                            int value = input.nextInt();
                            stack.push(value);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter an integer.");
                            input.next(); // Clear the invalid input
                        }
                        break;
                    case 2:
                        int poppedValue = stack.pop();
                        if (poppedValue != -1) {
                            System.out.println("Popped value: " + poppedValue);
                        }
                        break;
                    case 3:
                        int peekedValue = stack.peek();
                        if (peekedValue != -1) {
                            System.out.println("Top value: " + peekedValue);
                        }
                        break;
                    case 4:
                        stack.display();
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
