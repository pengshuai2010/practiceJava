package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by speng on 11/25/16.
 */
public class Q215_KthLargestElementInAnArray_MaxHeap {
    public static void main(String[] args) {
        Q215_KthLargestElementInAnArray_MaxHeap solution = new Q215_KthLargestElementInAnArray_MaxHeap();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(solution.findKthLargest(new int[]{1, 5, 1, 1, 6, 4}, 2));
    }

    // max heap solution.
    // time compleixty O(n) + O(k * log(n)), where n is nums.length.
    // space compelxity is O(n)
    public int findKthLargest(int[] nums, int k) {
        // clarifying questions: nums == null? , nums empty? nums.length < k?
        // what to do if k > nums.length?
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            // add negative sign so that we can turn a min heap to a max heap.
            list.add(-num);
        }
        // heapify take O(n) time. To take advantage of that, we must initialize the PriorityQueue from a collection.
        PriorityQueue<Integer> heap = new PriorityQueue<>(list);
        for (int i = 0; i < k - 1; i++) {
            heap.remove();
        }
        return -heap.remove();
    }
}
