package leetCode;

/**
 * Created by speng on 12/4/16.
 */
public class Q33_SearchInRotatedSortedArray {
    /**
     * The array is a rotation of a sorted array, so we need twist the binary search a bit.
     * <p>
     * One way is to first find out the smallest element in the array, then the left and right parts are both a usual
     * sorted array, we then do a normal binary search.
     * <p>
     * Since there are no duplicates in the array, a cleverer way is to first decide which part is sorted by comparing
     * nums[low] and nums[mid]; if the left part is sorted, we can decide if target is in the left part by comparing target
     * with the both ends of the left part; if the right part is sorted, we can decide if the target is in the right part
     * by comparing the target and both ends of right part.
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[low] <= nums[mid]) {// left part is sorted
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {// right part is sorted
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
