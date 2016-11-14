package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaipeng on 11/14/16.
 */
public class Q54_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return list;
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        int direction = 0;
        //change direction and one of rowBegin/rowEnd/colBegin/colEnd each time
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            switch (direction) {
                case 0://go right
                    for (int col = colBegin; col <= colEnd; col++)
                        list.add(matrix[rowBegin][col]);
                    rowBegin++;
                    direction = 1;
                    break;
                case 1:// go down
                    for (int row = rowBegin; row <= rowEnd; row++)
                        list.add(matrix[row][colEnd]);
                    colEnd--;
                    direction = 2;
                    break;
                case 2:// go left
                    for (int col = colEnd; col >= colBegin; col--)
                        list.add(matrix[rowEnd][col]);
                    rowEnd--;
                    direction = 3;
                    break;
                case 3:// go up
                    for (int row = rowEnd; row >= rowBegin; row--)
                        list.add(matrix[row][colBegin]);
                    colBegin++;
                    direction = 0;
                    break;
                default:
            }
        }
        return list;
    }
}
