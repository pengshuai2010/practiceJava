package lintCode;

public class Q62_SearchInRotatedSortedArray {
    /**
     * @param a      : an integer rotated sorted array
     * @param target :  an integer to be searched
     *               return : an integer
     */
    public int search(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }
        int low = 0;
        int high = a.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > a[high]) {//[low, mid] is sorted
                if (target >= a[low] && target <= a[mid]) {
                    high = mid;
                } else {
                    low = mid;
                }
            } else {//[mid, high] is sorted
                if (target >= a[mid] && target <= a[high]) {
                    low = mid;
                } else {
                    high = mid;
                }
            }
        }
        if (a[low] == target) {
            return low;
        }
        if (a[high] == target) {
            return high;
        }
        return -1;
    }

}
