package stacks;

import java.util.Stack;
import java.util.Scanner;

public class PostfixEvaluation {

    // Method to evaluate a postfix expression
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            // If the character is an operand, push it to the stack
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } 
            // If the character is an operator, pop two elements from stack and apply the operator
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                }
            }
        }
        // The result will be the last element in the stack
        return stack.pop();
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter a postfix expression: ");
            String expression = input.nextLine();

            int result = evaluatePostfix(expression);
            System.out.println("Result of postfix evaluation: " + result);
        }
    }
}
