package algorithms.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {
    
    // Item class to store weight and value of each item
    static class Item {
        int weight;
        int value;

        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    // Method to calculate the maximum value we can achieve with the given capacity
    public static double getMaxValue(int capacity, Item[] items) {
        // Sort items by value-to-weight ratio in descending order
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                double r1 = (double) o1.value / o1.weight;
                double r2 = (double) o2.value / o2.weight;
                return Double.compare(r2, r1);
            }
        });

        double totalValue = 0;

        for (Item item : items) {
            if (capacity > 0 && item.weight <= capacity) {
                // If we can take the whole item
                capacity -= item.weight;
                totalValue += item.value;
            } else {
                // If we can only take part of the item
                totalValue += (double) item.value * ((double) capacity / item.weight);
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = input.nextInt();

        Item[] items = new Item[n];

        System.out.println("Enter the weights and values of the items:");
        for (int i = 0; i < n; i++) {
            System.out.print("Weight of item " + (i + 1) + ": ");
            int weight = input.nextInt();
            System.out.print("Value of item " + (i + 1) + ": ");
            int value = input.nextInt();
            items[i] = new Item(weight, value);
        }

        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = input.nextInt();

        double maxValue = getMaxValue(capacity, items);
        System.out.println("Maximum value achievable: " + maxValue);

        input.close();
    }
}
