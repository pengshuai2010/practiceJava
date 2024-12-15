package leetCode;

import java.util.HashMap;
import java.util.Map;

public class Q2461_MaximumSumOfDistinctSubarraysWithLengthK {
    // Start with an empty sliding window
    // While right pointer is in boundary
    //     add the element at right point to the sliding window
    //     While invariant of the sliding window is broken, keep moving the left pointer
    //     The invariant can be no duplicates in the sliding window, window size <= k, etc.
    //     If sliding window satisfies all the invariants, do something, e.g. update max window sum if needed
    //     right pointer++
    public long maximumSubarraySum(int[] nums, int k) {
        // could nums be null? be empty?
        // Is it garanteed k <= nums.length?
        // will k be 0?
        // will the sum greater than Integeter range?
        // are the numbers in nums guranteed to be posive?
        long maxSum = 0;
        Map<Integer, Integer> occurance = new HashMap<>();
        long sum = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            sum += nums[right]; // move right pointer by 1 in each iteration
            occurance.put(nums[right], occurance.getOrDefault(nums[right], 0) + 1);
            while (occurance.get(nums[right]) > 1 || right - left + 1 > k) { // maintain the invariant that there are no dulicates
                sum -= nums[left];
                occurance.put(nums[left], occurance.get(nums[left]) - 1); // safe because nums[left] was added previously
                left++;
            }
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, sum);
            }
            right++;
        }
        return maxSum;
    }
}
