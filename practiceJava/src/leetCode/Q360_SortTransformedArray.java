package leetCode;

/**
 * Created by shuaipeng on 1/9/17.
 */
public class Q360_SortTransformedArray {
    /**
     * After mapping x to function value, the values are like two sorted array concatenated. So we can merge the two
     * sorted parts into one sorted array. When a > 0, it's one descending arry concatenated with one ascending array.
     * When a < 0, it's one ascending array concatenated with one descending array. Note this hold even if axis is outside
     * of input array, or a == 0: it's just one of the two arrays is empty.
     */
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null) {
            throw new java.lang.IllegalArgumentException();
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a * nums[i] * nums[i] + b * nums[i] + c;
        }
        if (a >= 0) {
            int index = nums.length - 1, i = 0, j = nums.length - 1;
            while (i <= j) {
                res[index--] = nums[i] > nums[j] ? nums[i++] : nums[j--];
            }
        } else {
            int index = 0, i = 0, j = nums.length - 1;
            while (i <= j) {
                res[index++] = nums[i] < nums[j] ? nums[i++] : nums[j--];
            }
        }
        return res;
    }
}
