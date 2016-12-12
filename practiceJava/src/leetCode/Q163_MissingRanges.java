package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by speng on 12/11/16.
 */
public class Q163_MissingRanges {
    /**
     * ask interviewer if we can assume the numbers are within [low, high]. If not, there are a LOT of corner cases
     * to consider.
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<>();
        if (lower > upper) {
            return list;
        }
        //[], 1, 1
        if (nums == null || nums.length == 0 || upper < nums[0] || lower > nums[nums.length - 1]) {
            list.add(intervalToString(lower, upper));
            return list;
        }// gurantees low <= nums[nums.length - 1] && high >= nums[0]
        int p = Arrays.binarySearch(nums, lower);
        if (p < 0) {
            p = -(p + 1);
        }// garantees nums[p] >= low
        if (lower < nums[p]) {
            list.add(intervalToString(lower, Math.min(nums[p] - 1, upper)));// [1, 10], low = 2, high = 8
        }
        for (; p < nums.length - 1 && nums[p + 1] <= upper; p++) {
            if (nums[p] + 1 < nums[p + 1]) {
                list.add(intervalToString(nums[p] + 1, nums[p + 1] - 1));
            }
        }
        if (nums[p] < upper) {
            list.add(intervalToString(nums[p] + 1, upper));
        }
        return list;
    }

    private String intervalToString(int b, int e) {
        if (b == e) {
            return Integer.toString(b);
        }
        if (b < e) {
            return b + "->" + e;
        }
        return "";
    }
}
