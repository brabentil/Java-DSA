package queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class QueueReversal {

    // Method to reverse the queue
    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        // Dequeue all elements from the queue and push them onto the stack
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        // Pop all elements from the stack and enqueue them back into the queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    // Method to display the queue elements
    public static void displayQueue(Queue<Integer> queue) {
        System.out.println("Queue elements: " + queue);
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            Queue<Integer> queue = new LinkedList<>();

            // Input the size of the queue
            System.out.print("Enter the number of elements in the queue: ");
            int size = input.nextInt();

            // Input the elements of the queue
            for (int i = 0; i < size; i++) {
                System.out.print("Enter element " + (i + 1) + ": ");
                queue.add(input.nextInt());
            }

            System.out.println("Original Queue:");
            displayQueue(queue);

            // Reverse the queue
            reverseQueue(queue);

            System.out.println("Reversed Queue:");
            displayQueue(queue);
        }
    }
}
