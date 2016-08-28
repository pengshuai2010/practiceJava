package lintCode;

import java.util.Arrays;

/**
 * Created by speng on 8/27/16.
 */
public class Q109 {
    public static void main(String[] args) {
//        int[][] triangle = new int[][]{{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
//        int[][] triangle = new int[][]{{2}, {3, 4}, {6, 5, 7}};
//        int[][] triangle = new int[][]{{2}, {3, 4}};
//        int[][] triangle = new int[][]{{2}};
        int[][] triangle = new int[][]{{}};
        System.out.println(new Q109().minimumTotal(triangle));
    }

    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0 || triangle[0] == null || triangle[0].length == 0)
            return 0;
        int rows = triangle.length;
        int[] result = Arrays.copyOf(triangle[rows - 1], triangle[rows - 1].length);
        for (int i = rows - 2; i >= 0; i--) {
            int[] tmp = Arrays.copyOf(triangle[i], triangle[i].length);
            for (int j = 0; j < triangle[i].length; j++)
                tmp[j] = triangle[i][j] + Math.min(result[j], result[j + 1]);
            result = tmp;
        }
        return result[0];
    }
}
