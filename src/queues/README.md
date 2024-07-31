# Queues in Java - Data Structures and Algorithms

This directory contains Java implementations of various queue-related data structures and algorithms. Each file demonstrates a specific concept, operation, or problem-solving technique using queues in Java.

## Table of Contents

1. [Basic Queue Operations](#basic-queue-operations)
2. [Circular Queue](#circular-queue)
3. [Priority Queue](#priority-queue)
4. [Deque (Double-Ended Queue)](#deque-double-ended-queue)
5. [Implement Queue Using Stacks](#implement-queue-using-stacks)
6. [Queue Reversal](#queue-reversal)
7. [Generate Binary Numbers](#generate-binary-numbers)
8. [First Non-Repeating Character in a Stream](#first-non-repeating-character-in-a-stream)

## Basic Queue Operations

Basic operations on queues such as enqueue, dequeue, front, and isEmpty.

- [BasicQueueOperations.java](BasicQueueOperations.java)

## Circular Queue

Implementation of a circular queue which uses a fixed-size buffer in a circular fashion.

- [CircularQueue.java](CircularQueue.java)

## Priority Queue

Implementation of a priority queue where each element is assigned a priority and elements are served based on their priority.

- [PriorityQueue.java](PriorityQueue.java)

## Deque (Double-Ended Queue)

Implementation of a deque which allows insertion and deletion of elements from both ends.

- [Deque.java](Deque.java)

## Implement Queue Using Stacks

Implementation of a queue using two stacks.

- [QueueUsingStacks.java](QueueUsingStacks.java)

## Queue Reversal

Algorithm to reverse the elements of a queue.

- [QueueReversal.java](QueueReversal.java)

## Generate Binary Numbers

Algorithm to generate binary numbers from 1 to N using a queue.

- [GenerateBinaryNumbers.java](GenerateBinaryNumbers.java)

## First Non-Repeating Character in a Stream

Algorithm to find the first non-repeating character in a stream of characters.

- [FirstNonRepeatingCharacter.java](FirstNonRepeatingCharacter.java)

## How to Use

Each queue implementation can be run individually. Ensure you have the Java Development Kit (JDK) installed on your system. You can compile and run each program using the following commands:

\```bash
# Navigate to the directory containing the Java files
cd src/queues

# Compile the Java file (replace BasicQueueOperations.java with the desired file)
javac BasicQueueOperations.java

# Run the compiled Java program
java BasicQueueOperations
\```

## Example Usage

Here is a brief example of how to run the Basic Queue Operations program:

\```bash
javac BasicQueueOperations.java
java BasicQueueOperations
\```

You will be prompted to enter queue operations such as enqueue, dequeue, and front. The queue will then perform the requested operations and display the results.

## Contributing

Feel free to fork this repository, make changes, and submit pull requests. If you find any issues or have suggestions for improvements, please open an issue.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
