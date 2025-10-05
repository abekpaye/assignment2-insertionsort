package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for InsertionSort algorithm:
 * - Empty arrays
 * - Single elements
 * - Duplicates
 * - Already sorted arrays
 * - Reverse-sorted arrays
 * - Nearly sorted arrays
 */
class InsertionSortTest {

    private PerformanceTracker tracker;

    @BeforeEach
    void setup() {
        tracker = new PerformanceTracker();
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        InsertionSort.sort(arr, tracker);
        assertArrayEquals(new int[]{}, arr);
        assertTrue(tracker.getComparisons() >= 0);
    }

    @Test
    void testSingleElement() {
        int[] arr = {42};
        InsertionSort.sort(arr, tracker);
        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        InsertionSort.sort(arr, tracker);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testReverseSorted() {
        int[] arr = {5, 4, 3, 2, 1};
        InsertionSort.sort(arr, tracker);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testWithDuplicates() {
        int[] arr = {3, 1, 2, 3, 2};
        InsertionSort.sort(arr, tracker);
        assertArrayEquals(new int[]{1, 2, 2, 3, 3}, arr);
    }

    @Test
    void testNearlySorted() {
        int[] arr = {1, 2, 4, 3, 5};
        InsertionSort.sort(arr, tracker);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testNullArrayDoesNotThrow() {
        assertDoesNotThrow(() -> InsertionSort.sort(null, tracker));
    }
}
