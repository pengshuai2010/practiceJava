package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaipeng on 11/30/16.
 */
public class Q78_Subsets {
    // the time compleixty is O(n * 2^n), where 2^n is the number of solutions, and O(n) is the upper bound of the time it takes
    // to generate one solution.
    // All substes problem is quite similar to the combination problem. One difference is that the former produces a solution at
    // every node, while that later produces a solution only when partial.size() == k, suppose we are picking k numbers of n numbers.
    private static void dfs(int[] nums, int startIndex, List<Integer> partial, List<List<Integer>> results) {
        List<Integer> copy = new ArrayList<>(partial);
        results.add(copy);
        for (int i = startIndex; i < nums.length; i++) {
            partial.add(nums[i]);
            // startIndex for next level is (i + 1) so that the same number cannot be used again
            dfs(nums, i + 1, partial, results);
            partial.remove(partial.size() - 1);
        }
    }

    // different way of DFS. At each level it decides whether to add a number or not, forming a binary tree, and the solutions
    // are at the end of the tree.
    private static void dfs2(int[] nums, int index, List<Integer> result, List<List<Integer>> results) {
        if (index == nums.length) {
            List<Integer> copy = new ArrayList<>(result);
            results.add(copy);
            return;
        }
        dfs(nums, index + 1, result, results);
        result.add(nums[index]);
        dfs(nums, index + 1, result, results);
        result.remove(result.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        // assuming there are no duplicates in nums.
        List<Integer> partial = new ArrayList<>();
        dfs(nums, 0, partial, results);
        return results;
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

    /**
     * use integer in range [0, 1 << n) to represent 2^n combinations. This is easier than DFS.
     */
    public List<List<Integer>> subsets1(int[] nums) {
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

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        List<Integer> result = new ArrayList<>();
        dfs2(nums, 0, result, results);
        return results;
    }
}
