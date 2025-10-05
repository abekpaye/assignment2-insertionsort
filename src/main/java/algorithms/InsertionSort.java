package algorithms;

import metrics.PerformanceTracker;

/*
 * Implementation of Insertion Sort algorithm with optimization
 * for nearly-sorted data using binary search for insertion position.
*/
public class InsertionSort {

    public static void sort(int[] arr, PerformanceTracker tracker) {
        //Input validation
        if (arr == null || arr.length <= 1) {
            if (tracker != null) tracker.incrementMemoryAllocations(); // count main array
            return;
        }

        int n = arr.length;
        tracker.incrementMemoryAllocations(); //input array allocation

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            tracker.incrementArrayAccesses(); //read arr[i]
            int j = i - 1;

            tracker.incrementComparisons();

            //Optimization: skip if already sorted
            tracker.incrementArrayAccesses(); // arr[j]
            if (arr[j] <= key) continue;

            // Binary search for insertion position
            int insertPos = binarySearch(arr, key, 0, j, tracker);

            // Shift elements right to make room
            while (j >= insertPos) {
                tracker.incrementArrayAccesses(2); // read arr[j], write arr[j+1]
                arr[j + 1] = arr[j];
                tracker.incrementSwaps();
                j--;
            }

            tracker.incrementArrayAccesses(); // write key
            arr[insertPos] = key;
        }
    }

    //Binary search to find the insertion position
    private static int binarySearch(int[] arr, int key, int low, int high, PerformanceTracker tracker) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            tracker.incrementArrayAccesses(); // read arr[mid]
            tracker.incrementComparisons();
            if (arr[mid] == key)
                return mid + 1;
            else if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
}
