package leetCode;

/**
 * Created by speng on 12/2/16.
 */
public class Q88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {//ask interviewer if in asendent order
        if (nums1 == null || nums2 == null || nums1.length < m + n || nums2.length < n) {
            return;
        }
        int index = m + n - 1;
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[index] = nums1[i];
                i--;
            } else {
                nums1[index] = nums2[j];
                j--;
            }
            index--;
        }
        while (j >= 0) {
            nums1[index] = nums2[j];
            j--;
            index--;
        }
    }
}
