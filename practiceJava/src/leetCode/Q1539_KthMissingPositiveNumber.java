package leetCode;

public class Q1539_KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        // will k be less than 1? Kth missing number greater than arr[arr.length - 1]?
        // will arr be empty?
        if (k > arr[arr.length - 1] - arr.length) {
            return k + arr.length;
        }
        // edge case
        if (k <= arr[0] - 1) {
            return k;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (k > arr[end] - (end + 1)) {
            return k + end + 1;
        }
        return k + start + 1;
    }
}
