package lintCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by speng on 2/11/17.
 */
public class Q153_CombinationSumII {
    /**
     * some test cases to consider num = [4, 4, 4, 4], target = 8
     * num = [2, 2, 6, 6], target = 8
     *
     * @param num:    Given the candidate numbers, all positive
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> solutions = new ArrayList<>();
        if (num == null || num.length == 0) {
            return solutions;
        }
        Arrays.sort(num);
        //we don't worry about the case when target == 0 because all input numbers are positive.
        dfs(num, 0, target, new ArrayList<>(), solutions);
        return solutions;
    }

    private void dfs(int[] num, int start, int target, List<Integer> path, List<List<Integer>> solutions) {
        if (target == 0) {
            solutions.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < num.length; i++) {
            if (i == start || num[i] != num[i - 1]) {//to avoid duplicates
                if (target - num[i] < 0) {//pruning branches
                    break;
                }
                path.add(num[i]);
                dfs(num, i + 1, target - num[i], path, solutions);
                path.remove(path.size() - 1);
            }
        }
    }
}
