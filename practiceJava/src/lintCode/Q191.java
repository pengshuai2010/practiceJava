package lintCode;

/**
 * Created by speng on 8/27/16.
 */
public class Q191 {
    public static void main(String[] args) {
        System.out.println(new Q191().maxProduct(new int[]{-4, -3, -2}));
        System.out.println(new Q191().maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(new Q191().maxProduct(new int[]{-2}));
        System.out.println(new Q191().maxProduct(new int[]{1, -2, 1, -4}));
    }

    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int endingMax = nums[0];
        int maxSofar = nums[0];
        int endingMin = nums[0];
        int minSofar = nums[0];
        // maxProduct may come from min*num[i] if min and num[i] are both negative, so
        // endingMax = max{endingMax*nums[i], endingMin*nums[i], nums[i]}
        for (int i = 1; i < nums.length; i++) {
            // we use endngMaxTmp = preserve the value of endingMax because it will be changed and we need it to calculate
            // endingMin
            int endingMaxTmp = endingMax;
            endingMax = Math.max(endingMax * nums[i], Math.max(nums[i], endingMin * nums[i]));
            maxSofar = Math.max(maxSofar, endingMax);
            endingMin = Math.min(endingMin * nums[i], Math.min(nums[i], endingMaxTmp * nums[i]));
            minSofar = Math.min(minSofar, endingMin);
        }
        return maxSofar;
    }
}
