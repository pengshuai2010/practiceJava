package leetCode;

/**
 * Created by speng on 12/31/16.
 */
public class Q189_RotateArray {
    /**
     * O(n) time, O(n) space
     */
    public void rotate1(int[] nums, int k) {
        //ask interview if k is guaranteed to be non-negative
        if (nums == null || nums.length < 2 || k < 1 || k % nums.length == 0) {
            return;
        }
        int n = nums.length;
        k %= n;
        int[] tmp = new int[n - k];
        System.arraycopy(nums, 0, tmp, 0, n - k);
        System.arraycopy(nums, n - k, nums, 0, k);
        System.arraycopy(tmp, 0, nums, k, n - k);
    }

    /**
     * O(n) time, O(1) space. Frist reverse the whole array, so the elements are in the right inverval. Then reverse the two intervals,
     * so the array looks as if right shifted.
     */
    public void rotate(int[] nums, int k) {
        //ask interview if k is guaranteed to be non-negative
        if (nums == null || nums.length < 2 || k < 1 || k % nums.length == 0) {
            return;
        }
        int n = nums.length;
        k %= n;
        arrayReverse(nums, 0, nums.length);
        arrayReverse(nums, 0, k);
        arrayReverse(nums, k, n - k);
    }

    private void arrayReverse(int[] nums, int start, int length) {
        for (int i = start, j = start + length - 1; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
