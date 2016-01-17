package lintCode;

import java.util.Arrays;

public class Q64 {
	/*
	 * Merge Sorted Array Show result 

Given two sorted integer arrays A and B, merge B into A as one sorted array.

Example
A = [1, 2, 3, empty, empty], B = [4, 5]

After merge, A will be filled as [1, 2, 3, 4, 5]
	 */
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
    	int i, j, k;
    	for (i = m - 1, j = n - 1, k = m + n - 1; i >= 0 && j >= 0; k--) {
    		if (A[i] > B[j]) {
    			A[k] = A[i];
    			i--;
    		}
    		else {
    			A[k] = B[j];
    			j--;
    		}
    	}
    	if (i < 0) {
    		for (; j >= 0; j--, k--) {
    			A[k] = B[j];
    		}
    	}
    }
	public static void main(String[] args) {
//		int[] A = new int[] {1, 2, 3, 0, 0};
//		int m = 3;
//		int[] B = new int[] {4, 5};
//		int n = 2;
//		int[] A = new int[] {0, 0 };
//		int m = 0;
//		int[] B = new int[] {4, 5};
//		int n = 2;,
		int[] A = new int[] {1, 2 };
		int m = 2;
		int[] B = new int[] {0, 0};
		int n = 0;

		new Q64().mergeSortedArray(A, m, B, n);
		System.out.println(Arrays.toString(A));
	}

}
