package lintCode;

/**
 * Created by speng on 2/12/17.
 */
public class Q65_MedianOfTwoSortedArrays {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A == null || B == null) {
            throw new java.lang.IllegalArgumentException();
        }
        int total = A.length + B.length;
        int k = (total + 1) / 2;
        if (total % 2 == 0) {
            return (findKthInSortedArrays(A, B, k) + findKthInSortedArrays(A, B, k + 1)) / 2.0;
        }
        return findKthInSortedArrays(A, B, k);
    }

    /**
     * The idea is to discard (k / 2) elements that are impossible to be the k-th smallest element each time, then
     * k = k - (k / 2), repeat the process until k == 1. Now the smaller of A[indexA] and B[indexB] is the number we
     * are looking for.
     * <p>
     * This idea is somewhat similar to binary search. Each time we discard half of the elements, so we can find the
     * target in log(k) time.
     *
     * @param A a sorted array
     * @param B a sorted array
     * @param k
     * @return the k-th smallest element in the merged array of A and B. k starts from 1.
     */
    private int findKthInSortedArrays(int[] A, int[] B, int k) {
        int indexA = 0;
        int indexB = 0;
        while (k > 1) {
            //It's possible that (indexA + k / 2 - 1) is out of bound of array A. We can pad A with Integer.MAX_VALUE,
            //so that indexA will not move to (indexA + k / 2 - 1)
            int valA = Integer.MAX_VALUE;
            int valB = Integer.MAX_VALUE;
            if (indexA + k / 2 - 1 < A.length) {
                valA = A[indexA + k / 2 - 1];
            }
            if (indexB + k / 2 - 1 < B.length) {
                valB = B[indexB + k / 2 - 1];
            }
            //when A[indexA + k / 2 - 1] is less than B[indexB + k / 2 - 1], it can be proved that numbers in the subarray
            // A[0, ..., indexA + k / 2 - 1] are impossible to be the k-th smallest number. We can discard them by moving
            // indexA to (indexA + k / 2), and accordingly, deduct (k / 2) from k.
            if (valA <= valB) {
                indexA = indexA + k / 2;
            } else {
                indexB = indexB + k / 2;
            }
            k -= k / 2;
        }
        if (indexA >= A.length) {
            return B[indexB];
        }
        if (indexB >= B.length) {
            return A[indexA];
        }
        if (A[indexA] < B[indexB]) {
            return A[indexA];
        }
        return B[indexB];
    }
}
