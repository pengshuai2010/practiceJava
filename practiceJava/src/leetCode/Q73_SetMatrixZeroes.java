package leetCode;

import java.util.Arrays;

/**
 * Created by shuaipeng on 11/30/16.
 */
public class Q73_SetMatrixZeroes {
    /**
     * time complexity m*n + m'*n +m*n', where m' and n' are the number of zero rows and columns
     * space complexity is O(m + n), we can do better by storing isZeroRow and isZeroCol in the matrix. e.g.
     * use matrix[1][0] ~ matrix[m - 1][0] to store isZeroRow[1] ~ isZeroRow[m - 1], use matrix[0][1] ~ matrix[0][n - 1]
     * to store isZeroCol[1] ~ isZero[n - 1]. we need two other variable for isZeroRow[0] and isZeroCol[0]
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] isZeroRow = new boolean[m];
        boolean[] isZeroCol = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    isZeroRow[i] = true;
                    isZeroCol[j] = true;
                }
            }
        }
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (isZeroRow[i] || isZeroCol[j]) {
        //             matrix[i][j] = 0;
        //         }
        //     }
        // }
        // compared to the commented code, the following piece of code's time complexity is m'*n + m*n', where m' and n' are number of zero rows and cols
        //which is better than 2*m*n
        for (int i = 0; i < m; i++) {
            if (isZeroRow[i]) {
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int j = 0; j < n; j++) {
            if (isZeroCol[j]) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        return;
    }
}
