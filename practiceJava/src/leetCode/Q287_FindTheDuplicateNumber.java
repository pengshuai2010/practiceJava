package leetCode;

import java.util.Arrays;

/**
 * Created by speng on 12/31/16.
 */
public class Q287_FindTheDuplicateNumber {
    /**
     * O(n*log(n)) time. Doesn't make use of the fact that all numbers in within range [1, n]
     */
    public int findDuplicate1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * Array representation of linked list.
     * Array length is n + 1, and all element are in the range [1, n], this means we can treat the int array as an linked
     * list. Duplicate numbers in the array means in the linked list there are two nodes whose next points to the same node,
     * i.e. there is a cycle in the linked list. Finding the duplicate is equivalent to finding the beginning of the cycle.
     */
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int slow = 0, fast = 0;
        for (int i = 1; ; i++) {
            fast = nums[fast];
            if (i % 2 == 0) {
                slow = nums[slow];
                if (slow == fast) {
                    break;
                }
            }
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
