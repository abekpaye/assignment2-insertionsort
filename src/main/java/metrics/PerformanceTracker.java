package metrics;

/* Tracks performance metrics for sorting algorithms:
* comparisons, swaps, reads/writes and memory allocations
 */
public class PerformanceTracker {
    private long comparisons = 0;
    private long swaps = 0;
    private long arrayAccesses = 0;
    private long memoryAllocations = 0;

    public void incrementComparisons() { comparisons++; }
    public void incrementSwaps() { swaps++; }
    public void incrementArrayAccesses() { arrayAccesses++; }
    public void incrementArrayAccesses(long count) { arrayAccesses += count; }
    public void incrementMemoryAllocations() { memoryAllocations++; }

    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getArrayAccesses() { return arrayAccesses; }
    public long getMemoryAllocations() { return memoryAllocations; }

    public void reset() {
        comparisons = swaps = arrayAccesses = memoryAllocations = 0;
    }

    @Override
    public String toString() {
        return "Comparisons: " + comparisons +
                ", Swaps: " + swaps +
                ", Array Accesses: " + arrayAccesses +
                ", Memory Allocations: " + memoryAllocations;
    }
}
