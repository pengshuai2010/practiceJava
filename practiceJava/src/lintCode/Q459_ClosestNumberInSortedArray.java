package lintCode;

/**
 * Created by speng on 1/19/17.
 */
public class Q459_ClosestNumberInSortedArray {
    /**
     * @param a      an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }
        int low = 0;
        int high = a.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (a[mid] < target) {
                low = mid;
            } else if (a[mid] > target) {
                high = mid;
            } else {
                return mid;
            }
        }
        if (Math.abs(a[low] - target) < Math.abs(a[high] - target)) {
            return low;
        }
        return high;
    }
}
