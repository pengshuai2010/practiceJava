package leetCode;

import java.util.*;

/**
 * Created by speng on 11/25/16.
 */
public class Q215_KthLargestElementInAnArray {
    public static void main(String[] args) {
        Q215_KthLargestElementInAnArray solution = new Q215_KthLargestElementInAnArray();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(solution.findKthLargest(new int[]{1, 5, 1, 1, 6, 4}, 2));
    }

    /**
     * use max heap. Initially building the heap take O(n) time, then taking out k largest elements takes O(k*log(n)) time.
     */
    public int findKthLargest1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1)
            throw new RuntimeException("invalid input");
        List<Integer> list = new ArrayList<>();
        for (int num : nums)
            list.add(num);
        Queue<Integer> heap = new PriorityQueue<>(list.size(), new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        heap.addAll(list);
        for (int i = 1; i < k; i++) {
            heap.poll();
        }
        return heap.poll();
    }

    private static int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && nums[right] < pivot) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
                left++;
            }
            while (left < right && nums[left] >= pivot) {
                left++;
            }
            if (left < right) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = pivot;
        return left;
    }

    /**
     * In problems like find kth element etc., k almost always starts from 1. If not sure, ask interviewer!
     * <p>
     * quick selection. Use partition to find kth largest/smallest element. Average time complexity O(n). Worst
     * case time complexity O(n^2). By shuffling the input array or selecting a good/random pivot in partition,
     * we can get almost-certain linear time.
     */
    public int findKthLargest(int[] nums, int k) {
        // clarifying questions: nums == null? , nums empty? nums.length < k?
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int index = partition(nums, start, end);
            if (index < k - 1) {
                start = index + 1;
            } else if (index > k - 1) {
                end = index - 1;
            } else {
                return nums[index];
            }
        }
        return nums[start];
    }
}
