package leetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

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
     *
     * We can get a transition function dp[i, j] = max{dp[x, y] | (x, y) is adjacent to (i, j) and matrix[i][j] < matrix[x][y]} + 1
     * But the problem is that we don't know the dependency without pre-processing the problem with a topological sort.
     */
    public int longestIncreasingPath1(int[][] matrix) {
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

    /**
     * find out how many layers there are while doing topological sort. Takes O(mn) time and O(mn) space.
     */
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        //count indegree
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i * n + j;
                for (int[] dir : directions) {
                    int x = i + dir[0], y = j + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] < matrix[i][j]) {
                        if (map.containsKey(index)) {
                            map.put(index, map.get(index) + 1);
                        } else {
                            map.put(index, 1);
                        }
                    }
                }
            }
        }
        //find nodes whose indegree is zero
        for (int i = 0; i < m * n; i++) {
            if (!map.containsKey(i)) {
                queue.offer(i);
            }
        }
        int layers = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int index = queue.poll();
                int i = index / n, j = index % n;
                for (int[] dir : directions) {
                    int x = i + dir[0], y = j + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                        int neighbor = x * n + y;
                        map.put(neighbor, map.get(neighbor) - 1);
                        if (map.get(neighbor) == 0) {
                            queue.offer(neighbor);
                        }
                    }
                }
            }
            layers++;
        }
        return layers;
    }
}
