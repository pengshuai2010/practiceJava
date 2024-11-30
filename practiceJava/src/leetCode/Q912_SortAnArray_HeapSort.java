package leetCode;

public class Q912_SortAnArray_HeapSort {
    // max heap heapify
    // The time complexity of heapify is O(n). That's because in the worst case, the bottom
    // n/2 elements are not swaped, n/4 elements are swapped once, n/8 elements are swapped twice,
    // ..., the total number of swaps is n/4 + 2*n/8 + 3*n/16 + ... +  log(n) * 1 = O(n)
    private static void heapify(int[] nums) {
        for (int i = nums.length / 2; i >= 0; i--) {
            siftDown(nums, i, nums.length);
        }
    }

    private static void sort(int[] nums) {
        for (int end = nums.length - 1; end > 0; end--) { // end >= 0 is not wrong, but not necessary
            swap(nums, 0, end);
            siftDown(nums, 0, end);
        }
    }

    // max heap sift down
    private static void siftDown(int[] nums, int index, int length) {
        while (index < length) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int maxIndex = index;
            if (left < length && nums[left] > nums[maxIndex]) {
                maxIndex = left;
            }
            if (right < length && nums[right] > nums[maxIndex]) {
                maxIndex = right;
            }
            if (maxIndex == index) {
                break;
            }
            swap(nums, maxIndex, index);
            index = maxIndex;
        }
    }

    private static void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        heapify(nums);
        sort(nums);
        return nums;
    }
}
