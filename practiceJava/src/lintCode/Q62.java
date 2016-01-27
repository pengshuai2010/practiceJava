package lintCode;

public class Q62 {
	/*
	 * Search in Rotated Sorted Array Show result
	 * 
	 * Suppose a sorted array is rotated at some pivot unknown to you
	 * beforehand.
	 * 
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * 
	 * You are given a target value to search. If found in the array return its
	 * index, otherwise return -1.
	 * 
	 * You may assume no duplicate exists in the array.
	 * 
	 * Example For [4, 5, 1, 2, 3] and target=1, return 2.
	 * 
	 * For [4, 5, 1, 2, 3] and target=0, return -1.
	 * 
	 * Challenge O(logN) time
	 */
	/**
	 * @param A
	 *            : an integer rotated sorted array
	 * @param target
	 *            : an integer to be searched return : an integer
	 */
	public int search(int[] A, int target) {
		if (A == null || A.length == 0)
			return -1;
		int s = 0;
		int e = A.length - 1;
		int mid = s + (e - s) / 2;
		while (s <= e) {
			mid = s + (e - s) / 2;
			if (A[mid] == target)
				return mid;
			// left part of the region is ordered
			if (A[s] <= A[mid])
				// target is in the left part(including mid)
				if (target >= A[s] && target < A[mid])
					e = mid - 1;
				else
					s = mid + 1;
			// right part of the region is ordered
			else if (target > A[mid] && target <= A[e])
				s = mid + 1;
			else 
				e = mid - 1;
		}
		return -1;
	}

	public static void main(String[] args) {
//		int[] A = new int[] { 4, 5, 1, 2, 3 };
		 int[] A = new int[] {1, 2, 3};
		// int[] A = new int[] {};
		int target = 1;
		int res = new Q62().search(A, target);
		System.out.println(res);

	}

}
