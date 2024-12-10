package leetCode;

public class Q766_ToeplitzMatrix {
    private static boolean inBoundary(int row, int col, int numRows, int numCols) {
        return row >= 0 && row < numRows && col >= 0 && col < numCols;
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        // what if matrix is null, or empty?
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (inBoundary(row + 1, col + 1, numRows, numCols) && matrix[row][col] != matrix[row + 1][col + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
