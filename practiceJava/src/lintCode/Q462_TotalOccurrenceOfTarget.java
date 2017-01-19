package lintCode;

/**
 * Created by speng on 1/18/17.
 */
public class Q462_TotalOccurrenceOfTarget {
    /**
     * @param a      an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] a, int target) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int low = 0;
        int high = a.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (a[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        int start = -1;
        if (a[low] == target) {
            start = low;
        } else if (a[high] == target) {
            start = high;
        }
        if (start == -1) {
            return 0;
        }
        low = start;
        high = a.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (a[mid] <= target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        int end = low;
        if (a[high] == target) {
            end = high;
        }
        return end - start + 1;
    }
}
