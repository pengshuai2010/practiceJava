package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Q216_CombinationSumIII {
    private static void dfs(int[] candidates, int startIndex, int target, int k, List<Integer> partial,
                            List<List<Integer>> solutions) {
        if (k == 0) {
            if (target == 0) {
                List<Integer> copy = new ArrayList<>(partial);
                solutions.add(copy);
            }
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (target - candidates[i] < 0) { // pruning because the candidates are positive and in ascending order
                break;
            }
            partial.add(candidates[i]);
            dfs(candidates, i + 1, target - candidates[i], k - 1, partial, solutions);
            partial.remove(partial.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> solutions = new ArrayList<>();
        if (k < 0 || n < 0) {
            return solutions;
        }
        int[] candidates = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        dfs(candidates, 0, n, k, new ArrayList<>(), solutions);
        return solutions;
    }
}
