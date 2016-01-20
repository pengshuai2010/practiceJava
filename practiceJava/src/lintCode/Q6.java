package lintCode;

import java.util.Arrays;

public class Q6 {
	/*
	 * Merge Sorted Array II Show result
	 * 
	 * Merge two given sorted integer array A and B into a new sorted integer
	 * array.
	 * 
	 * B=[2,4,5,6]
	 * 
	 * return [1,2,2,3,4,4,5,6]
	 */
	/**
	 * @param A
	 *            and B: sorted integer array A and B.
	 * @return: A new sorted integer array
	 */
	public int[] mergeSortedArray(int[] A, int[] B) {
		int i, j, k;
		int m = A.length;
		int n = B.length;
		int[] C = new int[m + n];
		for (i = m - 1, j = n - 1, k = m + n - 1; i >= 0 && j >= 0; k--) {
			if (A[i] > B[j]) {
				C[k] = A[i];
				i--;
			} else {
				C[k] = B[j];
				j--;
			}
		}
		if (i < 0) {
			for (; j >= 0; j--, k--) {
				C[k] = B[j];
			}
		} else {
			for (; i >= 0; i--, k--) {
				C[k] = A[i];
			}
		}
		return C;
	}

	public static void main(String[] args) {
		int[] A = new int[] { 1, 2, 3, 4 };
		int[] B = new int[] { 2, 4, 5, 6 };
		int[] res = new Q6().mergeSortedArray(A, B);
		System.out.println(Arrays.toString(res));
	}

}
