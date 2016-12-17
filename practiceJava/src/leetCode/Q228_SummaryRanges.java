package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by speng on 12/17/16.
 */
public class Q228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 != nums[i]) {
                list.add(BuildRangeString(nums[start], nums[i - 1]));
                start = i;
            }
        }
        list.add(BuildRangeString(nums[start], nums[nums.length - 1]));
        return list;
    }

    private String BuildRangeString(int start, int end) {
        if (start == end) {
            return Integer.toString(start);
        }
        return start + "->" + end;
    }
}
