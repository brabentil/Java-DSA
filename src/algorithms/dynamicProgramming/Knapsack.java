import java.util.Scanner;

public class Knapsack {

   
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = input.nextInt();

        int[] weights = new int[n];
        System.out.println("Enter the weights of the items:");
        for (int i = 0; i < n; i++) {
            System.out.print("Weight of item " + (i + 1) + ": ");
            weights[i] = input.nextInt();
        }

        int[] values = new int[n];
        System.out.println("Enter the values of the items:");
        for (int i = 0; i < n; i++) {
            System.out.print("Value of item " + (i + 1) + ": ");
            values[i] = input.nextInt();
        }

        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = input.nextInt();

        int maxProfit = knapsack(weights, values, capacity);
        System.out.println("Maximum profit: " + maxProfit);

        input.close();
    }
}
