package lintCode;

public class Q130_Heapify {
    /**
     * @param a: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        for (int i = a.length / 2; i >= 0; i--) {
            siftDown(a, i);
        }
    }

    private void siftDown(int[] nums, int index) {
        while (index < nums.length) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int minIndex = index;
            if (left < nums.length && nums[left] < nums[minIndex]) {
                minIndex = left;
            }
            if (right < nums.length && nums[right] < nums[minIndex]) {
                minIndex = right;
            }
            if (minIndex == index) {
                break;
            }
            swap(nums, index, minIndex);
            index = minIndex;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
