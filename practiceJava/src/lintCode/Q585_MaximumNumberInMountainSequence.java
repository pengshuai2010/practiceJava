package lintCode;

/**
 * Created by speng on 4/27/17.
 */
public class Q585_MaximumNumberInMountainSequence {
    /**
     * @param nums a mountain sequence which increase firstly and then decrease
     * @return then mountain top
     */
    public int mountainSequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new java.lang.IllegalArgumentException();
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {// the special case of nums.length == 1 or 2 will be handled by the condition of while loop
            int mid = start + (end - start) / 2;
            if (nums[mid - 1] > nums[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return Math.max(nums[start], nums[end]);
    }
}
