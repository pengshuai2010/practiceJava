package leetCode;

import java.util.Arrays;

/**
 * Created by speng on 11/14/16.
 */
public class Q62_UniquePaths {
    /**
     * dynamic programming, takes O(m*n)
     */
    public int uniquePaths1(int m, int n) {
        if (m < 1 || n < 1)
            return 0;
        int numRows = Math.max(m, n);
        int numCols = Math.min(m, n);
        int[] prev = new int[numCols];
        Arrays.fill(prev, 1);
        for (int row = 1; row < numRows; row++) {
            int[] curr = new int[numCols];
            curr[0] = 1;
            for (int col = 1; col < numCols; col++) {
                curr[col] = curr[col - 1] + prev[col];
            }
            prev = curr;
        }
        return prev[numCols - 1];
    }

    /**
     * calculate combination, take O(m + n) time
     */
    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1)
            return 0;
        double res = 1;// use double to avoid overflow during calculation
        for (int i = 1; i < m; i++) {
            res *= (n - 1 + i) / ((double) i);
        }
        return (int) Math.round(res);
    }
}
