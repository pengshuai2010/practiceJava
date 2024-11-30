package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Q339_NestedListWeightSum_LevelOrderTraversal {
    // level order traversal.
    // if a NestedInteger is an integer, sum += integer * level
    // else unpack to a list, add to the queue for process in the next level
    int depthSum(List<NestedInteger> nestedList) {
        // clarify if input can be null
        int sum = 0;
        Deque<NestedInteger> queue = new ArrayDeque<>(nestedList);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger item = queue.removeFirst();
                if (item.isInteger()) {
                    sum += item.getInteger() * level;
                } else {
                    List<NestedInteger> list = item.getList();
                    for (NestedInteger nestedInteger : list) {
                        queue.addLast(nestedInteger);
                    }
                }
            }
            level++;
        }
        return sum;
    }
}
