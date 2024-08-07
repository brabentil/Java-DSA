package queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    // Method to find the first non-repeating character in a stream
    public static void findFirstNonRepeatingCharacter(String stream) {
        Map<Character, Integer> charCount = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();

        for (char ch : stream.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
            queue.add(ch);

            while (!queue.isEmpty() && charCount.get(queue.peek()) > 1) {
                queue.remove();
            }

            if (!queue.isEmpty()) {
                System.out.println("First non-repeating character: " + queue.peek());
            } else {
                System.out.println("No non-repeating character found.");
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter a stream of characters: ");
            String stream = input.nextLine();

            findFirstNonRepeatingCharacter(stream);
        }
    }
}
