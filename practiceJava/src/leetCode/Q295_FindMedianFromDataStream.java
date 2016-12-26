package leetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by speng on 12/25/16.
 */
public class Q295_FindMedianFromDataStream {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public Q295_FindMedianFromDataStream() {
        maxHeap = new PriorityQueue<>(10, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {//note argument type should be Integer instead of int
                return b - a;
            }
        });
        minHeap = new PriorityQueue<>();
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (maxHeap.size() > 0 && num < maxHeap.peek()) {
            maxHeap.offer(num);
        } else if (minHeap.size() > 0 && num > minHeap.peek()) {
            minHeap.offer(num);
        } else {
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
        }
        if (maxHeap.size() - minHeap.size() > 1) {
            int val = maxHeap.poll();
            minHeap.offer(val);
        } else if (maxHeap.size() - minHeap.size() < -1) {
            int val = minHeap.poll();
            maxHeap.offer(val);
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        int val1 = 0, val2 = 0;
        if (maxHeap.size() > 0) {
            val1 = maxHeap.peek();
        }
        if (minHeap.size() > 0) {
            val2 = minHeap.peek();
        }
        if (maxHeap.size() > minHeap.size()) {
            return val1;
        }
        if (maxHeap.size() < minHeap.size()) {
            return val2;
        }
        return (val1 + val2) / 2.0;
    }
}
