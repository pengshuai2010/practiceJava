package lintCode;

import java.util.HashSet;
import java.util.Set;

public class Q189 {
	/**
	 * @param A:
	 *            an array of integers
	 * @return: an integer
	 */
	public int firstMissingPositive(int[] A) {
		if (A == null || A.length == 0)
			return 1;
		Set<Integer> set = new HashSet<Integer>();
		for (int item : A) {
			set.add(item);
		}
		for (int i = 1;; i++)
			if (!set.contains(i))
				return i;
	}

	public static void main(String[] args) {
		// int[] A = new int[] {1,2,0};
		// int[] A = new int[] {3,4,-1,1};
		// int[] A = new int[] {};
		int[] A = new int[] { 1, 1, 3 };
		int res = new Q189().firstMissingPositive(A);
		System.out.println(res);
	}

}
