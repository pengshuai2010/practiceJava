package leetCode;

/**
 * Created by speng on 11/29/16.
 */
public class Q74_SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int iMid = mid / n;
            int jMid = mid % n;
            if (matrix[iMid][jMid] > target) {
                high = mid - 1;
            } else if (matrix[iMid][jMid] < target) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
