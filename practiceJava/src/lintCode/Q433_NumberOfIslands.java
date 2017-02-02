package lintCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by speng on 2/1/17.
 */
public class Q433_NumberOfIslands {
    /**
     * This problem can also be solved using DFS. However, since DFS uses recursion, when the matrix is large, there can
     * be a stack over flow exception. So always use BFS instead of DFS when possible.
     *
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        // ask interviewer if input matrix can be changed
        // if can be changed, we can save the space for visited matrix
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int numIslands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) {
                    numIslands++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    grid[i][j] = false;
                    while (!queue.isEmpty()) {
                        int[] coord = queue.poll();
                        for (int[] dir : dirs) {
                            int x = coord[0] + dir[0];
                            int y = coord[1] + dir[1];
                            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y]) {
                                grid[x][y] = false;
                                queue.offer(new int[]{x, y});
                            }
                        }
                    }
                }
            }
        }
        return numIslands;
    }
}
