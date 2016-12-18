package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by speng on 12/18/16.
 */
public class Q317_ShortestDistanceFromAllBuildings {
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
        Q317_ShortestDistanceFromAllBuildings solution = new Q317_ShortestDistanceFromAllBuildings();
        System.out.println(solution.shortestDistance(input));
    }

    /**
     * This a obvious BFS problelm but there are quite some corner cases to be considered.
     * For example, a building may be surrounded be other buildings so no node can reach. So we need to count total number
     * of buildings, and for each spot how many buildings are reachable.
     * <p>
     * Have an matrix int[][] distance. From each building, do a BFS to find the distance to each '0', and add it to the
     * corresponding element in int[][] distance. Have an matrix int[][] reachableBuildings. While doing BFS, increase
     * the number of reachable buildings in the matrix reachableBuildings. At last, traverse through distance[][], find
     * the '0' that has shortest distance to ALL buildings(reachableBuildings[i][j] == total buildings).
     * <p>
     * Time complexity is O(m^2*n^2) as we need a BSF from each of the buildings.
     */
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] distance = new int[m][n];
        int[][] reachableBuildings = new int[m][n];
        int numBuildings = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, i, j, distance, reachableBuildings);
                    numBuildings++;
                }
            }
        }
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (distance[i][j] > 0 && reachableBuildings[i][j] == numBuildings) {
                    minDist = distance[i][j] < minDist ? distance[i][j] : minDist;
                }
            }
        }
        if (minDist == Integer.MAX_VALUE) {
            return -1;
        }
        return minDist;
    }

    private void bfs(int[][] grid, int xx, int yy, int[][] distance, int[][] reachableBuildings) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        visited[xx][yy] = true;
        queue.offer(new int[]{xx, yy});
        int numLayer = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] coord = queue.poll();
                int x = coord[0], y = coord[1];
                distance[x][y] += numLayer;
                for (int[] dir : dirs) {
                    int i = x + dir[0], j = y + dir[1];
                    if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 0 && !visited[i][j]) {
                        visited[i][j] = true;//mark visited when putting a node into queue to avoid add it into queue twice
                        reachableBuildings[i][j]++;
                        queue.offer(new int[]{i, j});
                    }
                }
            }
            numLayer++;
        }
    }
}
