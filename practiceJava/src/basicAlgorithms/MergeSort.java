package basicAlgorithms;

/**
 * Created by speng on 11/16/16.
 */
public class MergeSort {
    public static void main(String[] args) {
        MergeSort solution = new MergeSort();
        int[][] inputs = new int[][]{{8, 7, -1, 0, 2, 10, 1, -1}, {0, 0, 0, 0}, {1, 2, 3, 4}, {4, 3, 2, 1}};
        for (int[] input : inputs) {
            solution.mergeSort(input);
            for (int num : input)
                System.out.print(num + ", ");
            System.out.println();
        }
    }

    public void mergeSort(int[] a) {
        mergeSort(a, new int[a.length], 0, a.length - 1);
    }

    public void mergeSort(int[] a, int[] buffer, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(a, buffer, left, mid);
            mergeSort(a, buffer, mid + 1, right);
            merge(a, buffer, left, mid, right);
        }
    }

    private void merge(int[] a, int[] buffer, int left, int mid, int right) {
        int i = left, j = mid + 1, index = 0;
        while (i <= mid && j <= right) {
            if (a[i] < a[j]) {
                buffer[index++] = a[i++];
            } else {
                buffer[index++] = a[j++];
            }
        }
        while (i <= mid) {
            buffer[index++] = a[i++];
        }
        System.arraycopy(buffer, 0, a, left, index);//note that buffer starts from 0 but a starts from left
    }
}
