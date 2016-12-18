package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by speng on 12/18/16.
 */
public class Q130_SurroundedRegions {
    /**
     * a region is not surrounded <=> a region has at least one element that is on the border. So we go along the 4 borders
     * of the matrix, for every 'O' on the border, we do a BSF or DFS, mark elements in the region containing it to 'V'.
     * After this, if a 'O' region is not changed to a 'V' region, that means it's not connect to a border. So we then go
     * over the matrix, change 'V' to 'O', and change 'O' to 'X'.
     * <p>
     * There is an inherent problem with DFS: if the tree is too deep, we may get a Stack Over Flow. DFS solution won't
     * pass leetcode judge because there is a test case constructed as such that recursion depth is O(mn).
     */
    public void solve1(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        // use Math.max(1, m - 1) to avoid infinite loop when m == 1
        for (int i = 0; i < m; i += Math.max(1, m - 1)) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j);
            }
        }
        for (int j = 0; j < n; j += Math.max(1, n - 1)) {
            for (int i = 0; i < m; i++) {
                dfs(board, i, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'V') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * stack overflow in worst case?
     */
    private void dfs(char[][] board, int x, int y) {
        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O') {
            board[x][y] = 'V';
            dfs(board, x - 1, y);
            dfs(board, x + 1, y);
            dfs(board, x, y - 1);
            dfs(board, x, y + 1);
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        // use Math.max(1, m - 1) to avoid infinite loop when m == 1
        for (int i = 0; i < m; i += Math.max(1, m - 1)) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        for (int j = 0; j < n; j += Math.max(1, n - 1)) {
            for (int i = 0; i < m; i++) {
                if (board[i][j] == 'O') {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        while (!queue.isEmpty()) {
            int[] coord = queue.poll();
            int x = coord[0], y = coord[1];
            board[x][y] = 'V';
            for (int[] dir : dirs) {
                int i = x + dir[0], j = y + dir[1];
                if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == 'O') {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'V') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
