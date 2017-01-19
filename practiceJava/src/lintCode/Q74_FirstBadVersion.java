package lintCode;

/**
 * public class SVNRepo { public static boolean isBadVersion(int k); } you can
 * use SVNRepo.isBadVersion(k) to judge whether the kth code version is bad or
 * not.
 */
public class Q74_FirstBadVersion {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        //ask interviewer: is it guaranteed there's at least one bad version?
        if (n < 1) {
            throw new java.lang.IllegalArgumentException();
        }
        int low = 1;
        int high = n;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            boolean isBad = isBadVersion(mid);
            if (isBad) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        if (isBadVersion(low)) {
            return low;
        }
        return high;//assuming there's at least one bad version
    }

    /**
     * a place holder to get rid of IDE error messages
     */
    private boolean isBadVersion(int v) {
        return false;
    }

}
