package lintCode;

public class Q75_FindPeakElement {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        if (A == null || A.length == 0) {
            throw new java.lang.IllegalArgumentException();
        }
        int low = 1;//peek must be in the range [1, A.length - 2]
        int high = A.length - 2;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (A[mid] < A[mid + 1]) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (A[low] > A[high]) {
            return low;
        }
        return high;
    }
}
