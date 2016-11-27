package leetCode;

/**
 * Created by speng on 11/26/16.
 */
public class Q213_HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length <= 3) {
            int largest = nums[0];
            for (int i = 1; i < nums.length; i++)
                largest = Math.max(largest, nums[i]);
            return largest;
        }
        // divide into two categories according to if rob nums[0] or not
        return Math.max(nums[0] + rob(nums, 2, nums.length - 1), rob(nums, 1, nums.length));
    }

    /**
     * rob the house in range [s, e) as in Rob House I
     *
     * @param nums
     * @param s    inclusive start
     * @param e    exlusive end
     * @return
     */
    private int rob(int[] nums, int s, int e) {
        int rob = 0;
        int noRob = 0;
        for (int i = s; i < e; i++) {
            int robNext = noRob + nums[i];
            int noRobNext = Math.max(rob, noRob);
            rob = robNext;
            noRob = noRobNext;
        }
        return Math.max(rob, noRob);
    }
}
