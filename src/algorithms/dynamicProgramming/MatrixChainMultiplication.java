import java.util.Scanner;

public class MatrixChainMultiplication {

    // Method to compute the minimum cost of matrix chain multiplication
    public static int matrixChainOrder(int[] dimensions) {
        int n = dimensions.length;
        int[][] dp = new int[n][n];

        // dp[i][j] will hold the minimum number of multiplications needed to compute the matrix A[i]A[i+1]...A[j]
        // The cost is zero when multiplying one matrix.
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // l is the chain length.
        for (int l = 2; l < n; l++) {
            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    // q = cost/scalar multiplications
                    int q = dp[i][k] + dp[k + 1][j] + dimensions[i - 1] * dimensions[k] * dimensions[j];
                    if (q < dp[i][j]) {
                        dp[i][j] = q;
                    }
                }
            }
        }

        // dp[1][n-1] has the result
        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of matrices: ");
            int n = scanner.nextInt();

            int[] dimensions = new int[n + 1];
            System.out.println("Enter the dimensions of the matrices: ");
            for (int i = 0; i <= n; i++) {
                System.out.print("Dimension " + (i + 1) + ": ");
                dimensions[i] = scanner.nextInt();
            }

            int minCost = matrixChainOrder(dimensions);
            System.out.println("Minimum number of multiplications is: " + minCost);
        }
    }
}
