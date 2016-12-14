package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by speng on 12/13/16.
 */
public class Q118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if (numRows < 1) {
            return lists;
        }
        lists.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            List<Integer> prev = lists.get(i - 1);
            for (int j = 0; j < prev.size() - 1; j++) {
                curr.add(prev.get(j) + prev.get(j + 1));
            }
            curr.add(1);
            lists.add(curr);
        }
        return lists;
    }
}
