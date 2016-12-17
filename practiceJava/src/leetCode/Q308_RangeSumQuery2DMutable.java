package leetCode;

/**
 * Created by speng on 12/16/16.
 */
public class Q308_RangeSumQuery2DMutable {
    private int[][] tree;
    private int[][] nums;
    private int m;
    private int n;

    /**
     * 2-D Binary Indexed Tree solution. Updating one element takes O(log(m)*log(n)) time, querying takes O(log(m)*log(n)) times.
     * <p>
     * Another solution is 2-D segment tree, but 2-D segment tree way more complex to implement than 2-D binary indexed tree.
     */
    public Q308_RangeSumQuery2DMutable(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        m = matrix.length;
        n = matrix[0].length;
        tree = new int[m + 1][n + 1];
        nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        Q308_RangeSumQuery2DMutable numMatrix = new Q308_RangeSumQuery2DMutable(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        numMatrix.update(3, 2, 2);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
    }

    public void update(int row, int col, int val) {
        if (m == 0 || n == 0) return;
        int delta = val - nums[row][col];
        nums[row][col] = val;
        for (int i = row + 1; i <= m; i += i & (-i)) {
            for (int j = col + 1; j <= n; j += j & (-j)) {// when entering the inner loop, each time j starts from col + 1
                tree[i][j] += delta;
            }
        }
    }

    private int query(int row, int col) {
        int sum = 0;
        for (int i = row + 1; i > 0; i -= i & (-i)) {
            for (int j = col + 1; j > 0; j -= j & (-j)) {
                sum += tree[i][j];
            }
        }
        return sum;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return query(row2, col2) - query(row2, col1 - 1) - query(row1 - 1, col2) + query(row1 - 1, col1 - 1);
    }
}
