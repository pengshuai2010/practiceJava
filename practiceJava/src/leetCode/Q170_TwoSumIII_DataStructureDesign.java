package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by speng on 1/4/17.
 */
public class Q170_TwoSumIII_DataStructureDesign {
    /**
     * Use a LinkedHashMap. Add() takes O(1) time, and find() takes O(n) time.
     */
    public class TwoSum {
        private final Map<Integer, Integer> map = new HashMap<>();

        // Add the number to an internal data structure.
        public void add(int number) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        // Find if there exists any pair of numbers which sum is equal to the value.
        public boolean find(int sum) {
            for (int key : map.keySet()) {
                int target = sum - key;
                if (map.containsKey(target)) {
                    if (key != target || map.get(target) > 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /**
     * Use two Sets. Add() takes O(m) time, where m is number of unique added numbers. Find() takes O(1) time because
     * we have all two sums in the hash set. The memory complexity is O(m^2)
     */
    public class TwoSum1 {
        private final Set<Integer> numbers = new HashSet<>();
        private final Set<Integer> twoSums = new HashSet<>();

        // Add the number to an internal data structure.
        public void add(int number) {
            //we use a hash set instead of list to store numbers, so reduce time complexity from O(n) to O(m), where n is
            //total added numbers, m is unique added numbers
            if (numbers.contains(number)) {
                //a clever optimization. When a number already exists, there's no need to iterate through the numbers set
                //again, just add (number + number) to twoSums set.
                twoSums.add(number * 2);
                return;
            }
            for (int val : numbers) {
                twoSums.add(val + number);
            }
            numbers.add(number);
        }

        // Find if there exists any pair of numbers which sum is equal to the value.
        public boolean find(int sum) {
            return twoSums.contains(sum);
        }
    }
}
