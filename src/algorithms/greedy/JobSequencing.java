package algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class JobSequencing {
    
    // Job class to store job id, deadline, and profit
    static class Job {
        char id;
        int deadline;
        int profit;

        Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    // Method to perform job sequencing to maximize profit
    public static void jobSequencing(Job[] jobs, int n) {
        // Sort jobs by profit in descending order
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Array to keep track of free time slots
        boolean[] slots = new boolean[n];
        // Array to store the sequence of jobs
        char[] jobSequence = new char[n];

        // Iterate through all given jobs
        for (int i = 0; i < jobs.length; i++) {
            // Find a free slot for this job (starting from the last possible slot)
            for (int j = Math.min(n - 1, jobs[i].deadline - 1); j >= 0; j--) {
                // If a free slot is found, place the job in the slot
                if (!slots[j]) {
                    slots[j] = true;
                    jobSequence[j] = jobs[i].id;
                    break;
                }
            }
        }

        // Print the job sequence
        System.out.print("Job sequence to maximize profit: ");
        for (char job : jobSequence) {
            if (job != '\u0000') {
                System.out.print(job + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of jobs: ");
        int n = input.nextInt();

        Job[] jobs = new Job[n];

        System.out.println("Enter the job details (id, deadline, profit):");
        for (int i = 0; i < n; i++) {
            System.out.print("Job id: ");
            char id = input.next().charAt(0);
            System.out.print("Deadline of job " + id + ": ");
            int deadline = input.nextInt();
            System.out.print("Profit of job " + id + ": ");
            int profit = input.nextInt();
            jobs[i] = new Job(id, deadline, profit);
        }

        jobSequencing(jobs, n);

        input.close();
    }
}
