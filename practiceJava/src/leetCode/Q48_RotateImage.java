package leetCode;

/**
 * Created by speng on 11/13/16.
 */
public class Q48_RotateImage {
    public static void main(String[] args) {
        Q48_RotateImage solution = new Q48_RotateImage();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(matrix);
        for (int[] row : matrix) {
            for (int num : row)
                System.out.print(num + ", ");
            System.out.println();
        }

    }

    //TODO a better way is to reverse the matrix upside down, then swap along diagonal line

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return;
        int n = matrix.length;
        for (int row = 0; row < n / 2; row++) {
            for (int col = row; col < n - row - 1; col++) {
                int val = matrix[row][col];
                int i = row;
                int j = col;
                for (int k = 0; k < 3; k++) {
                    int iPrime = n - j - 1;
                    int jPrime = i;
                    matrix[i][j] = matrix[iPrime][jPrime];
                    i = iPrime;
                    j = jPrime;
                }
                matrix[i][j] = val;
            }
        }
    }
}
