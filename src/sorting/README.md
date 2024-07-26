# Sorting in Java - Data Structures and Algorithms

This directory contains Java implementations of various sorting algorithms. Each file demonstrates a specific sorting algorithm, providing a clear example of its use and functionality.

## Table of Contents

1. [Bubble Sort](#bubble-sort)
2. [Selection Sort](#selection-sort)
3. [Insertion Sort](#insertion-sort)
4. [Merge Sort](#merge-sort)
5. [Quick Sort](#quick-sort)
6. [Heap Sort](#heap-sort)
7. [Counting Sort](#counting-sort)
8. [Radix Sort](#radix-sort)
9. [Bucket Sort](#bucket-sort)

## Bubble Sort

Bubble Sort is a simple sorting algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. The pass through the list is repeated until the list is sorted.

- [BubbleSort.java](BubbleSort.java)

## Selection Sort

Selection Sort is an in-place comparison sorting algorithm. It has an O(n^2) time complexity, making it inefficient on large lists, and generally performs worse than the similar insertion sort.

- [SelectionSort.java](SelectionSort.java)

## Insertion Sort

Insertion Sort is a simple sorting algorithm that builds the final sorted array one item at a time. It is much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort.

- [InsertionSort.java](InsertionSort.java)

## Merge Sort

Merge Sort is an efficient, stable, comparison-based, divide and conquer sorting algorithm. Most implementations produce a stable sort, meaning that the implementation preserves the input order of equal elements in the sorted output.

- [MergeSort.java](MergeSort.java)

## Quick Sort

Quick Sort is an efficient, comparison-based, divide and conquer sorting algorithm. It works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays, according to whether they are less than or greater than the pivot.

- [QuickSort.java](QuickSort.java)

## Heap Sort

Heap Sort is a comparison-based sorting algorithm. Heapsort can be thought of as an improved selection sort: like selection sort, heapsort divides its input into a sorted and an unsorted region, and it iteratively shrinks the unsorted region by extracting the largest element and moving that to the sorted region.

- [HeapSort.java](HeapSort.java)

## Counting Sort

Counting Sort is an integer sorting algorithm that operates by counting the number of objects that have each distinct key value, and using arithmetic to determine the positions of each key in the output sequence.

- [CountingSort.java](CountingSort.java)

## Radix Sort

Radix Sort is a non-comparative integer sorting algorithm. It sorts by grouping keys by the individual digits which share the same significant position and value.

- [RadixSort.java](RadixSort.java)

## Bucket Sort

Bucket Sort is a distribution sort, and is a generalization of pigeonhole sort. It works by distributing the elements into a number of buckets. Each bucket is then sorted individually, either using a different sorting algorithm, or by recursively applying the bucket sorting algorithm.

- [BucketSort.java](BucketSort.java)

## How to Use

Each sorting algorithm can be run individually. Ensure you have the Java Development Kit (JDK) installed on your system. You can compile and run each program using the following commands:

\```bash
# Navigate to the directory containing the Java files
cd src/sorting

# Compile the Java file (replace BubbleSort.java with the desired file)
javac BubbleSort.java

# Run the compiled Java program
java BubbleSort
\```

## Example Usage

Here is a brief example of how to run the Bubble Sort program:

\```bash
javac BubbleSort.java
java BubbleSort
\```

You will be prompted to enter the number of elements and the elements themselves. The sorted array will then be displayed.

## Contributing

Feel free to fork this repository, make changes, and submit pull requests. If you find any issues or have suggestions for improvements, please open an issue.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
