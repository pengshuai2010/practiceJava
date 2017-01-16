package lintCode;

/**
 * Created by speng on 1/16/17.
 */
public class Q458_LastPositionOfTarget {
    /**
     * @param nums:   An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int lastPosition(int[] nums, int target) {
        //if problem description says ascending order, ask if ascending
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        //the benefit of using while(low + 1 < high) is that we don't worry about deadlock.
        //This can save time in an interview.
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        if (nums[high] == target) {
            return high;
        }
        if (nums[low] == target) {
            return low;
        }
        return -1;
    }
}
