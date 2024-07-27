# Stacks in Java - Data Structures and Algorithms

This directory contains Java implementations of various stack-related data structures and algorithms. Each file demonstrates a specific concept, operation, or problem-solving technique using stacks in Java.

## Table of Contents

1. [Basic Stack Operations](#basic-stack-operations)
2. [Infix to Postfix Conversion](#infix-to-postfix-conversion)
3. [Postfix Evaluation](#postfix-evaluation)
4. [Balanced Parentheses](#balanced-parentheses)
5. [Implement Stack Using Queues](#implement-stack-using-queues)
6. [Min Stack](#min-stack)
7. [Next Greater Element](#next-greater-element)
8. [Sort Stack](#sort-stack)

## Basic Stack Operations

Basic operations on stacks such as push, pop, peek, and isEmpty.

- [BasicStackOperations.java](BasicStackOperations.java)

## Infix to Postfix Conversion

Algorithm to convert an infix expression (e.g., `A + B * C`) to a postfix expression (e.g., `A B C * +`).

- [InfixToPostfix.java](InfixToPostfix.java)

## Postfix Evaluation

Algorithm to evaluate a postfix expression (e.g., `A B C * +`).

- [PostfixEvaluation.java](PostfixEvaluation.java)

## Balanced Parentheses

Algorithm to check if the parentheses in an expression are balanced.

- [BalancedParentheses.java](BalancedParentheses.java)

## Implement Stack Using Queues

Implementation of a stack using two queues.

- [StackUsingQueues.java](StackUsingQueues.java)

## Min Stack

Stack that supports push, pop, top, and retrieving the minimum element in constant time.

- [MinStack.java](MinStack.java)

## Next Greater Element

Algorithm to find the next greater element for each element of the array.

- [NextGreaterElement.java](NextGreaterElement.java)

## Sort Stack

Algorithm to sort a stack using recursion.

- [SortStack.java](SortStack.java)

## How to Use

Each stack implementation can be run individually. Ensure you have the Java Development Kit (JDK) installed on your system. You can compile and run each program using the following commands:

\```bash
# Navigate to the directory containing the Java files
cd src/stacks

# Compile the Java file (replace BasicStackOperations.java with the desired file)
javac BasicStackOperations.java

# Run the compiled Java program
java BasicStackOperations
\```

## Example Usage

Here is a brief example of how to run the Basic Stack Operations program:

\```bash
javac BasicStackOperations.java
java BasicStackOperations
\```

You will be prompted to enter stack operations such as push, pop, and peek. The stack will then perform the requested operations and display the results.

## Contributing

Feel free to fork this repository, make changes, and submit pull requests. If you find any issues or have suggestions for improvements, please open an issue.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
