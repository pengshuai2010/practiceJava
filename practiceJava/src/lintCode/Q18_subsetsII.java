package lintCode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by speng on 8/24/16.
 */
public class Q18_subsetsII {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), subsets);
        return subsets;
    }

    private void dfs(int[] nums, int start, ArrayList<Integer> path,
                     ArrayList<ArrayList<Integer>> solutions) {
        solutions.add(new ArrayList<>(path));
        //no need to write a separate exit condition because when start == nums.length,
        //wont enter for loop
        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i] != nums[i - 1]) {
                path.add(nums[i]);
                dfs(nums, i + 1, path, solutions);
                path.remove(path.size() - 1);
            }
        }
    }
}
