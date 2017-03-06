package lintCode;

import java.util.Arrays;

/**
 * Created by speng on 3/5/17.
 */
public class Q533_TwoSum_ClosestToTarget {
    /**
     * @param nums   an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new java.lang.IllegalArgumentException();
        }
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            int diff = Math.abs(sum - target);
            minDiff = Math.min(minDiff, diff);
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return 0;
            }
        }
        return minDiff;
    }
}
