package lintCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuaipeng on 8/25/16.
 */
public class Q16_PermutationsII_visitedArray {

    private static void dfs(int[] nums, int index, boolean[] visited,
                            List<Integer> partial, List<List<Integer>> solutions) {
        if (index == nums.length) {
            solutions.add(new ArrayList<>(partial));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            // the previous one is not visited in last level of recursion, and
            // the previous is same as current
            // this works because in consecutive duplicates, e.g. [1`, 1``, 1```],
            // it will never happen that 1`` is visited but 1` is not visted.
            if (i > 0 && !visited[i - 1] && nums[i - 1] == nums[i]) {
                continue;
            }
            partial.add(nums[i]);
            visited[i] = true;
            dfs(nums, index + 1, visited, partial, solutions);
            partial.remove(partial.size() - 1);
            visited[i] = false;
        }
    }

    /**
     * @param nums: A list of integers
     * @return: A list of unique permutations
     * we will sort your return value in output
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // clarifying questions: duplicates in nums?
        // is nums sorted?
        List<List<Integer>> solutions = new ArrayList<>();
        if (nums == null) {
            return solutions;
        }
        Arrays.sort(nums); // sort it!!!
        boolean[] visited = new boolean[nums.length];
        List<Integer> partial = new ArrayList<>();
        dfs(nums, 0, visited, partial, solutions);
        return solutions;
    }
}
