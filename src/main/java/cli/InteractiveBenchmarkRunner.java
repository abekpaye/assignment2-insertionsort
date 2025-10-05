package cli;

import algorithms.InsertionSort;
import metrics.PerformanceTracker;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class InteractiveBenchmarkRunner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Insertion Sort CLI Tester ===");
        System.out.print("Enter array size (n): ");
        int n = sc.nextInt();

        System.out.print("Enter input type (random/sorted/reverse/nearlySorted): ");
        String type = sc.next();

        int[] arr = generateArray(type, n);
        PerformanceTracker tracker = new PerformanceTracker();

        long start = System.nanoTime();
        InsertionSort.sort(arr, tracker);
        long end = System.nanoTime();

        double timeMs = (end - start) / 1_000_000.0;

        System.out.println("\n--- Results ---");
        System.out.println("Input Type: " + type);
        System.out.println("Array Size: " + n);
        System.out.println("Comparisons: " + tracker.getComparisons());
        System.out.println("Swaps: " + tracker.getSwaps());
        System.out.println("Array Accesses: " + tracker.getArrayAccesses());
        System.out.printf("Execution Time: %.3f ms%n", timeMs);

        System.out.print("\nShow sorted array? (y/n): ");
        if (sc.next().equalsIgnoreCase("y")) {
            System.out.println(Arrays.toString(arr));
        }
    }

    private static int[] generateArray(String type, int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        switch (type) {
            case "random" -> {
                for (int i = 0; i < n; i++) arr[i] = rand.nextInt(10000);
            }
            case "sorted" -> {
                for (int i = 0; i < n; i++) arr[i] = i;
            }
            case "reverse" -> {
                for (int i = 0; i < n; i++) arr[i] = n - i;
            }
            case "nearlySorted" -> {
                for (int i = 0; i < n; i++) arr[i] = i;
                for (int i = 0; i < n / 100; i++) {
                    int a = rand.nextInt(n);
                    int b = rand.nextInt(n);
                    int tmp = arr[a];
                    arr[a] = arr[b];
                    arr[b] = tmp;
                }
            }
            default -> throw new IllegalArgumentException("Invalid input type: " + type);
        }
        return arr;
    }
}
