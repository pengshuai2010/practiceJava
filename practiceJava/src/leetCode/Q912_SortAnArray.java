package leetCode;

public class Q912_SortAnArray {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) { // to avoid index out of bound caused by the range [left, index - 1] and [index + 1, right] below
            return;
        }
        int index = partition(nums, left, right);
        quickSort(nums, left, index - 1);
        quickSort(nums, index + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        // pick a pivot.
        // Simply picking nums[left] results in the worst performance in an already sorted array.
        // Median of nums[left], nums[mid], nums[right] would be a better pivot
        int index = left + (right - left) / 2;
        int pivot = nums[index]; // swap with left most element
        nums[index] = nums[left];
        nums[left] = pivot;
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
                left++;
            }
            while (left < right && nums[left] < pivot) {
                left++;
            }
            if (left < right) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = pivot; // place the pivot back at the partition line
        return left;
    }
}
