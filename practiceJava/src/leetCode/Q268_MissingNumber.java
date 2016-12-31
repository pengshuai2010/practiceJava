package leetCode;

import java.util.Arrays;

/**
 * Created by speng on 12/31/16.
 */
public class Q268_MissingNumber {
    /**
     * ((0 + n) * n / 2 - sum) is the missing number
     */
    public int missingNumber1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        long sum = 0;//when there are many add and multiply, always beware of overflow!
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int n = nums.length;
        long totalSum = n * (n + 1) / 2;
        return (int) (totalSum - sum);
    }

    /**
     * use the property of xor. a^0 = a and a^b^b = a
     */
    public int missingNumber2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }
        res ^= nums.length;
        return res;
    }

    /**
     * If the input array is already sorted, this will be the best method.
     * O(log(n)) if input array is already sorted.
     * In any problem that can tell us our guess is higher or lower, binary search can be used.
     */
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n - 1] == n - 1) {//make sure there's at least one index such that nums[index] > index in the binary search
            return n;
        }
        int low = 0, high = nums.length - 1;
        //find the first index such that nums[index] > index
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
