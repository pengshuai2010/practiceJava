package leetCode;

/**
 * Created by speng on 12/4/16.
 */
public class Q69_Sqrt_x {
    /**
     * this is in fact a binary search in the space [1, 1<<16 - 1]
     */
    public int mySqrt1(int x) {
        // assuming x >= 0
        if (x == 0) {
            return 0;
        }
        long res = 0;// use long in case weird things happens with signed int
        long mask = 1L << 15;
        while (mask > 0) {
            res |= mask;
            if (res * res > x) {
                res ^= mask;
            }
            mask >>= 1;
        }
        return (int) res;
    }

    /**
     * a binary search in the range [1, x]
     * <p>
     * In this problem we know the solution is in a certain space, and we can find if a number is lower or higher than the solution:
     * this is ideal for a binary search.
     */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        long low = 1;// use long in case overflow when mid*mid
        long high = x;
        while (low < high) {
            long mid = low + (high - low) / 2;
            long square = mid * mid;
            if (square > x) {
                high = mid - 1;
            } else if (square < x) {
                low = mid + 1;
            } else {
                return (int) mid;
            }
        }
        // note that we want the floor of sqrt(x)
        if (low * low > x) {
            return (int) low - 1;
        }
        return (int) low;
    }
}
