package stacks;

import java.util.Scanner;
import java.util.Stack;

public class SortStack {
    
    // Method to sort a stack
    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        
        while (!stack.isEmpty()) {
            int current = stack.pop();
            
            // Move elements from tempStack back to stack until the right spot for current is found
            while (!tempStack.isEmpty() && tempStack.peek() > current) {
                stack.push(tempStack.pop());
            }
            
            tempStack.push(current);
        }
        
        // Move sorted elements back to original stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
    
    // Method to display stack elements
    public static void displayStack(Stack<Integer> stack) {
        // Since iterating over a stack doesn't show elements in LIFO order, we'll use a temporary stack
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            int elem = stack.pop();
            System.out.print(elem + " ");
            tempStack.push(elem);
        }
        System.out.println();
        
        // Restore the original stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements to push onto the stack: ");
        int n = scanner.nextInt();
        
        System.out.println("Enter the elements:");
        for(int i = 0; i < n; i++) {
            System.out.print("Element " + (i+1) + ": ");
            int element = scanner.nextInt();
            stack.push(element);
        }
        
        System.out.println("\nOriginal Stack (top to bottom):");
        displayStack(stack);
        
        sortStack(stack);
        
        System.out.println("\nSorted Stack (top to bottom):");
        displayStack(stack);
        
        scanner.close();
    }
}
