package lintCode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by speng on 8/24/16.
 */
public class Q17 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new Q17().subsets(nums));
    }

    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<Integer>());
        if (nums == null || nums.length == 0)
            return subsets;
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), subsets);
        return subsets;
    }

    private void dfs(int[] nums, int index, List<Integer> subset, List<ArrayList<Integer>> subsets) {
        if (index >= nums.length)
            return;
        for (int i = index; i < nums.length; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.addAll(subset);
            tmp.add(nums[i]);
            subsets.add(tmp);
            dfs(nums, i + 1, tmp, subsets);
        }
    }
}
