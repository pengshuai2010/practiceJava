package other;

import java.util.Arrays;

/*
Given an int array nums and an int target. Find two integers in nums such that the sum is closest to target.
Example 1:
Input: nums = [1, 2, 3, 4, 5], target = 10
Output: [4, 5]
Example 2:

Input: nums= [-1, 2, 1, -4], target = 4
Output: [2, 1]
 */
public class TwoSumClosest {
    public static void main(String[] args) {
        TwoSumClosest twoSumClosest = new TwoSumClosest();
//        int[] nums = new int[] {5, 4, 1, 3, 2};
//        int[] nums = new int[] {8, 7, -1, 0, 4, 4};
        int[] nums = new int[]{-5, 9, 6, 6};
        int target = 10;
        int[] answer = twoSumClosest.twoSumClosest(nums, target);
        System.out.println(Arrays.toString(answer));
    }

    public int[] twoSumClosest(int[] nums, int target) {
        // clarify if nums will be null, if sorted, if length >= 2
        // clarify if return the value or the index
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int minDiff = Integer.MAX_VALUE;
        int[] answer = null;
        while (left < right) {
            int sum = nums[left] + nums[right];
            int diff = Math.abs(sum - target);
            if (diff < minDiff) {
                minDiff = diff;
                answer = new int[]{nums[left], nums[right]};
            }
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return answer;
            }
        }
        return answer;
    }
}

