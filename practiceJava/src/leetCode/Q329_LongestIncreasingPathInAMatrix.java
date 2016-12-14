package leetCode;

/**
 * Created by speng on 12/14/16.
 */
public class Q329_LongestIncreasingPathInAMatrix {
    /**
     * If use naive DFS, the search is repeated for every valid path, sothe time complexity is exponential. In the worst case,
     * O(4^(m + n)). Space complexity is the depth of the search tree, which is O(mn) in worst case.
     * <p>
     * By memoization, we can reduce time complexity from exponential to polynomial. When a node (i, j) is first visited,
     * the result is saved. Later when it is visited we just return the saved value. The time complexity is O(V + E).
     * There are m*n nodes, each node is calculated only once, so time complexity is O(mn). There are 4mn edges, each is
     * visited only once, so time complexity is O(mn). So overall time complexity is O(mn). Space complexity is O(mn) because
     * we need a m*n matrix for memoization.
     */
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int[][] memo = new int[matrix.length][matrix[0].length];
        int longest = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                longest = Math.max(longest, dfs(matrix, i, j, Integer.MIN_VALUE, memo));
            }
        }
        return longest;
    }

    private int dfs(int[][] matrix, int i, int j, int last, int[][] memo) {
        // for this problem, because we only go on the increasing direction, we won't turn back, so visited matrix is not needed
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= last) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int maxLength = 0;
        maxLength = Math.max(maxLength, dfs(matrix, i - 1, j, matrix[i][j], memo));
        maxLength = Math.max(maxLength, dfs(matrix, i + 1, j, matrix[i][j], memo));
        maxLength = Math.max(maxLength, dfs(matrix, i, j - 1, matrix[i][j], memo));
        maxLength = Math.max(maxLength, dfs(matrix, i, j + 1, matrix[i][j], memo));
        memo[i][j] = maxLength + 1;
        return memo[i][j];
    }
}
