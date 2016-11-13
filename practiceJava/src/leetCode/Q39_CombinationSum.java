package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by speng on 11/12/16.
 */
public class Q39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> solutions = new ArrayList<>();
        if (candidates == null || candidates.length == 0 || target <= 0)
            return solutions;
        dfs(0, 0, target, candidates, new LinkedList<Integer>(), solutions);
        return solutions;
    }

    private void dfs(int index, int sum, int target, int[] candidates, LinkedList<Integer> partial, List<List<Integer>> solutions) {
        if (sum > target)
            return;
        if (sum == target) {
            List<Integer> list = new ArrayList<>();
            list.addAll(partial);
            solutions.add(list);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int num = candidates[i];
            if (sum + num > target)
                break;
            partial.add(num);
            dfs(i, sum + num, target, candidates, partial, solutions);
            partial.removeLast();
        }
    }
}
