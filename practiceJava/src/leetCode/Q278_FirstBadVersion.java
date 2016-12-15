package leetCode;

/**
 * Created by speng on 12/14/16.
 */
public class Q278_FirstBadVersion {
    public int firstBadVersion(int n) {
        if (n < 1) {
            return -1;
        }
        int low = 1, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            boolean isBad = isBadVersion(mid);
            if (isBad) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * boolean isBadVersion(int n) is an API that will be called. We have it here just to avoid IDE error message.
     */
    private boolean isBadVersion(int n) {
        return false;
    }
}
