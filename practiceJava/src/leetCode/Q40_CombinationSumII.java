package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * a good summary of combination, permutation, subsets problems
 * https://discuss.leetcode.com/topic/46161/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning/2
 * Created by speng on 11/12/16.
 */
public class Q40_CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> solutions = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return solutions;
        Arrays.sort(candidates);
        dfs(0, 0, target, candidates, new ArrayList<>(), solutions);
        return solutions;
    }

    private void dfs(int index, int sum, int target, int[] candidates, List<Integer> partial, List<List<Integer>> solutions) {
        if (sum > target)
            return;
        if (sum == target) {
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(partial);
            solutions.add(tmp);
            return;
        }
        for (int i = index; i < candidates.length; i++) {// Different from Q39, i starts from index
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            int num = candidates[i];
            if (sum + num > target)
                break;
            partial.add(num);
            dfs(i + 1, sum + num, target, candidates, partial, solutions);// index is increased because same number cannot appear twice in the combination
            partial.remove(partial.size() - 1);
        }
    }
}
