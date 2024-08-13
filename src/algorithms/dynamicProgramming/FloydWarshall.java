import java.util.Scanner;
import java.util.InputMismatchException;

public class FloydWarshall {
    public static int INF = 99999;

    /**
     * Computes the shortest distances between all pairs of vertices in a weighted graph using the Floyd-Warshall algorithm.
     * 
     * @param matrix The weighted adjacency matrix representing the graph.
     * @return A 2D array containing the shortest distances between all pairs of vertices.
     */
    public static int[][] shortestDist(int[][] matrix) {
        final int SIZE = matrix.length;
        int[][] solution = new int[SIZE][SIZE];

        // Initialize the solution matrix with the initial weights or distances
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                // If it's the same vertex, the distance is 0
                if (i == j) {
                    solution[i][j] = 0;
                } else if (matrix[i][j] == -1) {
                    // If there is no edge, set the distance to INF
                    solution[i][j] = INF;
                } else {
                    // Otherwise, set the distance to the weight of the edge
                    solution[i][j] = matrix[i][j];
                }
            }
        }

        // Floyd-Warshall algorithm for finding shortest paths
        for (int k = 0; k < SIZE; k++) {
            // Iterate over all vertices as intermediate nodes
            for (int i = 0; i < SIZE; i++) {
                // Iterate over all vertices as source nodes
                for (int j = 0; j < SIZE; j++) {
                    // Update the shortest distance if there's a shorter path through vertex k
                    if (solution[i][k] != INF && solution[k][j] != INF && solution[i][k] + solution[k][j] < solution[i][j]) {
                        solution[i][j] = solution[i][k] + solution[k][j];
                    }
                }
            }
        }

        return solution;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num;

        System.out.println("Enter the number of vertices of the graph:");
        while (true) {
            try {
                num = input.nextInt();
                if (num <= 0) {
                    throw new InputMismatchException("Number of vertices must be positive.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a positive integer for the number of vertices:");
                input.nextLine(); // Consume the invalid input
            }
        }

        int[][] matrix = new int[num][num];

        System.out.println("Enter the cost matrix. Use -1 to indicate no direct edge between two vertices.");
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (i != j) {
                    while (true) {
                        try {
                            System.out.printf("Enter the cost of [%d,%d]: ", i + 1, j + 1);
                            matrix[i][j] = input.nextInt();
                            if (matrix[i][j] < -1) {
                                throw new InputMismatchException("Cost must be -1 or a non-negative integer.");
                            }
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter -1 or a non-negative integer for the cost:");
                            input.nextLine(); // Consume the invalid input
                        }
                    }
                } else {
                    matrix[i][j] = 0;
                }
            }
        }

        System.out.println("Initial weighted matrix:");
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(matrix[i][j] + "\t ");
            }
            System.out.println("");
        }

        System.out.println("Enter any key to proceed:");
        input.nextLine(); // Consume the newline character
        input.nextLine();

        matrix = shortestDist(matrix);

        System.out.println("Final weighted matrix:");
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (matrix[i][j] == INF) {
                    System.out.print("INF\t ");
                } else {
                    System.out.print(matrix[i][j] + "\t ");
                }
            }
            System.out.println("");
        }

        input.close();
    }
}
