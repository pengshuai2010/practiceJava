package leetCode;

/**
 * Created by speng on 12/13/16.
 */
public class Q330_PatchingArray {
    /**
     * initially, the consecutive interval that is covered starting from 0 is [0, 1), where 1 is boundary that is not covered.
     * when we have [1], the consecutive covered interval is [0, 1) union [0 + 1, 1 + 1), i.e. [0, 2), boundary is 2
     * when we have [1, 2], the consecutive covered interval is [0, 2) union [0 + 2, 2 + 2), i.e. [0, 4), boundary is 4
     * when we have [1, 2, 3], the consecutive covered interval is [0, 4) union [0 + 3, 4 + 3), i.e. [0, 7), boundary is 7
     * note that this time there's an overlap between the two intervals.
     * when we have [1, 2, 3, 9], there is a gap between [0, 7) and [9, 16). So the boundary of the consecutive convered interval
     * starting from 0 is still 7. We can choose a number <= 7 to push the boundary beyond 7. The boundary
     * is pushed furthest if we choose 7 as the patch -- this is where greedy comes in.
     * see https://discuss.leetcode.com/topic/35709/share-my-thinking-process for a clear explanation
     */
    public int minPatches(int[] nums, int n) {
        //corner case: nums = [], n = 7
        if (nums == null || n < 1) {
            return 0;
        }
        //corner case: nums = [], n = Integer.MAX_VALUE
        long boundary = 1;
        int i = 0;
        int numPatches = 0;
        //loop invariant: [0, boundary) is covered
        while (boundary <= n) {
            if (i < nums.length && nums[i] <= boundary) {
                boundary += nums[i];
                i++;
            } else {
                boundary += boundary;
                numPatches++;
            }
        }
        return numPatches;
    }
}
