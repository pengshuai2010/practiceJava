package leetCode;

/**
 * Created by shuaipeng on 12/29/16.
 */
public class Q42_TrappingRainWater {
    /**
     * To trap water, there must be a "V" shape. So we calculate the max height so far from left to right, and the max
     * height so far from right to left. Then at index i, the amount of water can be trapped is
     * min(leftMax[i], rightMax[i]) - height[i]
     * <p>
     * Takes O(n) time and O(n) space.
     */
    public int trap1(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return water;
    }

    /**
     * Two pointer technique. One pointer l starts from left-most element and keep updating leftMax so far; the other pointer
     * r starts from right-most element and keeps updating rightMax so far. If leftMax < rightMax, we know
     * the water height at l is at least leftMax, because there's a higher bar to its right; and we know the water height
     * at l is at most leftMax, because the highest bar to its left is leftMax. So the water height at position l is
     * exactly leftMax. And of course we need to subtract height[l] from leftMax to get the actual amount of water trapped here.
     */
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int water = 0;
        int l = 0;
        int r = height.length - 1;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        while (l < r) {
            if (leftMax < rightMax) {
                water += leftMax - height[l];
                l++;
                leftMax = Math.max(leftMax, height[l]);
            } else {
                water += rightMax - height[r];
                r--;
                rightMax = Math.max(rightMax, height[r]);
            }
        }
        return water;
    }
}
