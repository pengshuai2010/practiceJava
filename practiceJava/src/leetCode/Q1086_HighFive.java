package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q1086_HighFive {
    // time complexity: O(n) + O(m * log(m)), where n is the number of items.
    // space compleixty: O(n)
    public int[][] highFive(int[][] items) {
        // clarifying question: is it guranteed that each studnet will have at least 5 scores?
        int k = 5;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int[] item : items) {
            int id = item[0];
            int score = item[1];
            if (!map.containsKey(id)) {
                map.put(id, new PriorityQueue<>());
            }
            PriorityQueue<Integer> minHeap = map.get(id);
            if (minHeap.size() < k) {
                minHeap.add(score);
            } else if (score > minHeap.element()) {
                minHeap.remove();
                minHeap.add(score);
            }
        }
        int[][] highAverage = new int[map.size()][2];
        int index = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            int id = entry.getKey();
            PriorityQueue<Integer> minHeap = entry.getValue();
            int sum = 0;
            while (!minHeap.isEmpty()) {
                sum += minHeap.remove();
            }
            int average = sum / k;
            highAverage[index][0] = id;
            highAverage[index][1] = average;
            index++;
        }
        Arrays.sort(highAverage, (int[] a, int[] b) -> a[0] - b[0]);
        return highAverage;
    }
}
