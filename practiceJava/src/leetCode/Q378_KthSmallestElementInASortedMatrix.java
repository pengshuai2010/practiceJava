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

    /**
     * use the idea of N-way merge of sorted lists
     */
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 ||
                matrix[0] == null || matrix[0].length == 0) {
            // handle invalid input
        }
        // assuming k starts from 1
        // need to clarify if k starts from 1 in an interview
        int numRows = matrix.length;
        int numCols = matrix[0].length;// assuming matrix is rectangle
        PriorityQueue<Tuple> minHeap = new PriorityQueue<>();
        for (int i = 0; i < numRows && i < k; i++)
            minHeap.offer(new Tuple(i, 0, matrix[i][0]));
        for (int i = 0; i < k - 1; i++) {
            Tuple tuple = minHeap.poll();
            if (tuple.col < numCols - 1)
                minHeap.offer(new Tuple(tuple.row, tuple.col + 1, matrix[tuple.row][tuple.col + 1]));
        }
        return minHeap.poll().val;
    }

    private class Tuple implements Comparable {
        int row;
        int col;
        int val;

        Tuple(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        @Override
        public int compareTo(Object o) {
            return val - ((Tuple) o).val;
        }
    }
}
