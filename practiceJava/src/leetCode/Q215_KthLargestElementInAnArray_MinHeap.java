package leetCode;

import java.util.PriorityQueue;

/**
 * Created by speng on 11/25/16.
 */
public class Q215_KthLargestElementInAnArray_MinHeap {
    public static void main(String[] args) {
        Q215_KthLargestElementInAnArray_MinHeap solution = new Q215_KthLargestElementInAnArray_MinHeap();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(solution.findKthLargest(new int[]{1, 5, 1, 1, 6, 4}, 2));
    }

    // min heap solution.
    // worst case time compleixty O(n * log(k)), where n is nums.length.
    // space complexity O(k)
    public int findKthLargest(int[] nums, int k) {
        // clarifying questions: nums == null? , nums empty? nums.length < k?
        // what to do if k > nums.length?
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.element()) {
                minHeap.remove();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.remove();
    }
}
