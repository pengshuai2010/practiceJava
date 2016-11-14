package leetCode;

/**
 * Created by speng on 11/12/16.
 */
public class Q34_SearchforaRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};
        int s = 0;
        int e = nums.length - 1;
        // look for left boundary
        // left boundary is the left most element that equals to target
        while (s < e) {
            // since s and e are positive
            // (s + e)/2 can cause int overflow
            int m = s + (e - s) / 2;
            if (nums[m] < target)//left boundary must be greater than m
                s = m + 1;
            else if (nums[m] > target)// left boundary must be smaller than m
                e = m - 1;
            else
                e = m;// left boundary is smaller than or equal to m
            // we don't need to worry about infinite loop because when the range is down to two elements,
            // m will be index of first element
        }
        if (nums[s] != target)
            return new int[]{-1, -1};
        int leftBound = s;
        // we keep s to make use of left bound
        e = nums.length - 1;
        while (s < e) {
            // add 1 to avoid infinite loop
            int m = s + (e - s) / 2 + 1;
            if (nums[m] < target)
                s = m + 1;
            else if (nums[m] > target)
                e = m - 1;
            else
                s = m;
        }
        int rightBound = s;
        return new int[]{leftBound, rightBound};
    }
    // tests
    // [], 2
    // [1], 2
    // [2], 2
    // [1, 1, 1, 2, 2, 3], 2
    // [1, 3], 2
    // [2, 2, 3], 2
    // [1, 1, 2], 2
}
