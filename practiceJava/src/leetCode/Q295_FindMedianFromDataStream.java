package leetCode;

import java.util.PriorityQueue;

/**
 * Created by speng on 12/25/16.
 */
public class Q295_FindMedianFromDataStream {
    private final PriorityQueue<Integer> maxHeap;
    private final PriorityQueue<Integer> minHeap;

    public Q295_FindMedianFromDataStream() {
        this.maxHeap = new PriorityQueue<>((Integer a, Integer b) -> b - a);
        this.minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // we need to maintain two invariants:
        // 1. maxHeap.element() <= minHeap.element()
        // 2. minHeap size == maxHeap size  or minHeap size = maxheap size + 1
        maxHeap.add(num);
        minHeap.add(maxHeap.remove()); // always do this to maintain Invariant (1)
        if (minHeap.size() > maxHeap.size() + 1) { // this maintains Invariant (2)
            this.maxHeap.add(this.minHeap.remove());
        }
    }

    public double findMedian() {
        // clarify what to do if findMedian is invoked before any number is added
        if (this.minHeap.size() > this.maxHeap.size()) {
            return this.minHeap.element();
        }
        return (this.minHeap.element() + this.maxHeap.element()) / 2.0;
    }
}
