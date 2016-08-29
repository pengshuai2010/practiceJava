package lintCode;

/**
 * Created by shuaipeng on 8/26/16.
 */
public class Q115 {
    public static void main(String[] args) {
        int[][] obstacleGrid = new int[3][];
        obstacleGrid[0] = new int[]{0, 0, 0};
        obstacleGrid[1] = new int[]{1, 0, 0};
        obstacleGrid[2] = new int[]{0, 0, 0};
        System.out.println(new Q115().uniquePathsWithObstacles(obstacleGrid));
    }

    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0)
            return 0;
        for (int[] row : obstacleGrid)
            if (row == null || row.length == 0)
                return 0;
        // ask questions to clarify in a interview!
        // assuming that obstacleGrid is a rectangle
        // if not rectangle, we can change obstacleGrid or a copy of it
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] prev = new int[n];
        int[] curr = new int[n];
        boolean firstRowObstacle = false;
        for (int i = 0; i < n; i++)
            if (firstRowObstacle || obstacleGrid[0][i] == 1) {
                prev[i] = 0;
                firstRowObstacle = true;
            } else
                prev[i] = 1;
        // watch out this pitfall
        boolean firstColObstacle = false;
        if (obstacleGrid[0][0] == 1)
            firstColObstacle = true;
        for (int i = 1; i < m; i++) {
            if (firstColObstacle || obstacleGrid[i][0] == 1) {
                curr[0] = 0;
                firstColObstacle = true;
            } else
                curr[0] = 1;
            for (int j = 1; j < n; j++)
                if (obstacleGrid[i][j] == 1)
                    curr[j] = 0;
                else
                    curr[j] = curr[j - 1] + prev[j];
            int[] tmp = prev;
            prev = curr;
            curr = tmp;
        }
        return prev[n - 1];
    }

    // this solution is simpler, but uses O(m*n) space.
    // we can explain to the interview that, if space efficiency is important, we can first write a simple, inefficient
    // version, then write a more complex but efficient version, then use the first version to check the correctness of
    // the second one.
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0)
            return 0;
        for (int[] row : obstacleGrid)
            if (row == null || row.length == 0)
                return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++)
            if (obstacleGrid[i][0] == 1)
                break;
            else
                grid[i][0] = 1;
        for (int j = 0; j < n; j++)
            if (obstacleGrid[0][j] == 1)
                break;
            else
                grid[0][j] = 1;
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (obstacleGrid[i][j] == 1)
                    grid[i][j] = 0;
                else
                    grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
        return grid[m - 1][n - 1];
    }
}
