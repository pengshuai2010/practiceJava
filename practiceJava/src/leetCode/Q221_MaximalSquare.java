package leetCode;

/**
 * Created by shuaipeng on 12/20/16.
 */
public class Q221_MaximalSquare {
    /**
     * Build a DP matrix that dp[i][j] is the number of ones in the region whose left top is (0, 0) and bottom right is (i, j).
     * dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1]. To avoid lots of if statements, we let i and j start from 1
     * to avoid dealing edge cases.
     * Now we can get number of ones in region defined by (i1, j1) and (i2, j2) in O(1) time. If the ones in a region equals
     * the area of a region, this region contains only ones. There are dp[m][n] ones in total, so the side length of largest
     * square containing only ones is sqrt(dp[m][n]). We start from the largest possible square, try every position and
     * side length, until finding one square containing only ones.
     * Time complexity is O(min(m, n) * m * n). Space complexity is O(mn).
     */
    public int maximalSquare1(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] numOnes = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                numOnes[i][j] = numOnes[i - 1][j] + numOnes[i][j - 1] - numOnes[i - 1][j - 1] + (matrix[i - 1][j - 1] - '0');
            }
        }
        for (int k = (int) Math.sqrt(numOnes[m][n]); k > 0; k--) {
            for (int i1 = 1; i1 <= m - k + 1; i1++) {
                for (int j1 = 1; j1 <= n - k + 1; j1++) {
                    int i2 = i1 + k - 1, j2 = j1 + k - 1;
                    int ones = numOnes[i2][j2] - numOnes[i2][j1 - 1] - numOnes[i1 - 1][j2] + numOnes[i1 - 1][j1 - 1];
                    int area = (i2 - i1 + 1) * (j2 - j1 + 1);
                    if (ones == area) {
                        return area;
                    }
                }
            }
        }
        return 0;
    }

    /**
     * Dynamic Programming. Define dp[i][j] as the side length of the max square that contains only 1's and that has (i,j)
     * as its bottom right corner. Then dp[i][j] = max{dp[i][j - 1], dp[i - 1][j - 1], dp[i - 1][j]} + 1 if matrix[i][j] == '1',
     * else dp[i][j] = 0. See https://leetcode.com/articles/maximal-square/#approach-2-dynamic-programming-accepted .
     * Since dp[i][j] depends on dp[i - 1][j - 1] and dp[i][j - 1], when implementing, we can let i and j start from 1 to
     * handle the edge case. Note that matrix[i][j] becomes matrix[i - 1][j - 1] if we do so.
     * And We can save space by using an array instead of matrix for DP.
     * We only need one pass, so time complexity is O(mn), space complexity is O(n)
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] prev = new int[n + 1];//handle edge cases, avoid if statements
        int maxSide = 0;
        for (int i = 1; i <= m; i++) {
            int[] curr = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                //be careful when i and j start from 1
                curr[j] = matrix[i - 1][j - 1] == '0' ? 0 : Math.min(prev[j - 1], Math.min(prev[j], curr[j - 1])) + 1;
                maxSide = Math.max(maxSide, curr[j]);
            }
            prev = curr;
        }
        return maxSide * maxSide;
    }
}
