package cli;

import algorithms.InsertionSort;
import metrics.PerformanceTracker;
import metrics.BenchmarkCSVExporter;

import java.io.IOException;
import java.util.Random;

/**
 * Automated benchmarking for InsertionSort.
 * Generates CSV results for later plotting.
 */
public class BenchmarkRunner {

    private static final int[] SIZES = {100, 1000, 5000, 10000, 50000};
    private static final String[] INPUT_TYPES = {"random", "sorted", "reverse", "nearlySorted"};

    public static void main(String[] args) throws IOException {
        BenchmarkCSVExporter exporter = new BenchmarkCSVExporter("docs/performance-plots/insertion_benchmark.csv");
        exporter.writeHeader();

        for (String type : INPUT_TYPES) {
            for (int n : SIZES) {
                int[] arr = generateArray(type, n);
                PerformanceTracker tracker = new PerformanceTracker();

                long start = System.nanoTime();
                InsertionSort.sort(arr, tracker);
                long end = System.nanoTime();

                double timeMs = (end - start) / 1_000_000.0;
                exporter.appendResult(
                        type, n,
                        tracker.getComparisons(),
                        tracker.getSwaps(),
                        tracker.getArrayAccesses(),
                        timeMs
                );
                System.out.printf("%s (n=%d) done%n", type, n);
            }
        }
        System.out.println("\nBenchmark complete. Results saved to docs/performance-plots/insertion_benchmark.csv");
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
                for (int i = 0; i < n / 100; i++) { // 1% случайных обменов
                    int a = rand.nextInt(n);
                    int b = rand.nextInt(n);
                    int tmp = arr[a];
                    arr[a] = arr[b];
                    arr[b] = tmp;
                }
            }
        }
        return arr;
    }
}
