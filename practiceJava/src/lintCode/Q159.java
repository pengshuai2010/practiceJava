package lintCode;

public class Q159 {
	/*
	 * Find Minimum in Rotated Sorted Array Show result
	 * 
	 * Suppose a sorted array is rotated at some pivot unknown to you
	 * beforehand.
	 * 
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * 
	 * Find the minimum element.
	 * 
	 * Example Given [4, 5, 6, 7, 0, 1, 2] return 0
	 * 
	 * Note You may assume no duplicate exists in the array.
	 */
	/**
	 * @param num:
	 *            a rotated sorted array
	 * @return: the minimum number in the array
	 */
	public int findMin(int[] num) {
		/*
		 * num[s] <= num[e] means that this part is ordered, num[s] is the least
		 * num[mid] >= num[s] means the left part is ordered, the least number must
		 * be in the right part(not including mid itself);
		 * num[mid] < num[s] means the pivot must be in the left part(including mid
		 * itself)
		 */
		int s = 0;
		int e = num.length - 1;
		int mid = (s + e) / 2;
		while (s <= e) {
			mid = (s + e) / 2;
			if (num[s] <= num[e]) {
				return num[s];
			}
			if (num[mid] >= num[s])
				s = mid + 1;
			else
				e = mid;
		}
		return num[mid];
	}

	public static void main(String[] args) {
		int[] num = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		// int[] num = new int[] {4, 5, 6, 7, 8, 9, 2};
		// int[] num = new int[] {6, 0, 1, 2, 3, 4, 5};
		// int[] num = new int[] {6, 1, 2, 3, 4, 5};
		// int[] num = new int[] {0, 1, 2, 3, 4, 5};
		int res = new Q159().findMin(num);
		System.out.println(res);
	}

}
