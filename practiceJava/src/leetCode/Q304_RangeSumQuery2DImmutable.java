package leetCode;

/**
 * Created by speng on 12/16/16.
 */
public class Q304_RangeSumQuery2DImmutable {
    private int[][] sum;

    /**
     * Because the matrix is immutable, we don't need fancy data structures like 2D Bit Indexed Tree to boost update performance.
     *
     * cache the cumulative sum of region that has (0, 0) as top left and (x, y) as bottom right.
     * The cache can be calculated by dynamic programming. To avoid if statement, define dp[i][j] as the sum of the region
     * that has (0, 0) as top left and (i - 1, j - 1) as bottom right, i and j starts from 1. Then
     * dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1]
     * <p>
     * The cache takes O(mn) space, each query takes O(1) time.
     */
    public Q304_RangeSumQuery2DImmutable(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            sum = new int[][]{};
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        sum = new int[m + 1][n + 1];//to avoid a lot of if statements
        //sum[i][j] is the sum of the region that has (0, 0) as top left and (i - 1, j - 1) as bottom right.
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int i1 = row1 + 1, j1 = col1 + 1, i2 = row2 + 1, j2 = col2 + 1;
        return sum[i2][j2] - sum[i2][j1 - 1] - sum[i1 - 1][j2] + sum[i1 - 1][j1 - 1];
    }
}
