package lintCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shuaipeng on 2/2/17.
 */
public class Q611_KnightShortestPath {
    /**
     * @param grid    a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path
     */
    public int shortestPath(boolean[][] grid, Point source, Point dest) {
        //ask interviewer if can change input matrix.
        //if can change, we can save some space
        if (grid == null || grid.length == 0 || grid[0] == null ||
                grid[0].length == 0 || source == null || dest == null) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2},
                {-2, 1}, {-2, -1}, {-1, -2}};
        int steps = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        grid[source.x][source.y] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point curr = queue.poll();
                if (curr.x == dest.x && curr.y == dest.y) {
                    return steps;
                }
                for (int[] dir : dirs) {
                    int x = curr.x + dir[0];
                    int y = curr.y + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !grid[x][y]) {
                        queue.offer(new Point(x, y));
                        grid[x][y] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private class Point {
        int x, y;

        public Point() {
            x = 0;
            y = 0;
        }

        public Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
