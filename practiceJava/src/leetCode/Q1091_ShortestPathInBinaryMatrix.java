package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q1091_ShortestPathInBinaryMatrix {
    private static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    private static boolean inBoundary(int row, int col, int numRows, int numCols) {
        return row >= 0 && row < numRows && col >= 0 && col < numCols;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        // assuming grid is not null
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }

        int numRows = grid.length;
        int numCols = grid[0].length;
        boolean[][] visited = new boolean[numRows][numCols];
        Deque<int[]> queue = new ArrayDeque<>();
        // for the starting point, no need to check for inboundary or visited, but still need to check for validity
        if (grid[0][0] == 1) {
            return -1;
        }
        queue.addLast(new int[]{0, 0}); // state that if in work I would create a class
        visited[0][0] = true;
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.removeFirst();
                int row = curr[0];
                int col = curr[1];
                if (row == numRows - 1 && col == numCols - 1) {
                    return level;
                }
                for (int[] direction : DIRECTIONS) {
                    int neighborRow = row + direction[0];
                    int neighborCol = col + direction[1];
                    // three things to check before adding to the queue: inBoundary, visited, validity(e.g. not a wall)
                    if (inBoundary(neighborRow, neighborCol, numRows, numCols)
                            && !visited[neighborRow][neighborCol]
                            && grid[neighborRow][neighborCol] != 1) {
                        queue.addLast(new int[]{neighborRow, neighborCol});
                        visited[neighborRow][neighborCol] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
