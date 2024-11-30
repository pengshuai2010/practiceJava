package leetCode;

/**
 * Created by speng on 11/25/16.
 */
public class Q215_KthLargestElementInAnArray_QuickSort {
    public static void main(String[] args) {
        Q215_KthLargestElementInAnArray_QuickSort solution = new Q215_KthLargestElementInAnArray_QuickSort();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(solution.findKthLargest(new int[]{1, 5, 1, 1, 6, 4}, 2));
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
