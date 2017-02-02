package lintCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shuaipeng on 2/2/17.
 */
public class Q598_ZombieInMatrix {
    /**
     * @param grid a 2D integer grid
     * @return an integer
     */
    public int zombie(int[][] grid) {
        //corner cases: only people; only zombie; no people or zombie.
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            throw new java.lang.IllegalArgumentException();
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        int numPeople = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 0) {
                    numPeople++;
                }
            }
        }
        int days = -1;//number of days to turn all people into zombie is the number of layers minus one
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] coord = queue.poll();
                for (int[] dir : dirs) {
                    int x = coord[0] + dir[0];
                    int y = coord[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0) {
                        grid[x][y] = 1;
                        numPeople--;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            days++;
        }
        if (numPeople != 0) {
            return -1;
        }
        return days;
    }
}
