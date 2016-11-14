package leetCode;

/**
 * Created by speng on 11/13/16.
 */
public class Q53_MaximumSubarray {
    /**
     * a clear explanation https://discuss.leetcode.com/topic/5000/accepted-o-n-solution-in-java
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("invalide input" + nums);
        }
        // when we have known the max sum of subarrays in nums[0, ..., i - 1], and try to get max sum of subarrays in nums[0, ..., i]
        // it is either the max sum of subarrays in nums[0, ..., i - 1], or the max sum of subarrays that ends with nums[i]

        // and the max sum of subarrays that ends with nums[i] is either the max sum of subarrays that ends with nums[i - 1] plus nums[i],
        // or nums[i]

        // note that the problem requires that subarray contains at least one number
        int maxEndingHere = nums[0];// max of subarrays ending here
        int maxSoFar = nums[0];// max of subarrays so far
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);// whether to begin the subarray anew here
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
