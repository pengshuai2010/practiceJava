package leetCode;

import java.util.Arrays;

/**
 * Created by shuaipeng on 11/30/16.
 */
public class Q75_SortColors {
    /**
     * straight forward bucket sort where range of each bucket is 1
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }
        int index = 0;
        Arrays.fill(nums, 0, count[0], 0);
        Arrays.fill(nums, count[0], count[0] + count[1], 1);
        Arrays.fill(nums, count[0] + count[1], nums.length, 2);
    }
}
