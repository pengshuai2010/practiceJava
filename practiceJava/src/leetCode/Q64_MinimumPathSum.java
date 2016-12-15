package leetCode;

/**
 * Created by speng on 12/14/16.
 */
public class Q64_MinimumPathSum {
    /**
     * takes O(mn) time, O(n) space
     */
    public int minPathSum1(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[] prev = new int[n];
        prev[0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            prev[j] = prev[j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            int[] curr = new int[n];
            curr[0] = grid[i][0] + prev[0];
            for (int j = 1; j < n; j++) {
                curr[j] = grid[i][j] + Math.min(prev[j], curr[j - 1]);
            }
            prev = curr;
        }
        return prev[n - 1];
    }

    /**
     * takes O(mn) time, O(mn) space
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
