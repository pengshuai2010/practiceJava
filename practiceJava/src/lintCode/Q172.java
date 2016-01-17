package lintCode;

import java.util.Arrays;

public class Q172 {
	/*
	 * Remove Element Show result
	 * 
	 * Given an array and a value, remove all occurrences of that value in place
	 * and return the new length.
	 * 
	 * The order of elements can be changed, and the elements after the new
	 * length don't matter. Example Given an array [0,4,4,0,0,2,4,4], value=4
	 * 
	 * return 4 and front four elements of the array is [0,0,0,2]
	 */
	/**
	 * @param A:
	 *            A list of integers
	 * @param elem:
	 *            An integer
	 * @return: The new length after remove
	 */
	public int removeElement(int[] A, int elem) {
		int i = 0;
		int j = A.length - 1;
		while (i <= j) {
			if (A[i] == elem) {
				while (A[j] == elem && j > i)
					j--;
				if (i == j)
					break;
				swap(A, i, j);
			}
			i++;
		}
		return i;
	}

	private static void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	public static void main(String[] args) {
		// int[] A = new int[] {0,4,4,0,0,2,4,4};
		// int[] A = new int[] {0,0,0,2,};
		int[] A = new int[] { 4, 4, 4 };
		int elem = 4;
		int res = new Q172().removeElement(A, elem);
		System.out.println(Arrays.toString(A));
		System.out.println(res);
	}

}
