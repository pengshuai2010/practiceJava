package lintCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by speng on 3/5/17.
 */
public class Q607_TwoSumDataStructureDesign {
    private Map<Integer, Integer> map = new HashMap<>();

    // add takes O(1) time, find() takes O(n) time
    // Add the number to an internal data structure.
    public void add(int number) {
        //map.put(number, map.getOrDefault(number, 0) + 1);
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for (int key : map.keySet()) {
            int other = value - key;
            if (map.containsKey(other)) {
                //other != key || other == key && map.get(key) > 1, the "other == key is redundant"
                if (other != key || map.get(key) > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
