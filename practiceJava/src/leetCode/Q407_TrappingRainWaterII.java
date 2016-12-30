package leetCode;

import java.util.PriorityQueue;

/**
 * Created by shuaipeng on 12/29/16.
 */
public class Q407_TrappingRainWaterII {
    /**
     * In Trapping Rain Water I, we use two pointers to mark the two ends of the boundary, and each time move the pointer
     * that is smaller. In this 2-D version, the boundary becomes a closed curve. We need to put the all elements on the
     * closed curve into a collection, and get the one with smallest height. A min heap is a natural choice for this
     * purpose.
     */
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0] == null || heightMap[0].length == 0) {
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<Cell> boundary = new PriorityQueue<>(1, (a, b) -> a.height - b.height);
        boolean[][] visited = new boolean[m][n];
        for (int j = 0; j < n; j++) {
            boundary.offer(new Cell(0, j, heightMap[0][j]));
            visited[0][j] = true;
            boundary.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[m - 1][j] = true;
        }
        for (int i = 0; i < m; i++) {
            boundary.offer(new Cell(i, 0, heightMap[i][0]));
            visited[i][0] = true;
            boundary.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][n - 1] = true;
        }
        int water = 0;
        int maxHeight = 0;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!boundary.isEmpty()) {
            Cell cell = boundary.poll();
            maxHeight = Math.max(maxHeight, cell.height);
            water += maxHeight - cell.height;
            for (int[] dir : dirs) {
                int i = cell.row + dir[0], j = cell.col + dir[1];
                if (i >= 0 && i < m && j >= 0 && j < n && !visited[i][j]) {
                    boundary.offer(new Cell(i, j, heightMap[i][j]));
                    visited[i][j] = true;
                }
            }
        }
        return water;
    }

    private class Cell {
        int row;
        int col;
        int height;

        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}
