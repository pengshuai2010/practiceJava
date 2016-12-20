package leetCode;

/**
 * Created by shuaipeng on 12/20/16.
 */
public class Q376_WiggleSubsequence {
    /**
     * first get differences. For example, from [1, 2, 7, 4, 1,9,9, 2,5] we get [+, +, -, -, +, 0, -, +]. Count the number of sign changes.
     * In this example there are 4 sign changes, so return 4 + 2 = 6. The tricky part is to consider corner cases like
     * [1, 1], where differences are all 0's, we should return 1. And for [1, 2] we should return 2;
     * <p>
     * Another way: find two sequences, one starts going up, the other starts going down. from [1, 2, 7, 4, 1,9,9, 2,5] we get
     * [1, 2, 1, 9, 2, 5] and [1]. return the length of the longer one.
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        int signChanges = 0;
        int prev = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int curr = nums[i + 1] - nums[i];
            if (prev < 0 && curr > 0 || prev > 0 && curr < 0) {//better than prev * curr < 0, because it may overflow
                signChanges++;
                prev = curr;
            } else if (prev * curr == 0) {
                prev = prev == 0 ? curr : prev;
            }
        }
        return prev == 0 ? signChanges + 1 : signChanges + 2;//handle the case where differences are all zeros, e.g. [1, 1]
    }


}
