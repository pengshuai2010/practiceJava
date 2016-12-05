package leetCode;

/**
 * Created by speng on 12/4/16.
 */
public class Q80_RemoveDuplicatesFromSortedArrayII {
    /**
     * O(n) time, O(1) space
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 3) {
            return nums.length;
        }
        // it's like copying element to another array if occurence < 3, except we are doing it on the same array
        // loop invariant: fast is the frontier the source, the index of the element to be examined; slow is the frontier
        // of the destination, the index where element will be copied to.
        int occurrences = 1;
        int fast = 1, slow = 1;
        for (; fast < nums.length; fast++) {
            if (nums[fast] == nums[fast - 1]) {
                occurrences++;
            } else {
                occurrences = 1;
            }
            if (occurrences < 3) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
