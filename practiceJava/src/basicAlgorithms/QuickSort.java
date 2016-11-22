package basicAlgorithms;

/**
 * Created by speng on 11/16/16.
 */
public class QuickSort {
    public static void main(String[] args) {
        QuickSort solution = new QuickSort();
        int[][] inputs = new int[][]{{8, 7, -1, 0, 2, 10, 1, -1}, {0, 0, 0, 0}, {1, 2, 3, 4}, {4, 3, 2, 1}};
        for (int[] input : inputs) {
            solution.quickSort(input, 0, input.length - 1);
            for (int num : input)
                System.out.print(num + ", ");
            System.out.println();
        }
    }

    public void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int p = partition(nums, low, high);
            quickSort(nums, low, p);
            quickSort(nums, p + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }
            while (i < j && nums[i] < pivot) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = pivot;
        return i;
    }
}
