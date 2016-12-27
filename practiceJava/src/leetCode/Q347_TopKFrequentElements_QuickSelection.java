package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by speng on 12/26/16.
 */
public class Q347_TopKFrequentElements_QuickSelection {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0 || k < 1) {
            return list;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>();
        entries.addAll(map.entrySet());
        quickSelection(entries, k);
        for (int i = 0; i < k; i++) {
            list.add(entries.get(i).getKey());
        }
        return list;
    }

    /**
     * Quick Selection take O(n) time on average, O(n^2) time in worst case when elements are already sorted.
     */
    private void quickSelection(List<Map.Entry<Integer, Integer>> entries, int k) {
        k--;
        int i = 0, j = entries.size() - 1;
        while (i < j) {
            int index = partition(entries, i, j);
            if (index > k) {
                j = index - 1;
            } else if (index < k) {
                i = index + 1;
            } else {
                break;
            }
        }
    }

    /**
     * we can reduce the probability of worst case by randomly choose an element as pivot. In implementation, we can swap
     * first element with a random element, then choose first element as pivot.
     */
    private int partition(List<Map.Entry<Integer, Integer>> entries, int s, int e) {
        Map.Entry<Integer, Integer> pivot = entries.get(s);
        int i = s, j = e;
        while (i < j) {
            while (i < j && entries.get(j).getValue() <= pivot.getValue()) {
                j--;
            }
            if (i < j) {
                entries.set(i, entries.get(j));
            }
            while (i < j && entries.get(i).getValue() >= pivot.getValue()) {
                i++;
            }
            if (i < j) {
                entries.set(j, entries.get(i));
            }
        }
        entries.set(i, pivot);
        return i;
    }
}
