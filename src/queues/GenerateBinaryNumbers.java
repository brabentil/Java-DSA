package queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GenerateBinaryNumbers {

    // Method to generate binary numbers from 1 to n
    public static void generateBinaryNumbers(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        System.out.println("Binary numbers from 1 to " + n + ":");
        for (int i = 1; i <= n; i++) {
            String binary = queue.remove();
            System.out.println(binary);
            queue.add(binary + "0");
            queue.add(binary + "1");
        }
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter the number of binary numbers to generate: ");
            int n = input.nextInt();

            generateBinaryNumbers(n);
        }
    }
}
