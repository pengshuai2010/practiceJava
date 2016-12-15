package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaipeng on 11/30/16.
 */
public class Q78_Subsets {
    public List<List<Integer>> subsets1(int[] nums) {
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

    /**
     * use integer in range [0, 1 << n) to represent 2^n combinations. This is easier than DFS.
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> solutions = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            solutions.add(new ArrayList<>());//add the empty set
            return solutions;
        }
        for (int i = 0; i < (1 << nums.length); i++) {
            solutions.add(getSubset(nums, i));
        }
        return solutions;
    }

    private List<Integer> getSubset(int[] nums, int x) {
        int mask = 1 << (nums.length - 1);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++, mask >>= 1) {
            if ((x & mask) > 0) {
                list.add(nums[i]);
            }
        }
        return list;
    }
}
