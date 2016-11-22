package basicAlgorithms;

/**
 * Created by speng on 11/16/16.
 */
public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch solution = new BinarySearch();
        int[][] inputs = new int[][]{{1, 2, 4, 4, 5}, {1, 2, 3, 5}, {1, 2, 4}, {4}};
        for (int[] input : inputs) {
            System.out.println(solution.binarySearch(input, 4));
        }
    }

    public int binarySearch(int[] a, int target) {
        if (a == null || a.length == 0)
            return -1;
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] < target) {
                left = mid + 1;
            } else if (a[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
