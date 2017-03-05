package lintCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by speng on 3/5/17.
 */
public class Q587_TwoSum_UniquePairs {
    /**
     * @param nums   an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum6(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int numPairs = 0;
        for (int key : map.keySet()) {
            if (key > target / 2) {
                continue;//not break, because keys are not ordered
            }
            int other = target - key;
            if (map.containsKey(other)) {
                if (key != other || map.get(other) > 1) {
                    numPairs++;
                }
            }
        }
        return numPairs;
    }
}
