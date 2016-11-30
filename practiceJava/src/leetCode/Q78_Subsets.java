package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaipeng on 11/30/16.
 */
public class Q78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> solutions = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            solutions.add(new ArrayList<>());//add the empty set
            return solutions;
        }
        dfs(nums, 0, new ArrayList<>(), solutions);
        return solutions;
    }

    private void dfs(int[] nums, int index, List<Integer> partial, List<List<Integer>> solutions) {
        // unlike combination, we need to add all subset, not just subsets of particular size
        // so there's no exit condition like (partial.size() == k) or (k == 0)
        List<Integer> tmp = new ArrayList<>();
        tmp.addAll(partial);
        solutions.add(tmp);
        for (int i = index; i < nums.length; i++) {
            partial.add(nums[i]);
            dfs(nums, i + 1, partial, solutions);
            partial.remove(partial.size() - 1);
        }
    }
}
