package other;

import java.util.Arrays;

public class DifferenceEqualsToTarget {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 9, 15, 22, 23};
        int target = 8;
        DifferenceEqualsToTarget solution = new DifferenceEqualsToTarget();
        int[] answer = solution.findDifferenceEqualsToTarget(nums, target);
        System.out.println(Arrays.toString(answer));
    }

    public int[] findDifferenceEqualsToTarget(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new RuntimeException("nums is invalid");
        }
        int i = 0;
        int j = 1;
        while (i < j && j < nums.length) {
            int diff = nums[j] - nums[i];
            if (diff < target) {
                j++;
            } else if (diff > target) {
                i++;
            } else {
                return new int[]{nums[i], nums[j]};
            }
        }
        throw new RuntimeException("no solution found");
    }
}
