package lintCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by speng on 3/5/17.
 */
public class Q521_RemoveDuplicateNumbersInArray {
    /**
     * O(n) time and O(n) extra memory
     *
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int i = 0;
        for (int num : set) {
            nums[i] = num;
            i++;
        }
        return i;
    }

    /**
     * O(n*log(n)) time and constant memory
     *
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
