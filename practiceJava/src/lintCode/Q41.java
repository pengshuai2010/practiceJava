package lintCode;

/**
 * Created by speng on 8/27/16.
 */
public class Q41 {
    public static void main(String[] args) {
        System.out.println(new Q41().maxSubArray(new int[]{-2, 2, -3, 4, -1, 2, 1, -5, 3}));
        System.out.println(new Q41().maxSubArray(new int[]{-2}));
    }

    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        // In an interview, need to confirm with the interviewer if zero-length subarray is allowed

        // dynamic programming
        // maxSoFar(n) = max{maxSoFar(n - 1) + nums[n], nums[n]}
        int endingMax = nums[0];
        int maxSofar = nums[0];
        // bottom-up solution, use constant space
        for (int i = 1; i < nums.length; i++) {
            endingMax = Math.max(endingMax + nums[i], nums[i]);
            maxSofar = Math.max(endingMax, maxSofar);
        }
        return maxSofar;
    }
}
