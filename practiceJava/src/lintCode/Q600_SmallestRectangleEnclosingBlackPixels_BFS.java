package lintCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by shuaipeng on 2/2/17.
 */
public class Q600_SmallestRectangleEnclosingBlackPixels_BFS {
    /**
     * Using BFS takes O(mn) time. Using binary search takes only O(m*log(m) + n*log(n)) time
     *
     * @param image a binary matrix with '0' and '1'
     * @param x,    y the location of one of the black pixels
     * @return an integer
     */
    private static final int[][] DIRECTIONS =
            new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static final char BLACK_PIXEL = '1';

    private static boolean inBoundary(int numRows, int numCols, Location location) {
        return location.row >= 0 && location.row < numRows && location.col >= 0
                && location.col < numCols;
    }

    /**
     * @param image: a binary matrix with '0' and '1'
     * @param x:     the location of one of the black pixels
     * @param y:     the location of one of the black pixels
     * @return: an integer
     */
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image[0].length == 0 || image[0] == null
                || image[0].length == 0) {
            return 0;
        }
        int numRows = image.length;
        int numCols = image[0].length;
        // check x, y in boundary
        Location startLocation = new Location(x, y);
        if (!inBoundary(numRows, numCols, startLocation)) {
            return 0;
        }
        // assuming (x, y) is guranteed to be a black pixel
        Deque<Location> queue = new ArrayDeque<>();
        queue.addLast(startLocation);
        int minRow = x;
        int maxRow = x;
        int minCol = y;
        int maxCol = y;
        boolean[][] visited = new boolean[numRows][numCols];
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Location location = queue.removeFirst();
            for (int[] direction : DIRECTIONS) {
                int neighborRow = location.row + direction[0];
                int neighborCol = location.col + direction[1];
                Location neighbor = new Location(neighborRow, neighborCol);
                if (inBoundary(numRows, numCols, neighbor)
                        && !visited[neighbor.row][neighbor.col]
                        && image[neighbor.row][neighbor.col] == BLACK_PIXEL) {
                    queue.addLast(neighbor);
                    minRow = Math.min(minRow, neighbor.row);
                    maxRow = Math.max(maxRow, neighbor.row);
                    minCol = Math.min(minCol, neighbor.col);
                    maxCol = Math.max(maxCol, neighbor.col);
                    visited[neighbor.row][neighbor.col] = true;
                }
            }
        }
        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }
}

class Location {
    int row;
    int col; // omit getters and setters

    Location(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
