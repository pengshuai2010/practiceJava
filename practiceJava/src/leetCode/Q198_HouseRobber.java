package leetCode;

/**
 * Created by speng on 11/23/16.
 */
public class Q198_HouseRobber {
    /**
     * For house i, there are two options: rob or not rob. If we have robbed house (i - 1), we cannot rob
     * house i.
     * Define DP[i][0] as the gain we get so far at house i if we choose not to rob house i
     * DP[i][1] as the gain we get so far at house i if we choose to rob house i
     * Then
     * DP[i][0] = max{DP[i - 1][0], DP[i - 1][1]}
     * DP[i][1] = DP[i - 1][0] + nums[i]
     * initially, DP[0][0] = 0, DP[0][1] = nums[0]
     * <p>
     * When have no idea, we can always first try brute force DFS, then try to get recurrence relation and dynamic programm
     * solution
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int noRobPrev = 0;
        int robPrev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int noRobCurr = Math.max(robPrev, noRobPrev);
            int robCurr = noRobPrev + nums[i];
            noRobPrev = noRobCurr;
            robPrev = robCurr;
        }
        return Math.max(noRobPrev, robPrev);
    }
}
