package stacks;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParentheses {

    // Method to check if parentheses are balanced
    public static boolean areParenthesesBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            // If the character is an opening bracket, push it to the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // If the character is a closing bracket, check for a matching opening bracket
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char last = stack.pop();
                if (!isMatchingPair(last, ch)) {
                    return false;
                }
            }
        }

        // If the stack is empty, all opening brackets have been matched
        return stack.isEmpty();
    }

    // Helper method to check if two characters are matching pairs
    public static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter an expression with parentheses: ");
            String expression = input.nextLine();

            if (areParenthesesBalanced(expression)) {
                System.out.println("The parentheses are balanced.");
            } else {
                System.out.println("The parentheses are not balanced.");
            }
        }
    }
}
