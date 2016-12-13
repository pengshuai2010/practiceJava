package leetCode;

import java.util.Arrays;

/**
 * Created by shuaipeng on 12/12/16.
 */
public class Q259_3SumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int numTriples = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] >= target) {
                    k--;
                } else {
                    numTriples += k - j;
                    j++;
                }
            }
        }
        return numTriples;
    }
}
