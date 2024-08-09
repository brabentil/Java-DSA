package stacks;

import java.util.Stack;
import java.util.Scanner;

public class InfixToPostfix {

    // Method to check if a character is an operator
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    // Method to define the precedence of operators
    private static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Method to convert infix expression to postfix expression
    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            // If the character is an operand, add it to the output
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } 
            // If the character is '(', push it to the stack
            else if (ch == '(') {
                stack.push(ch);
            } 
            // If the character is ')', pop and output from the stack until '(' is encountered
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid Expression"; // invalid expression
                } else {
                    stack.pop();
                }
            } 
            // If the character is an operator
            else if (isOperator(ch)) {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression"; // invalid expression
            }
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter an infix expression: ");
            String expression = input.nextLine();

            String postfix = infixToPostfix(expression);
            System.out.println("Postfix expression: " + postfix);
        }
    }
}
