package leetCode;

/**
 * Created by speng on 1/2/17.
 */
public class Q275_H_IndexII {
    /**
     * takes O(n) time
     */
    public int hIndex1(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int h = 0;
        while (h < n && citations[n - 1 - h] > h) {
            h++;
        }
        return h;
    }

    /**
     * Binary search, takes O(log(n)) time.
     * Any problem that can tell you lower or higher for a guess, can be solved by binary search
     */
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        //consider corner cases e.g. [0], [0, 1]
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (citations[mid] > n - mid) {
                high = mid - 1;
            } else if (citations[mid] < n - mid) {
                low = mid + 1;
            } else {
                return n - mid;
            }
        }
        return n - low;
    }
}
