package leetCode;

import java.util.*;

/**
 * Created by shuaipeng on 11/2/16.
 */
public class Q15_3Sum {
    public static void main(String[] args) {
        System.out.println(new Q15_3Sum().threeSum(new int[]{-2, 1, 1, 1, 1}));
        System.out.println(new Q15_3Sum().threeSum(new int[]{-10, -11, 13, 0, -11, 9, 1, -6, -1, -12, 10, -9, 0, -15, -13, 4, -13, -1, -12, 2, -11, -6, 10, 2, -6, 6, -8, -12, 11, -2, 1, 9, 2, -1, -14, -1, -6, -6, 0, 0, -3, -4, -2, 4, -12, -8, -7, -10, 6, -11, -1, 2, -2, -14, -10, 7, 7, -3, 10, -4, 3, -11, -10, 12, 3, 13, -4, 4, -8, 4, -11, -4, -15, -6, -15, -12, 1, -15, -15, 14, -11, -8, 2, -6, -7, -1, -14, -14, 11, 4, -3, -1, 8, -6, -3, -12, -8, 0, 8, -1, 11, 4, 2, 11, 14, 2, 6, -8, -6, -1, -8, -1, 6}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>(); // or throw an exception?
        }
        List<List<Integer>> solutions = new ArrayList<>();
        Arrays.sort(nums); // ask can we change the input?
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { // we need check duplicate for all of i, j and k.
                continue;
            }
            // reuse the solution for two sum in a sorted array problem
            // make code more modular
            twoSumInSortedArray(nums, i + 1, nums.length - 1, -nums[i], solutions);
        }
        return solutions;
    }

    // two pointers technique
    private void twoSumInSortedArray(int[] nums, int start, int end, int target, List<List<Integer>> solutions) {
        int j = start;
        int k = end;
        while (j < k) {
            int sum = nums[j] + nums[k];
            if (sum < target) {
                j++;
            } else if (sum > target) {
                k--;
            } else {
                solutions.add(Arrays.asList(-target, nums[j], nums[k]));
                j++;
                k--;
                // j must += 1 first, then skip duplicates by:
                // while nums[j] is same value as nums[j - 1], keep moving
                while (j < k && nums[j] == nums[j - 1]) {
                    j++;
                }
                while (j < k && nums[k] == nums[k + 1]) {
                    k--;
                }
            }
        }
    }

    private void twoSumInSortedArray_HashSet(int[] nums, int start, int target, List<List<Integer>> solutions) {
        int index = start;
        Set<Integer> set = new HashSet<>();
        while (index < nums.length) {
            int complement = target - nums[index];
            if (set.contains(complement)) {
                solutions.add(Arrays.asList(-target, nums[index], complement));
                // skipping duplicate is tricky!
                while (index < nums.length - 1 && nums[index] == nums[index + 1]) { // note the boundary here.
                    index++;
                }
            }
            set.add(nums[index]);
            // dedupe in case of target == 6 and nums is [3, 3, 3, 3]
            index++;
        }
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>(); // or throw an exception?
        }
        // Skipping duplicates is tricky!  It's much easier to just use a set.
        Set<List<Integer>> solutions = new HashSet<>();
        Arrays.sort(nums); // ask can we change the input?
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    solutions.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
            }
        }
        return new ArrayList<>(solutions);
    }
}
