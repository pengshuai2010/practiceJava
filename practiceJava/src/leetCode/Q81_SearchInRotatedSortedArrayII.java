package leetCode;

/**
 * Created by speng on 12/4/16.
 */
public class Q81_SearchInRotatedSortedArrayII {
    /**
     * When duplicates are allowed, and nums[low] == nums[mid] == nums[high], we cannot decide which part is sorted.
     * e.g. [5, 5, 5, 0, 5] and [5, 0, 5, 5, 5]. In the worst cast, where all numbers are the same, it would inevitably
     * take O(n) time.
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        return searchRecursive(nums, 0, nums.length - 1, target);
    }

    /**
     * When cannot decide, we can do a recursive binary search on both parts.
     * Or compare target with nums[high], and decrese high if not equal. Hopefully this can break the
     * nums[low] == nums[mid] == nums[high].
     */
    private boolean searchRecursive(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[low] < nums[mid] || low == mid) {//left part is sorted
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] < nums[high] || mid == high) {//right part is sorted
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {//cannot decide
                if (searchRecursive(nums, low, mid - 1, target)) {
                    return true;
                }
                if (searchRecursive(nums, mid + 1, high, target)) {
                    return true;
                }
                break;
            }
        }
        return false;
    }
}
