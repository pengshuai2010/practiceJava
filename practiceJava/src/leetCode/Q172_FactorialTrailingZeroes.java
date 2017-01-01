package leetCode;

/**
 * Created by speng on 12/31/16.
 */
public class Q172_FactorialTrailingZeroes {
    /**
     * In n!, number of trailing zeros = min{number of factor 5's, number of factor 2's}. Since for every 5 there are always
     * at least two 2's, we only need to count number of factor 5's. if n is greater than 5, there are at least n/5 5's
     * in n!; and if n is greater than 5^2, there are another n/(5^2) 5's in n!; and so on.
     */
    public int trailingZeroes1(int n) {
        if (n < 5) {
            return 0;
        }
        int numFives = 0;
        long powersOfFive = 5;
        while (n / powersOfFive > 0) {
            numFives += n / powersOfFive;//no need to times it by power here because already counted in previous iterations
            //note that even if we have "n / powersOfFive > 0", overflow can still occur, e.g. when 5^k < n < Integer.MAX_VALUE < 5^(k + 1)
            powersOfFive *= 5;
        }
        return numFives;
    }

    /**
     * cleaner and no need to worry about overflow! The intuition behind: 31/5 = 6. We consider it as mapping 1 to 5, 2 to 10, ... 5 to 25, 6 to 30.
     */
    public int trailingZeroes(int n) {
        if (n < 5) {
            return 0;
        }
        int numFives = 0;
        while (n > 0) {
            n /= 5;
            numFives += n;
        }
        return numFives;
    }
}
