package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by speng on 12/17/16.
 */
public class Q286_WallsAndGates {
    /**
     * Shortest distance problems are often BFS problems. When we see "the distance to its nearest gate", immediately
     * consider BFS. In this problem, there can be more than one sources, we add all the sources to the queue and do
     * a typical layer traversal.
     */
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) {
            return;
        }
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int numLayer = 0;
        while (!queue.isEmpty()) {
            numLayer++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] coor = queue.poll();
                for (int[] dir : dirs) {
                    int i = coor[0] + dir[0], j = coor[1] + dir[1];
                    if (i >= 0 && i < m && j >= 0 && j < n && rooms[i][j] == Integer.MAX_VALUE) {
                        rooms[i][j] = numLayer;
                        queue.offer(new int[]{i, j});
                    }
                }
            }
        }
    }
}
