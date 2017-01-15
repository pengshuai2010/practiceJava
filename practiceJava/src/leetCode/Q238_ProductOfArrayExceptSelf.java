package leetCode;

/**
 * Created by speng on 1/14/17.
 */
public class Q238_ProductOfArrayExceptSelf {
    /**
     * To calculate output[i], we need the cumulative product of all elements to its left, and the cumulative product of
     * all elements to its right, so use prefix product and suffix product.
     * prefixProduct[0] = 1, and prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1]
     * suffixProduct[n - 1] = 1, and suffixProduct[i] = suffixProduct[i + 1] * nums[i + 1]
     * output[i] = prefixProduct[i] * suffixProduct[i]
     * <p>
     * Further more, we can save some space by calculating prefixProduct while moving right and store output[i] in
     * suffixProduct[i]
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null) {
            return null;
        }
        if (nums.length == 0) {
            return new int[0];
        }
        int[] suffixProduct = new int[nums.length];
        suffixProduct[nums.length - 1] = 1;//always beware of IndexOutOfBoundException!
        for (int i = nums.length - 2; i >= 0; i--) {
            suffixProduct[i] = suffixProduct[i + 1] * nums[i + 1];
        }
        int prefixProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            suffixProduct[i] = suffixProduct[i] * prefixProduct;
            prefixProduct *= nums[i];
        }
        return suffixProduct;
    }
}
