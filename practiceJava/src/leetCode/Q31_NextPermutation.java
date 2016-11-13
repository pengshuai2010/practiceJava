package leetCode;

/**
 * Created by shuaipeng on 11/10/16.
 */
public class Q31_NextPermutation {
    /**
     * a good explanation https://leetcode.com/articles/next-permutation/
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2)
            return;
        int i;
        for (i = nums.length - 1; i > 0; i--)
            if (nums[i - 1] < nums[i])
                break;
        if (i > 0) {
            int j;//starting from last element, find a nums[j] that nums[j] > nums[i - 1]
            for (j = nums.length - 1; j > i; j--)
                if (nums[j] > nums[i - 1])
                    break;
            swap(nums, i - 1, j);
        }
        // element starting from nums[i] are in descending order
        for (int m = i, n = nums.length - 1; m < n; m++, n--)
            swap(nums, m, n);
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
