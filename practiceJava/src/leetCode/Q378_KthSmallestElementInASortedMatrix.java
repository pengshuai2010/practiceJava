package leetCode;

import java.util.PriorityQueue;

/**
 * Created by shuaipeng on 11/2/16.
 */
public class Q378_KthSmallestElementInASortedMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}};
        for (int i = 1; i <= matrix.length * matrix.length; i++)
            System.out.println(new Q378_KthSmallestElementInASortedMatrix().kthSmallest(matrix, i));
    }

    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}};

    // optimization: Suppose k is less than numRows or numCols, there is no need to search for beyond that
    private static boolean inBoundary(int row, int col, int numRows, int numCols, int k) {
        // the direction only goes right or down, so we don't need to check for ">= 0"
        return row < numRows && row < k && col < numCols && col < k;
    }

    // BFS with PriorityQueue
    public int kthSmallest(int[][] matrix, int k) {
        // clarify if k and matrix will be valid
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            throw new IllegalArgumentException("invalid matrix");
        }
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        if (k < 0 || k > numRows * numCols) {
            throw new IllegalArgumentException("invalid k value");
        }
        PriorityQueue<Location> minHeap = new PriorityQueue<>((Location a, Location b) -> a.value - b.value);
        boolean[][] visited = new boolean[numRows][numCols];
        minHeap.add(new Location(0, 0, matrix[0][0]));
        visited[0][0] = true;
        int count = 0;
        while (count < k - 1) {
            Location location = minHeap.remove();
            count++;
            for (int[] direction : DIRECTIONS) {
                int row = location.row + direction[0];
                int col = location.col + direction[1];
                if (inBoundary(row, col, numRows, numCols, k) && !visited[row][col]) {
                    minHeap.add(new Location(row, col, matrix[row][col]));
                    visited[row][col] = true;
                }
            }
        }
        return minHeap.remove().value;
    }

    private static class Location {
        int row;
        int col;
        int value;

        Location(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
}
