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
    private static void dfs(int[] candidates, int startIndex, int target, List<Integer> partial, List<List<Integer>> solutions) {
        if (target == 0) {
            List<Integer> copy = new ArrayList<>(partial);
            solutions.add(copy);
            return;
        } else if (target < 0) { // pruning since all candidates are positive
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            // (i > startIndex && candidates[i - 1] == candidates[i] ) so that in case of something like [1, 1, 1] we can still
            // use an element that is the same as the element
            // used last level, but won't add duplicates in this level.
            if (i > startIndex && candidates[i - 1] == candidates[i]) {
                continue;
            }
            if (target - candidates[i] < 0) { // pruning since the candidates are sorted
                break;
            }
            partial.add(candidates[i]);
            // startIndex is (i + 1) so that each element is used only once
            dfs(candidates, i + 1, target - candidates[i], partial, solutions);
            partial.remove(partial.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // clarifying questions: are there duplicates in candidates?
        // will candidate all be positive?
        List<List<Integer>> solutions = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return solutions;
        }
        Arrays.sort(candidates); // sorting allows use to deduplicate and allow pruning
        dfs(candidates, 0, target, new ArrayList<>(), solutions);
        return solutions;
    }
}
