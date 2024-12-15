package leetCode;

import java.util.HashMap;
import java.util.Map;

public class Q1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // clarify if nums will be null, or empty, if a solution is guranteed to exist
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        throw new RuntimeException("no solution");
    }
}