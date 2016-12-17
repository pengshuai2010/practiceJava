package leetCode;

/**
 * Created by speng on 12/16/16.
 */
public class Q370_RangeAddition {
    /**
     * brute force approach. takes O(kn) time, where k is number of updates.
     */
    public int[] getModifiedArray1(int length, int[][] updates) {
        if (length <= 0 || updates == null) {
            return new int[]{};
        }
        int[] nums = new int[length];
        for (int[] update : updates) {
            int start = update[0], end = update[1], inc = update[2];
            for (int i = start; i >= 0 && i <= end && i < length; i++) {
                nums[i] += inc;
            }
        }
        return nums;
    }

    /**
     * Actually we don't need to update each element between i and j in each update. A first thought was to have a hashmap,
     * where use index as key, +/- inc as value, e.g. (i, inc) and (j + 1, -inc). Then we will find that we don't even need
     * the hashmap, the array itself can serve as the hashmap. For each update, let nums[i] += inc and nums[j + 1] -= inc
     * if (j - 1) < length. At last calculate cumulative sum.
     *
     * An extension to this problem is that the original array's elements are not all the same. One solution is to store the
     * original array separately, which takes O(n) extra space. Another solution is to do a reverse partial sum operation
     * on the original array, e.g. [2, 3, 10, 5] -> [2, 1, 7, -5]
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        if (length <= 0 || updates == null) {
            return new int[]{};
        }
        int[] nums = new int[length];
        for (int[] update : updates) {
            int start = update[0], end = update[1] + 1, inc = update[2];
            nums[start] += inc;
            if (end < length) {
                nums[end] -= inc;
            }
        }
        for (int i = 1; i < length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
