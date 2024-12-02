package leetCode;

import java.util.HashMap;
import java.util.Map;

public class Q1570_DotProductOfTwoSparseVectors {
    private final Map<Integer, Integer> map;

    Q1570_DotProductOfTwoSparseVectors(int[] nums) {
        this.map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                this.map.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(Q1570_DotProductOfTwoSparseVectors vec) {
        int sum = 0;
        // map.keySet(), map.entrySet() because they are sets.
        // map.values() because there can be duplicates in values, so it's a list
        for (Map.Entry<Integer, Integer> entry : this.map.entrySet()) {
            int index = entry.getKey();
            int value = entry.getValue();
            if (vec.map.containsKey(index)) {
                sum += value * vec.map.get(index);
            }
        }
        return sum;
    }

    // there is a chance to optimize: we can compare the size of the two maps and choose to iterate over the smaller one
    // so that the time complexity is O(min(this map size, other map size))
    public int dotProduct_optimized(Q1570_DotProductOfTwoSparseVectors vec) {
        int sum = 0;
        Map<Integer, Integer> thisMap = this.map;
        Map<Integer, Integer> otherMap = vec.map;
        if (otherMap.size() < this.map.size()) {
            Map<Integer, Integer> tmp = thisMap;
            thisMap = otherMap;
            otherMap = tmp;
        }

        for (Map.Entry<Integer, Integer> entry : thisMap.entrySet()) {
            int index = entry.getKey();
            int value = entry.getValue();
            if (otherMap.containsKey(index)) {
                sum += value * otherMap.get(index);
            }
        }
        return sum;
    }
}
