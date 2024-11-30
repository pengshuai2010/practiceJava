package leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q347_TopKFrequentElements_MaxHeap {
    public int[] topKFrequent(int[] nums, int k) {
        if (k > nums.length || k < 0) {
            throw new IllegalArgumentException("invalid input");
        }
        Map<Integer, Item> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, new Item(num, 0));
            }
            map.get(num).count += 1;
        }
        PriorityQueue<Item> heap = new PriorityQueue<>(map.values());
        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = heap.remove().number;
        }
        return answer;
    }
}

// Is it actually a good idea to implement a Comparable in this case? This comparable implementation
// is NOT natural order. We make it implement Comparable only so that PriorityQueue can initialize
// in O(n) time.
class Item implements Comparable<Item> {
    int number;
    int count;// ommit getter and setter

    Item(int number, int count) {
        this.number = number;
        this.count = count;
    }

    @Override
    public int compareTo(Item other) {
        return other.count - this.count; // descending order
    }
}
