package leetCode;

/**
 * Created by speng on 9/7/16.
 */
public class Q11containerWithMostWater {
    public static void main(String[] args) {
        System.out.println(new Q11containerWithMostWater().maxArea(null));
        System.out.println(new Q11containerWithMostWater().maxArea(new int[]{}));
        System.out.println(new Q11containerWithMostWater().maxArea(new int[]{1}));
        System.out.println(new Q11containerWithMostWater().maxArea(new int[]{1, 4, 4, 1}));
        System.out.println(new Q11containerWithMostWater().maxArea(new int[]{4, 4, 1}));
        System.out.println(new Q11containerWithMostWater().maxArea(new int[]{4, 4, 1, 4}));
    }

    // an intuitive explanation: if height[left] < height[right], and we move right, the result is definitely worse than
    // current result.
    public int maxArea(int[] height) {
        if (height == null || height.length < 2)
            return 0;
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return max;
    }
}
