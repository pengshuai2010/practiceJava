package lintCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by speng on 2/4/17.
 */
public class Q573_BuildPostOfficeII {
    private static final int EMPTY = 0;//good practise to use constant instead of literal number
    private static final int HOUSE = 1;
    private static final int WALL = 2;
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * @param grid a 2D grid
     * @return an integer
     */
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        int[][] visitCount = new int[m][n];
        int numHouses = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == HOUSE) {
                    bfs(grid, i, j, dist, visitCount);//split into methods so the code has clear structure and is readable
                    numHouses++;
                }
            }
        }
        boolean found = false;
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == EMPTY && visitCount[i][j] == numHouses) {
                    found = true;
                    minDist = Math.min(minDist, dist[i][j]);
                }
            }
        }
        if (found) {
            return minDist;
        }
        return -1;
    }

    private void bfs(int[][] grid, int x, int y, int[][] dist, int[][] visitCount) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x, y));
        visited[x][y] = true;
        int layer = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinate curr = queue.poll();
                if (layer > 0) {
                    dist[curr.x][curr.y] += layer;
                    visitCount[curr.x][curr.y]++;
                }
                for (int[] dir : dirs) {
                    int p = curr.x + dir[0];
                    int q = curr.y + dir[1];
                    if (isValidMove(p, q, grid, visited)) {
                        queue.offer(new Coordinate(p, q));
                        visited[p][q] = true;
                    }
                }
            }
            layer++;
        }
    }

    private boolean isValidMove(int x, int y, int[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        return x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == EMPTY && !visited[x][y];
    }

    private class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
