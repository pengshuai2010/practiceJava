package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by speng on 12/13/16.
 */
public class Q119_PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex < 0) {
            return list;
        }
        list.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = list.size() - 1; j >= 1; j--) {
                list.set(j, list.get(j) + list.get(j - 1));
            }
            list.add(1);
        }
        return list;
    }
}
