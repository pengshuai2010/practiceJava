package leetCode;

/**
 * Created by shuaipeng on 11/10/16.
 */
public class Q31_NextPermutation {
    private static void reverse(int[] nums, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * a good explanation https://leetcode.com/articles/next-permutation/
     */
    public void nextPermutation(int[] nums) {
        // will nums be null or empty?
        if (nums.length <= 1) {
            return;
        }
        // start from the end, find the start of a descending sequence
        int p = nums.length - 1;
        while (p - 1 >= 0 && nums[p - 1] >= nums[p]) {
            p--;
        }
        if (p > 0) {
            // start from the end, find the first number that is greater than nums[p - 1]
            int q = nums.length - 1;
            while (nums[q] <= nums[p - 1]) {
                q--;
            }
            swap(nums, p - 1, q);
        }
        reverse(nums, p, nums.length - 1); // numbers from index p to nums.length is in descending order, so need to reverse
    }
}
