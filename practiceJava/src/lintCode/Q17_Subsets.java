package lintCode;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by speng on 8/24/16.
 */
public class Q17_Subsets {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new Q17_Subsets().subsets(nums));
    }

    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        dfs(0, nums, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int start, int[] nums, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> solutions) {
        solutions.add(new ArrayList<>(path));
        if (start < nums.length) {
            for (int i = start; i < nums.length; i++) {
                path.add(nums[i]);
                dfs(i + 1, nums, path, solutions);
                path.remove(path.size() - 1);
            }
        }
    }
}
