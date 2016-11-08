package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuaipeng on 11/2/16.
 */
public class Q15_3Sum {
    public static void main(String[] args) {
        System.out.println(new Q15_3Sum().threeSum(new int[]{-2, 1, 1, 1, 1}));
        System.out.println(new Q15_3Sum().threeSum(new int[]{-10, -11, 13, 0, -11, 9, 1, -6, -1, -12, 10, -9, 0, -15, -13, 4, -13, -1, -12, 2, -11, -6, 10, 2, -6, 6, -8, -12, 11, -2, 1, 9, 2, -1, -14, -1, -6, -6, 0, 0, -3, -4, -2, 4, -12, -8, -7, -10, 6, -11, -1, 2, -2, -14, -10, 7, 7, -3, 10, -4, 3, -11, -10, 12, 3, 13, -4, 4, -8, 4, -11, -4, -15, -6, -15, -12, 1, -15, -15, 14, -11, -8, 2, -6, -7, -1, -14, -14, 11, 4, -3, -1, 8, -6, -3, -12, -8, 0, 8, -1, 11, 4, 2, 11, 14, 2, 6, -8, -6, -1, -8, -1, 6}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> solutions = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return solutions;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;// skip duplicates e.g. [-2, -2, -2, 0, 2]
            if (nums[i] > 0)
                break;
            int target = -nums[i];
            int p1 = i + 1;
            int p2 = nums.length - 1;
            while (p1 < p2) {
                int sum = nums[p1] + nums[p2];
                if (sum == target) {
                    solutions.add(Arrays.asList(nums[i], nums[p1], nums[p2]));
                    do {
                        p1++;// skip duplicates e.g. [-2, 1, 1, 1, 1, 1]
                    } while (p1 < p2 && nums[p1] == nums[p1 - 1]);// the condition "p1 < p2" maintains loop invariant
                    do {
                        p2--;// skip duplicates e.g. [-2, 1, 1, 1, 1, 1]
                    } while (p1 < p2 && nums[p2] == nums[p2 + 1]);
                } else if (sum < target) {
                    do {
                        p1++;
                    } while (p1 < p2 && nums[p1] == nums[p1 - 1]);// optional, skip duplicates
                } else {
                    do {
                        p2--;
                    } while (p1 < p2 && nums[p2] == nums[p2 + 1]);// optional, skip duplicates
                }
            }
        }
        return solutions;
    }
}
