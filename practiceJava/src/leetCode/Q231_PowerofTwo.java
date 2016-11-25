package leetCode;

/**
 * Created by speng on 11/24/16.
 */
public class Q231_PowerofTwo {
    /**
     * takes O(log(n)) time. For an int type, it takes at most 32 iterations.
     */
    public boolean isPowerOfTwo1(int n) {
        if (n < 1)
            return false;
        long m = 1;
        while (m < n)
            m <<= 1;
        return m == n;
    }

    /**
     * O(1) time solution using n & (n - 1) trick
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
