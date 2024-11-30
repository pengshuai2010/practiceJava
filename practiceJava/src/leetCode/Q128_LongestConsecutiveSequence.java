package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        // clarify what to do if nums is null?
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLength = 0;
        for (int num : set) { // iterator over set instead of nums helps skips duplicates efficiently
            if (!set.contains(num - 1)) {
                int length = 1;
                int neighbor = num + 1;
                while (set.contains(neighbor)) {
                    length++;
                    neighbor++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }

    public int longestConsecutive2(int[] nums) {
        // clarify what to do if nums is null?
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Boolean> visited = new HashMap<>();
        for (int num : nums) {
            visited.put(num, false);
        }
        int maxConsecutiveLength = 0;
        for (int num : nums) {
            if (!visited.get(num)) {
                visited.put(num, true);
                int length = 1;
                int neighbor = num + 1;
                while (visited.containsKey(neighbor) && !visited.get(neighbor)) {
                    visited.put(neighbor, true);
                    length++;
                    neighbor++;
                }
                neighbor = num - 1;
                while (visited.containsKey(neighbor) && !visited.get(neighbor)) {
                    visited.put(neighbor, true);
                    length++;
                    neighbor--;
                }
                maxConsecutiveLength = Math.max(maxConsecutiveLength, length);
            }
        }
        return maxConsecutiveLength;
    }
}
