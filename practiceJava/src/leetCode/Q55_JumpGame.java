package leetCode;

/**
 * Created by shuaipeng on 11/14/16.
 */
public class Q55_JumpGame {

    /**
     * dynamic programming. define furthest[i] as the furthest index that can be reached from index i.
     * then furthest[i] = max{i + nums[i], furthest[i - 1]}
     * in implementation, we don't need an array
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new RuntimeException("invalid input");
        int furthest = nums[0];
        for (int i = 0; i < nums.length && furthest >= i; i++) {
            furthest = Math.max(i + nums[i], furthest);
            if (furthest >= nums.length - 1)// return early if we know the last index is reachable
                return true;
        }
        return false;
    }
}
