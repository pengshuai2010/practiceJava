package leetCode;

/**
 * Created by speng on 11/14/16.
 */
public class Q63_UniquePathsII {
    /**
     * when there's obstacle, using an array instead of matrix is tricky
     * in the first row, elements on the obstacle and afte it are all 0's
     * int the first col, elements on the obstacle and below it are all 0's
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0
                || obstacleGrid[0] == null || obstacleGrid[0].length == 0)
            return 0;
        int numRows = obstacleGrid.length;
        int numCols = obstacleGrid[0].length;
        int[][] dp = new int[numRows][numCols];
        for (int j = 0; j < numCols; j++) {
            if (obstacleGrid[0][j] == 1)
                break;
            dp[0][j] = 1;
        }
        for (int i = 0; i < numRows; i++) {
            if (obstacleGrid[i][0] == 1)
                break;
            dp[i][0] = 1;
        }
        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j < numCols; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[numRows - 1][numCols - 1];
    }
}
