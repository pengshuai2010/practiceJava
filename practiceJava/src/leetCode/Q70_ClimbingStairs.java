package leetCode;

/**
 * Created by speng on 11/24/16.
 */
public class Q70_ClimbingStairs {
    /**
     * fibonacci
     */
    public int climbStairs(int n) {
        if (n < 1)
            return 0;
        int a = 0;
        int b = 1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}
