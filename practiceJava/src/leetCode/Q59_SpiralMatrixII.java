package leetCode;

/**
 * Created by shuaipeng on 11/14/16.
 */
public class Q59_SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if (n <= 0)
            return new int[0][];
        int[][] matrix = new int[n][n];
        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;
        int direction = 0;
        int num = 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            switch (direction) {
                case 0://go right
                    for (int col = colBegin; col <= colEnd; col++) {
                        matrix[rowBegin][col] = num;
                        num++;
                    }
                    rowBegin++;
                    direction = 1;
                    break;
                case 1://go down
                    for (int row = rowBegin; row <= rowEnd; row++) {
                        matrix[row][colEnd] = num;
                        num++;
                    }
                    colEnd--;
                    direction = 2;
                    break;
                case 2://go left
                    for (int col = colEnd; col >= colBegin; col--) {
                        matrix[rowEnd][col] = num;
                        num++;
                    }
                    rowEnd--;
                    direction = 3;
                    break;
                case 3://go up
                    for (int row = rowEnd; row >= rowBegin; row--) {
                        matrix[row][colBegin] = num;
                        num++;
                    }
                    colBegin++;
                    direction = 0;
                    break;
                default:
            }
        }
        return matrix;
    }
}
