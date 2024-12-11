package leetCode;

public class Q1004_MaxConsecutiveOnesIII {
    // sliding window
    // In the sliding window, there can be any number of 1's and at most k 0's, so the sliding window
    // is guranteed to contain consecutive 1's if the zero's were to be flipped
    // In each iteration, move the right pointer and see if the new element is 0. If the new element
    // is 0, increase the numZeros count. While the numZeros count is greater than k, keep moving
    // the left pointer. Then calculate the current window size and update max window size if necessary.
    public int longestOnes(int[] nums, int k) {
        // will nums be null? k < 0?
        if (nums.length <= k) {
            return nums.length;
        }
        // is it guranteed that only 1's and 0's?
        // assuming k >= 0, k < nums
        int left = 0;
        int right = 0; // inclusive
        int maxWindowSize = 0;
        int numZeros = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                numZeros++;
            }
            while (numZeros > k) {
                if (nums[left] == 0) {
                    numZeros--;
                }
                left++;
            }
            int windowSize = right - left + 1;
            maxWindowSize = Math.max(maxWindowSize, windowSize);
            right++;
        }
        return maxWindowSize;
    }
}
