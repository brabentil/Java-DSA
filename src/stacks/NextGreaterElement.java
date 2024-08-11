package stacks;

import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {

    // Method to find the next greater element for each element in the array
    public static void findNextGreaterElements(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int[] nextGreater = new int[array.length];

        // Initialize all elements in nextGreater to -1
        for (int i = 0; i < array.length; i++) {
            nextGreater[i] = -1;
        }

        // Traverse the array from left to right
        for (int i = 0; i < array.length; i++) {
            // While stack is not empty and the current element is greater than the element indexed by the top of the stack
            while (!stack.isEmpty() && array[stack.peek()] < array[i]) {
                nextGreater[stack.pop()] = array[i];
            }
            // Push the current index onto the stack
            stack.push(i);
        }

        // Print the result
        System.out.println("Next Greater Elements:");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " -> " + nextGreater[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        findNextGreaterElements(array);
        scanner.close();
    }
}
