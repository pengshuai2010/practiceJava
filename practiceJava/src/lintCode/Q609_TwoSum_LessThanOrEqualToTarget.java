package lintCode;

import java.util.Arrays;

/**
 * Created by speng on 3/5/17.
 */
public class Q609_TwoSum_LessThanOrEqualToTarget {
    /**
     * @param nums   an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum5(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int numPairs = 0;
        while (i < j) {
            if (nums[i] + nums[j] <= target) {
                numPairs += j - i;
                i++;
            } else {
                j--;
            }
        }
        return numPairs;
    }
}
