package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by speng on 1/2/17.
 */
public class Q274_H_Index {
    /**
     * use max heap. Takes O(n + h*log(n)) time.
     */
    public int hIndex1(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(citations.length, Collections.reverseOrder());
        List<Integer> list = new ArrayList<>();
        for (int num : citations) {
            list.add(num);
        }
        //many corner cases to consider [0], [6, 5], [6, 2], [6, 1]
        maxHeap.addAll(list);
        int h = 0;
        while (!maxHeap.isEmpty() && maxHeap.poll() > h) {
            h++;
        }
        return h;
    }

    /**
     * O(n) time.
     * The intuition is that, if the citations are sorted, we can find out h-index in O(n) time. And notice
     * the fact that the range of h-index is limited to [0, n], we can use bucket sort, which takes only O(n) time!
     */
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int[] table = new int[n + 1];
        for (int num : citations) {
            if (num > n) {
                table[n]++;
            } else {
                table[num]++;
            }
        }
        int sum = 0;
        for (int i = n; i >= 1; i--) {
            sum += table[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
}
