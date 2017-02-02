package lintCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shuaipeng on 2/2/17.
 */
public class Q600_SmallestRectangleEnclosingBlackPixels {
    /**
     * Using BFS takes O(mn) time. Using binary search takes only O(m*log(m) + n*log(n)) time
     *
     * @param image a binary matrix with '0' and '1'
     * @param x,    y the location of one of the black pixels
     * @return an integer
     */
    public int minArea(char[][] image, int x, int y) {
        //ask interviewer if we can change the input graph
        if (image == null || image.length == 0 || image[0] == null || image[0].length == 0) {
            throw new java.lang.IllegalArgumentException();
        }
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = image.length;
        int n = image[0].length;
        int minX = m - 1;
        int maxX = 0;
        int minY = n - 1;
        int maxY = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        image[x][y] = '0';
        while (!queue.isEmpty()) {
            int[] coord = queue.poll();
            minX = Math.min(minX, coord[0]);
            maxX = Math.max(maxX, coord[0]);
            minY = Math.min(minY, coord[1]);
            maxY = Math.max(maxY, coord[1]);
            for (int[] dir : dirs) {
                int p = coord[0] + dir[0];
                int q = coord[1] + dir[1];
                if (p >= 0 && p < m && q >= 0 && q < n && image[p][q] == '1') {
                    queue.offer(new int[]{p, q});
                    image[p][q] = '0';
                }
            }
        }
        return (maxY - minY + 1) * (maxX - minX + 1);
    }
}
